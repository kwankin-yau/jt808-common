/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.JT808Utils
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9206_AVUploadReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder1078_9206_AVUploadReq extends AbstractJT808MsgBodyEncoder[JT1078Msg_9206_AVUploadReq] {
  override protected def encodeBody(m: JT1078Msg_9206_AVUploadReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpHost, "serverIp"))
    out.writeShort(p.getFtpPort)
    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpUser, "userName"))
    out.writeByteLenPrefixedStr(checkNotNull(p.getFtpPwd, "password"))
    out.writeByteLenPrefixedStr(checkNotNull(p.getUploadPath, "path"))
    out.writeByte(p.getChannel)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTime))
    out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTime))
    out.writeInt(p.getAlarmStateFilter1078)
    out.writeInt(p.getAlarmStateFilter808)
    out.writeByte(p.getMediaType)
    out.writeByte(p.getCodeStream)
    out.writeByte(p.getStorageType)
    out.writeByte(p.getWhen)
  }
}
