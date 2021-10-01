/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1206_AVUploadCompleted
import io.netty.buffer.ByteBuf

object MBEncoder1078_1206_AVUploadCompleted extends AbstractJT808MsgBodyEncoder[JT1078Msg_1206_AVUploadCompleted] {

  override protected def encodeBody(m: JT1078Msg_1206_AVUploadCompleted, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeByte(m.getResult)
  }

}
