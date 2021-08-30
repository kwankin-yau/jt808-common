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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9205_QryAVRes
import io.netty.buffer.ByteBuf

object MBEncoder1078_9205_QryAVRes extends AbstractJT808MsgBodyEncoder[JT1078Msg_9205_QryAVRes] {
  override protected def encodeBody(m: JT1078Msg_9205_QryAVRes, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChannel)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTime))
    out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTime))
    out.writeInt(p.getAlarmStateFilter1078)
    out.writeInt(p.getAlarmStateFilter808)
    out.writeByte(p.getMediaType)
    out.writeByte(p.getCodeStream)
    out.writeByte(p.getStorageType)
  }
}
