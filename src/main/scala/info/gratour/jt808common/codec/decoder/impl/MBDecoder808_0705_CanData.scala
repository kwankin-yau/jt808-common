/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect

import java.time.LocalTime
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0705_CanData
import info.gratour.jt808common.protocol.msg.types.JT808CanData
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0705_CanData
import info.gratour.jtcommon.{BcdUtils, JTUtils}
import io.netty.buffer.ByteBuf

object MBDecoder808_0705_CanData extends JT808MsgBodyDecoder[JT808Msg_0705_CanData]{

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0705_CanData, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val cnt = body.readUnsignedShort()
    body.readBytes(tempBuf, 0, 5)
    val h = BcdUtils.decodeByte(tempBuf(0))
    val min = BcdUtils.decodeByte(tempBuf(1))
    val s = BcdUtils.decodeByte(tempBuf(2))
    val ms = BcdUtils.decodeByte(tempBuf(3)) * 100 + BcdUtils.decodeByte(tempBuf(4))

    m.setReceiveTime(LocalTime.of(h, min, s, ms * 1000))

    val canDataArr = new Array[JT808CanData](cnt)
    for (i <- 0 until cnt) {
      val canData = new JT808CanData
      val canId = body.readInt()
      canData.setId(canId & 0x1FFFFFFF)
      canData.setCalculated(JTUtils.test(canId, 29))
      canData.setExtFrame(JTUtils.test(canId, 30))
      canData.setCan2(JTUtils.test(canId, 31))

      val data = new Array[Byte](4)
      body.readBytes(data)
      canData.setData(data)

      canDataArr(i) = canData
    }
    val info = new MQEventAddt_0705_CanData
    info.setData(canDataArr)
    m.setCanData(info)
  }

}
