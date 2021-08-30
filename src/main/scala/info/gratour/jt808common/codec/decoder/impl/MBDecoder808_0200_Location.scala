/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder2019Support
import info.gratour.jt808common.protocol.msg.JT808Msg_0200_Location
import io.netty.buffer.ByteBuf

object MBDecoder808_0200_Location extends JT808MsgBodyDecoder2019Support[JT808Msg_0200_Location] {
  override def decodeMsgBodyNew(protoVer: Byte, m: JT808Msg_0200_Location, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val t = MBDecoder808_Track.decodeTrack(protoVer, m, body, tempBuf, System.currentTimeMillis(), retransmit = false)
    m.setTrk(t)
  }
}
