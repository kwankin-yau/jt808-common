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
import info.gratour.jt808common.protocol.msg.JT808Msg_8003_Retransmit
import io.netty.buffer.ByteBuf

object MBEncoder808_8003_Retransmit extends AbstractJT808MsgBodyEncoder[JT808Msg_8003_Retransmit] {
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8003_Retransmit, out: ByteBuf): Unit = {
    out.writeShort(m.getOrigSeqNo)
    out.writeByte(m.getRetransmitPacketIds.length)
    for (id <- m.getRetransmitPacketIds) {
      out.writeShort(id)
    }
  }
}
