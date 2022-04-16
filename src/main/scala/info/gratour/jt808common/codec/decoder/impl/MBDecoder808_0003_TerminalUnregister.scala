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
import info.gratour.jt808common.protocol.msg.JT808Msg_0003_TerminalUnregister
import io.netty.buffer.ByteBuf

object MBDecoder808_0003_TerminalUnregister extends JT808MsgBodyDecoder[JT808Msg_0003_TerminalUnregister]{
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0003_TerminalUnregister, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    // nop
  }
}
