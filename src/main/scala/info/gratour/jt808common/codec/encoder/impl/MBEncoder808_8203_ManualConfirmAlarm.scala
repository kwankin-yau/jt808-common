/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8203_ManualConfirmAlarm
import io.netty.buffer.ByteBuf

object MBEncoder808_8203_ManualConfirmAlarm extends AbstractJT808MsgBodyEncoder[JT808Msg_8203_ManualConfirmAlarm] {

  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8203_ManualConfirmAlarm, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    out.writeShort(params.getAckSeqNo)
    out.writeInt(params.getConfirmAlarmTypes)
  }
}
