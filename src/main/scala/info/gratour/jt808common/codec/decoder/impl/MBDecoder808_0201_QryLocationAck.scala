/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.{JT808MsgBodyDecoder, JT808MsgBodyDecoder2019Support}
import info.gratour.jt808common.protocol.msg.JT808Msg_0201_QryLocationAck
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0201_QryLocationAck
import io.netty.buffer.ByteBuf

object MBDecoder808_0201_QryLocationAck extends JT808MsgBodyDecoder2019Support[JT808Msg_0201_QryLocationAck]{
  override def decodeMsgBodyNew(protoVer: Byte, m: JT808Msg_0201_QryLocationAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val t = MBDecoder808_Track.decodeTrack(protoVer, m, body, tempBuf, System.currentTimeMillis(), retransmit = false)
    val ackParams = new JT808AckParams_0201_QryLocationAck
    ackParams.setTrk(t)
    m.setAckParams(ackParams)
  }
}
