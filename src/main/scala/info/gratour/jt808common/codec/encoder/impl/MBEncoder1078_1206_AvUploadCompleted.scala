/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1206_AvUploadCompleted
import io.netty.buffer.ByteBuf

object MBEncoder1078_1206_AvUploadCompleted extends AbstractJT808MsgBodyEncoder[JT1078Msg_1206_AvUploadCompleted] {

  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_1206_AvUploadCompleted, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeByte(m.getResult)
  }

}
