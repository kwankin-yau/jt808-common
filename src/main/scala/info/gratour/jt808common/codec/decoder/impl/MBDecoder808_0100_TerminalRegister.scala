/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0100_TerminalRegister
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0100_TermRegister
import info.gratour.jtcommon.{ByteBufHelper, JTConsts}
import io.netty.buffer.ByteBuf

object MBDecoder808_0100_TerminalRegister extends JT808MsgBodyDecoder[JT808Msg_0100_TerminalRegister] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0100_TerminalRegister, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val addt = new MQEventAddt_0100_TermRegister
    addt.setProvinceId(body.readUnsignedShort())
    addt.setCityId(body.readUnsignedShort())

    if (protoVer == PROTO_VER__REV2013) {
      // factoryId
      addt.setFactoryId(body.readStr(5))

      // terminalModel
      if (body.readableBytes() > 28)
        addt.setTerminalModel(body.readCStr(20))
      else
        addt.setTerminalModel(body.readCStr(8))

      // terminalId
      addt.setTerminalId(body.readCStr(7))
    } else {
      // factoryId
      addt.setFactoryId(body.readStr(11))

      // terminalModel
      val model = new Array[Byte](30)
      body.readBytes(model)
      var start = -1
      var i = 0
      while (i < model.length && start == -1) {
        val c = model(i)
        if (c != 0)
          start = i

        i += 1
      }
      if (start == -1) // all zero
        addt.setTerminalModel("");
      else
        addt.setTerminalModel(new String(model, start, model.length - start, JTConsts.DEFAULT_CHARSET))

      // terminalId
      addt.setTerminalId(body.readCStr(30))
    }


    addt.setPlateColor(body.readByte())
    var s = body.readRemainingAsStr()
    val idx = s.lastIndexOf(0)
    if (idx > 0)
      s = s.substring(0, idx)
    else if (idx == 0)
      s = "";
    addt.setPlateNo(s)

    m.setInfo(addt)
  }

}
