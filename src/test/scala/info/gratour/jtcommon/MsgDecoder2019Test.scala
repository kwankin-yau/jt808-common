/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import java.util

import info.gratour.jt808common.JT808ProtocolVariant
import info.gratour.jt808common.codec.decoder.{DecodeState, JT808FrameDecoder, JT808MsgDecoder}
import io.netty.buffer.{ByteBuf, UnpooledByteBufAllocator}

object MsgDecoder2019Test {

  val frameDecoder: JT808FrameDecoder = new JT808FrameDecoder(UnpooledByteBufAllocator.DEFAULT)
  val decoder: JT808MsgDecoder = JT808MsgDecoder(JT808ProtocolVariant.GDRTA_2020)

  def main(args: Array[String]): Unit = {
    val packet = UnpooledByteBufAllocator.DEFAULT.buffer()
    val decodedList = new util.ArrayList[ByteBuf]()
    val tempBuf = JT808FrameDecoder.allocTempBuf()
    try {

      def test(hex: String): Unit = {
        val bytes = JTUtils.hex(hex)
        packet.clear()
        packet.writeBytes(bytes)

        val st = frameDecoder.splitAndUnescape(packet)
        assert(st == DecodeState.DECODED)

        decodedList.clear()
        frameDecoder.getSplit(decodedList)
        decodedList.forEach(b => {
          val f = frameDecoder.decodeFrame(b, tempBuf)
          assert(f != null)

          val m = decoder.decode(f, tempBuf)
          println("DECODED: " + m.toString)
        })
      }

      test("7e0100405401000000000133051893410003002c012f343430333030373031313100000000000000000000000000000000000000000042534a2d474630365435313839333431000000000000000000000000000000000000000000000002d4c1423838383838a67e")
    } finally {
      packet.release()
    }
  }
}
