/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment
import info.gratour.jt808common.codec.{CodecError, CrcError}
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}
import info.gratour.jt808common.{JT808ProtocolVariant, TimerProvider}
import info.gratour.jtcommon.NettyUtils
import io.netty.buffer.{ByteBuf, ByteBufAllocator, Unpooled, UnpooledByteBufAllocator}
import org.apache.commons.codec.binary.Hex

import java.util

trait JT808MsgReceiver {
  def onMsgRecv(m: JT808Msg, data: AnyRef): Unit
}

class JT808Decoder(
                    protocolVariant: JT808ProtocolVariant,
                    alloc: ByteBufAllocator,
                    timerProvider: TimerProvider,
                    receiver: JT808MsgReceiver,
                    ignoreDecodeFrameError: Boolean) extends AutoCloseable {

  private val frameDecoder = new JT808FrameDecoder(alloc)
  private val decodeTempBuf = JT808FrameDecoder.allocTempBuf()
  private val splitList = new util.ArrayList[ByteBuf]()
  private val msgDecoder = JT808MsgDecoder(protocolVariant)
  private val fragmentManager = new JT808PacketFragmentManager(alloc, timerProvider)
  private var protoVer: Option[Byte] = None
  private var simNo: String = _

  private val fragmentTimeoutCallback = new FragmentTimeoutCallback {
    override def onFragmentTimeout(collectedFragment: CollectedFragment): Unit = {
      throw new CodecError("Fragment collect timeout.")
    }
  }


  override def close(): Unit = {
    frameDecoder.close()
    fragmentManager.close()
  }

  private def frameRecv(frame: JT808Frame, data: AnyRef): Unit = {
    if (simNo == null) {
      simNo = frame.getHeader.getSimNo
      protoVer = Some(frame.getHeader.getProtoVer)
    }

    val m = msgDecoder.decode(frame, decodeTempBuf)
    receiver.onMsgRecv(m, data)
  }

  /**
   * Decode buffer to JT808Msg. Decoded message will send to `receiver`.
   *
   * @param buf ByteBuf contains content to decode.
   * @param data optional client data, this object will as the `data` pass to `receiver.onMsgRecv(msg, data)`.
   * @throws CrcError   if CRC verification failed.
   * @throws CodecError for other codec error.
   *
   */
  def decode(buf: ByteBuf, data: AnyRef): Unit = {
    frameDecoder.splitAndUnescape(buf) match {
      case DecodeState.UNRECOGNIZED =>
        throw new CodecError("Unrecognized frame.")

      case DecodeState.DECODED =>
        splitList.clear()
        frameDecoder.getSplit(splitList)

        try {
          splitList.forEach(f => {
            val readerIndex = f.readerIndex()
            val frame = JT808FrameDecoder.decodeFrame(f, decodeTempBuf)
            if (frame == null) {
              if (!ignoreDecodeFrameError) {
                f.readerIndex(readerIndex)
                throw new CodecError("Unable decode frame: " + NettyUtils.bufToHex(f))
              }
            } else {
              if (frame.getHeader.isSplit) {
                val p = fragmentManager.collect(frame, fragmentTimeoutCallback)
                if (p != null) {
                  frameRecv(p, data)
                }
              } else
                frameRecv(frame, data)
            }
          })
        } finally {
          splitList.forEach(f => f.release())
          splitList.clear()
        }


      case DecodeState.RECOGNIZED =>

    }
  }

  def getSimNo: String = simNo

  def getProtoVer: Option[Byte] = protoVer
}

object JT808Decoder {
  private val EMPTY_RESULT: java.util.List[JT808Msg] = new util.ArrayList[JT808Msg]()

  def decodeAndPrint(packetDataHex: String): Unit = {
    val bytes = Hex.decodeHex(packetDataHex)
    val buf = Unpooled.wrappedBuffer(bytes)
    try {
      val decoder = new JT808Decoder(JT808ProtocolVariant.GDRTA_2020, UnpooledByteBufAllocator.DEFAULT, null, new JT808MsgReceiver {
        override def onMsgRecv(m: JT808Msg, data: AnyRef): Unit = {
          println(s"Received : ${m}")
        }
      }, false)

      decoder.decode(buf, null)
    } catch {
      case t: Throwable =>
        t.printStackTrace()
    } finally {
      buf.release()
    }
  }

//  def main(args: Array[String]): Unit = {
//    val hex = "7e0200407401000000000133051893675a8c00000000000c000301611bc406c326de000d000000642110200146470104000717a302020000030200001404000000001504000000001604000000001702000025040000000c2b040000000030011b310114eb11000700d40100436ac1000600f800000000ef0d7e"
//    decodeAndPrint(hex)
//  }
}
