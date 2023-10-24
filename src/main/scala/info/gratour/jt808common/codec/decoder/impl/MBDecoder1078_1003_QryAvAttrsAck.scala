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
import info.gratour.jt808common.protocol.msg.JT1078Msg_1003_QryAvAttrsAck
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1003_QryAvAttrsAck
import io.netty.buffer.ByteBuf

object MBDecoder1078_1003_QryAvAttrsAck extends JT808MsgBodyDecoder[JT1078Msg_1003_QryAvAttrsAck] {
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_1003_QryAvAttrsAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val ackParams = new JT1078AckParams_1003_QryAvAttrsAck
    ackParams.setAudioCodec(body.readByte())
    ackParams.setAudioChannels(body.readByte())
    ackParams.setAudioSampleRate(body.readByte())
    ackParams.setAudioBitsPerSample(body.readByte())
    ackParams.setAudioFrameSize(body.readUnsignedShort())
    ackParams.setSupportAudioOut(body.readByte() == 1)
    ackParams.setVideoCodec(body.readByte())
    ackParams.setMaxAudioChannels(body.readByte())
    ackParams.setMaxVideoChannels(body.readByte())

    m.setAckParams(ackParams)
  }
}
