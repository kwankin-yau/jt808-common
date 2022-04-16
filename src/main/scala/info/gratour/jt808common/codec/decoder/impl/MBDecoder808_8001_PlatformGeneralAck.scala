/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8001_PlatformGeneralAck
import io.netty.buffer.ByteBuf

object MBDecoder808_8001_PlatformGeneralAck extends JT808MsgBodyDecoder[JT808Msg_8001_PlatformGeneralAck]{

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8001_PlatformGeneralAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    m.setAckMsgId(body.readUnsignedShort())
    m.setResult(body.readByte())
  }

}
