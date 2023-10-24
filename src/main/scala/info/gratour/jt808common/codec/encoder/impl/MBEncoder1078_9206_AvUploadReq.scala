/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9206_AvUploadReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder1078_9206_AvUploadReq extends AbstractJT808MsgBodyEncoder[JT1078Msg_9206_AvUploadReq] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9206_AvUploadReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpHost, "serverIp"))
    out.writeShort(p.getFtpPort)
    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpUser, "userName"))
    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpPwd, "password"))
    out.writeByteLenPrefixedStr(checkNotNull(p.getUploadPath, "path"))
    out.writeByte(p.getChan)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTm))
    out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTm))
    out.writeInt(p.getAlmFilter1078)
    out.writeInt(p.getAlmFilter808)
    out.writeByte(p.getMediaTyp)
    out.writeByte(p.getCodeStrm)
    out.writeByte(p.getStgTyp)
    out.writeByte(p.getWhen)
  }
}
