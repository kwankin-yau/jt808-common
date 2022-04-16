/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0702_DriverIdentity
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0702_DriverIdentity
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object MBDecoder808_0702_DriverIdentity extends JT808MsgBodyDecoder[JT808Msg_0702_DriverIdentity] {

  private def parseMsgBodyOldFormat(m: JT808Msg_0702_DriverIdentity, body: ByteBuf): Unit = {
    val p = new MQEventAddt_0702_DriverIdentity
    p.setState(MQEventAddt_0702_DriverIdentity.ACT__LOGIN)
    p.setTime(System.currentTimeMillis())
    p.setReadState(MQEventAddt_0702_DriverIdentity.READ_STATE__OK)
    p.setDriverName(body.readByteLenPrefixedStr())
    body.skipBytes(20)
    p.setLicenseNo(body.readStrMaxLen(40))
    p.setIssuer(body.readByteLenPrefixedStr())
    p.setExpireDate("0000-00-00")

    m.setInfo(p)
  }

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0702_DriverIdentity, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val pos = body.readerIndex()
    try {
      val p = new MQEventAddt_0702_DriverIdentity
      p.setState(body.readByte())
      body.readBytes(tempBuf, 0, 6)
      p.setTime(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
      if (p.getState == MQEventAddt_0702_DriverIdentity.ACT__LOGIN && body.isReadable) {
        p.setReadState(body.readUnsignedByte())
        p.setDriverName(body.readByteLenPrefixedStr())
        p.setLicenseNo(body.readStrMaxLen(20))
        p.setIssuer(body.readByteLenPrefixedStr())
        body.readBytes(tempBuf, 0, 4)
        val expireDate: LocalDate =
          try {
            if (tempBuf(0) == 0 && tempBuf(1) == 0 && tempBuf(2) == 0 && tempBuf(3) == 0)
              null
            else
              JT808Utils.bcd4ToLocalDate(tempBuf, 0)
          } catch {
            case t: Throwable =>
              null
          }

        p.setExpireDate(if (expireDate != null) expireDate.format(DateTimeFormatter.ISO_LOCAL_DATE) else "0000-00-00")

        if (protoVer >= PROTO_VER__REV2019) {
          val idCardNum = body.readCStr(20)
          p.setIdCardNum(idCardNum)
        }
      }

      m.setInfo(p)
    } catch {
      case t: Throwable =>
        // try parse old format
        body.readerIndex(pos)
        try {
          parseMsgBodyOldFormat(m, body)
        } catch {
          case _: Throwable =>
            throw t
        }
    }
  }
}
