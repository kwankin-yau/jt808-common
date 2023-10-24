package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0801_MultiMediaData_Simplified
import io.netty.buffer.ByteBuf

object MBDecoder808_0801_MultiMediaData_Simplified extends JT808MsgBodyDecoder[JT808Msg_0801_MultiMediaData_Simplified] {
  override def decodeMsgBody(
                              protoVer: Byte,
                              adasDialect: AdasDialect,
                              m: JT808Msg_0801_MultiMediaData_Simplified,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    m.setMediaId(body.readUnsignedInt())
  }
}
