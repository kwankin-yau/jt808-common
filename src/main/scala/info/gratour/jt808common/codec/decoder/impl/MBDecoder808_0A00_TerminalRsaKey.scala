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
import info.gratour.jt808common.protocol.msg.JT808Msg_0A00_TerminalRsaKey
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder808_0A00_TerminalRsaKey extends JT808MsgBodyDecoder[JT808Msg_0A00_TerminalRsaKey] {
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0A00_TerminalRsaKey, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setE(body.readInt())
    m.setN(body.readBytesLen(128))
  }
}
