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
import info.gratour.jt808common.{AdasDialect, TimerProvider}
import info.gratour.jtcommon.NettyUtils
import io.netty.buffer.{ByteBuf, ByteBufAllocator, Unpooled, UnpooledByteBufAllocator}
import org.apache.commons.codec.binary.Hex
import org.checkerframework.checker.nullness.qual.{NonNull, Nullable}

import java.util

abstract class AbstractJT808Decoder(
                                     adasDialect           : AdasDialect,
                                     alloc                 : ByteBufAllocator,
                                     timerProvider         : TimerProvider,
                                     ignoreDecodeFrameError: Boolean,
                                     simplified            : Boolean,
                                     verifyCrc             : Boolean
                                   ) extends AutoCloseable {

  private val frameDecoder = new JT808FrameDecoder(alloc)
  private val decodeTempBuf = JT808FrameDecoder.allocTempBuf()
  private val splitList = new util.ArrayList[ByteBuf]()
  private val msgDecoder = new JT808MsgDecoder(adasDialect, simplified)
  private val fragmentManager = new JT808PacketFragmentManager(alloc, timerProvider)
  private var protoVer: Option[Byte] = None
  private var simNo: String = _

  private val fragmentTimeoutCallback = new FragmentTimeoutCallback {
    override def onFragmentTimeout(collectedFragment: CollectedFragment): Unit = {
      throw new CodecError("Fragment collect timeout.")
    }
  }

  def onMsgRecv(m: JT808Msg, customData: AnyRef): Unit

  override def close(): Unit = {
    frameDecoder.close()
    fragmentManager.close()
  }

  private def frameRecv(frame: JT808Frame, customData: AnyRef): Unit = {
    try {
      if (simNo == null) {
        simNo = frame.getHeader.getSimNo
        protoVer = Some(frame.getHeader.getProtoVer)
      }

      val m = msgDecoder.decode(frame, decodeTempBuf)
      onMsgRecv(m, customData)
    } finally {
      frame.release()
    }
  }

  /**
   * Decode buffer to JT808Msg. Decoded message will send to `receiver`.
   *
   * @param buf        ByteBuf contains content to decode.
   * @param customData optional client data, this object will as the `customData` pass to `receiver.onMsgRecv(msg, customData)`.
   * @throws CrcError   if CRC verification failed.
   * @throws CodecError for other codec error.
   *
   */
  def decode(@NonNull buf: ByteBuf, @Nullable customData: AnyRef): Unit = {
    frameDecoder.splitAndUnescape(buf) match {
      case DecodeState.UNRECOGNIZED =>
        throw new CodecError("Unrecognized frame.")

      case DecodeState.DECODED =>
        splitList.clear()
        frameDecoder.getSplit(splitList)

        try {
          splitList.forEach(
            f => {
              val readerIndex = f.readerIndex()
              val frame = JT808FrameDecoder.decodeFrame(f, decodeTempBuf, verifyCrc)
              if (frame == null) {
                if (!ignoreDecodeFrameError) {
                  f.readerIndex(readerIndex)
                  throw new CodecError("Unable decode frame: " + NettyUtils.bufToHex(f))
                }
              } else {
                if (frame.getHeader.isSplit) {
                  val p = fragmentManager.collect(frame, fragmentTimeoutCallback)
                  if (p != null) {
                    frameRecv(p, customData)
                  }
                } else
                  frameRecv(frame, customData)
              }
            }
          )
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

trait JT808MsgReceiver {
  def onMsgRecv(@NonNull m: JT808Msg, @Nullable customData: AnyRef): Unit
}



class JT808Decoder(
                    adasDialect           : AdasDialect,
                    alloc                 : ByteBufAllocator,
                    timerProvider         : TimerProvider,
                    receiver              : JT808MsgReceiver,
                    ignoreDecodeFrameError: Boolean,
                    simplified            : Boolean,
                    verifyCrc             : Boolean
                  )
  extends AbstractJT808Decoder(
    adasDialect,
    alloc,
    timerProvider,
    ignoreDecodeFrameError,
    simplified,
    verifyCrc
  ) {
  override def onMsgRecv(m: JT808Msg, customData: AnyRef): Unit = receiver.onMsgRecv(m, customData)
}

//object JT808Decoder {
//  //  private final val EMPTY_RESULT: java.util.List[JT808Msg] = new util.ArrayList[JT808Msg]()
//
//  def decodeAndPrint(packetDataHex: String): Unit = {
//    val bytes = Hex.decodeHex(packetDataHex)
//    val buf = Unpooled.wrappedBuffer(bytes)
//    try {
//      val decoder = new JT808Decoder(
//        AdasDialect.GDRTA_2020, UnpooledByteBufAllocator.DEFAULT, null, new JT808MsgReceiver {
//          override def onMsgRecv(m: JT808Msg, data: AnyRef): Unit = {
//            println(s"Received : ${m}")
//          }
//        }, false, false, true
//      )
//
//      decoder.decode(buf, null)
//    } catch {
//      case t: Throwable =>
//        t.printStackTrace()
//    } finally {
//      buf.release()
//    }
//  }
//
//
//}

