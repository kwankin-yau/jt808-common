/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8107_QryAttrs
import io.netty.buffer.ByteBuf

object MBDecoder808_8107_QryAttrs extends JT808MsgBodyDecoder[JT808Msg_8107_QryAttrs] {
  
  override def decodeMsgBody(
                              protoVer: Byte,
                              adasDialect: AdasDialect,
                              m: JT808Msg_8107_QryAttrs,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    // nop
  }
}
