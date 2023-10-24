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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9205_QryAvRes
import io.netty.buffer.ByteBuf

object MBEncoder1078_9205_QryAvRes extends AbstractJT808MsgBodyEncoder[JT1078Msg_9205_QryAvRes] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9205_QryAvRes, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChan)
    var tm: java.lang.Long = p.getStartTm
    if (tm != null)
      out.writeBytes(JT808Utils.timestampToBcd6(tm))
    else
      out.writeZero(6)

    tm = p.getEndTm
    if (tm != null)
      out.writeBytes(JT808Utils.timestampToBcd6(tm))
    else
      out.writeZero(6)
    out.writeInt(p.getAlmFilter1078)
    out.writeInt(p.getAlmFilter808)
    out.writeByte(p.getMediaTyp)
    out.writeByte(p.getCodeStrm)
    out.writeByte(p.getStgTyp)
  }
}
