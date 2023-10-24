package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1003_QryAvAttrsAck
import io.netty.buffer.ByteBuf

object MBEncoder1078_1003_QryAvAttrsAck extends AbstractJT808MsgBodyEncoder[JT1078Msg_1003_QryAvAttrsAck]{
  override protected def encodeBody(
                                     protoVer: Byte,
                                     adasDialect: AdasDialect,
                                     m: JT1078Msg_1003_QryAvAttrsAck,
                                     out: ByteBuf
                                   ): Unit = {
    val ap = m.getAckParams

    out.writeByte(ap.getAudioCodec)
    out.writeByte(ap.getAudioChannels)
    out.writeByte(ap.getAudioSampleRate)
    out.writeByte(ap.getAudioBitsPerSample)
    out.writeShort(ap.getAudioFrameSize)
    out.writeByte(if (ap.isSupportAudioOut) 1 else 0)
    out.writeByte(ap.getVideoCodec)
    out.writeByte(ap.getMaxAudioChannels)
    out.writeByte(ap.getMaxVideoChannels)
  }
}
