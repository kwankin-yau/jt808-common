/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8301_SetUpEvent
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8301_SetUpEvent extends AbstractJT808MsgBodyEncoder[JT808Msg_8301_SetUpEvent] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8301_SetUpEvent, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    out.writeByte(params.getTyp)
    val list = checkNotNull(params.getEvents, "events")
    if (list.isEmpty)
      throw new CodecError("events is empty")
    out.writeByte(list.length)
    list.foreach(evt => {
      out.writeByte(evt.getEvtId)
      out.writeByteLenPrefixedStr(evt.getEvtContent)
    })
  }
}
