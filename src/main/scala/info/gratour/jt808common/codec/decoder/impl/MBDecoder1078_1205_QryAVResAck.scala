/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.JT808Utils
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1205_QryAVResAck
import info.gratour.jt808common.protocol.msg.types.JT1078AVRes
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1205_QryAVResAck
import io.netty.buffer.ByteBuf

object MBDecoder1078_1205_QryAVResAck extends JT808MsgBodyDecoder[JT1078Msg_1205_QryAVResAck] {
  override def decodeMsgBody(m: JT1078Msg_1205_QryAVResAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val cnt = body.readInt()
    val ackParams = new JT1078AckParams_1205_QryAVResAck
    val recList = new Array[JT1078AVRes](cnt)
    ackParams.setResList(recList)
    m.setAckParams(ackParams)

    for (i <- 0 until cnt) {
      val res = new JT1078AVRes
      res.setChan(body.readByte())
      res.setStartTm(JT808Utils.readBcd6Timestamp(body, tempBuf))
      res.setEndTm(JT808Utils.readBcd6Timestamp(body, tempBuf))
      res.setAlmSt1078(body.readInt())
      res.setAlmSt808(body.readInt())
      res.setMediaTyp(body.readByte())
      res.setCodeStrm(body.readByte())
      res.setStgTyp(body.readByte())
      res.setFileSz(body.readUnsignedInt())

      recList(i) = res
    }
  }
}
