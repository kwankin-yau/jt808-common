/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1003_QryAVAttrsAck
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1003_QryAVAttrsAck
import io.netty.buffer.ByteBuf

object MBDecoder1078_1003_QryAVAttrsAck extends JT808MsgBodyDecoder[JT1078Msg_1003_QryAVAttrsAck] {
  override def decodeMsgBody(m: JT1078Msg_1003_QryAVAttrsAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val ackParams = new JT1078AckParams_1003_QryAVAttrsAck
    ackParams.setInputAudioEnc(body.readByte())
    ackParams.setInputAudioChannel(body.readByte())
    ackParams.setInputAudioFrequency(body.readByte())
    ackParams.setInputAudioBits(body.readByte())
    ackParams.setAudioFrameSize(body.readUnsignedShort())
    ackParams.setSupportAudioOut(body.readByte() == 1)
    ackParams.setVideoEnc(body.readByte())
    ackParams.setMaxAudioChannel(body.readByte())
    ackParams.setMaxVideoChannel(body.readByte())

    m.setAckParams(ackParams)
  }
}
