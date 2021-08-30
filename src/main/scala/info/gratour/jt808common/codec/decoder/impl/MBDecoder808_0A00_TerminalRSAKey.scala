/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0A00_TerminalRSAKey
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder808_0A00_TerminalRSAKey extends JT808MsgBodyDecoder[JT808Msg_0A00_TerminalRSAKey] {
  override def decodeMsgBody(m: JT808Msg_0A00_TerminalRSAKey, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setE(body.readInt())
    m.setN(body.readBytesLen(128))
  }
}
