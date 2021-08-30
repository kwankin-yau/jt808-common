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
import info.gratour.jt808common.protocol.msg.JT808Msg_8803_StoredMediaReq
import io.netty.buffer.ByteBuf

object MBEncoder808_8803_StoredMediaReq extends AbstractJT808MsgBodyEncoder[JT808Msg_8803_StoredMediaReq] {
  override protected def encodeBody(m: JT808Msg_8803_StoredMediaReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getMediaType)
    out.writeByte(p.getChannelId)
    out.writeByte(p.getEvent)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTime))
    out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTime))
    out.writeByte(p.getDeleteFlag)
  }
}
