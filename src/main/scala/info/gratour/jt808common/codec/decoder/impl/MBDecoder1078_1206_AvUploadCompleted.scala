/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1206_AvUploadCompleted
import io.netty.buffer.ByteBuf

object MBDecoder1078_1206_AvUploadCompleted extends JT808MsgBodyDecoder[JT1078Msg_1206_AvUploadCompleted] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_1206_AvUploadCompleted, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    m.setResult(body.readByte())
  }

}
