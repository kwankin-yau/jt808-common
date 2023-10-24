package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9003_QryAvAttrs
import io.netty.buffer.ByteBuf

object MBDecoder1078_9003_QryAvAttrs extends JT808MsgBodyDecoder[JT1078Msg_9003_QryAvAttrs]{
  override def decodeMsgBody(
                              protoVer: Byte,
                              adasDialect: AdasDialect,
                              m: JT1078Msg_9003_QryAvAttrs,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    // nop
  }
}
