/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.{JT808MsgBodyDecoder, JT808MsgBodyDecoder2019Support}
import info.gratour.jt808common.protocol.msg.JT808Msg_0704_BatchLocation
import info.gratour.jt808common.protocol.msg.types.trk.Trk
import io.netty.buffer.ByteBuf

object MBDecoder808_0704_BatchLocation extends JT808MsgBodyDecoder2019Support[JT808Msg_0704_BatchLocation] {
  override def decodeMsgBodyNew(protoVer: Byte, m: JT808Msg_0704_BatchLocation, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val recvTime = System.currentTimeMillis()

    val cnt = body.readUnsignedShort()
    val retransmit = body.readByte() == 1
    val tracks = new Array[Trk](cnt)

    for (i <- 0 until cnt) {
      val size = body.readUnsignedShort()

      val buf = body.slice(body.readerIndex(), size)
      body.skipBytes(size)

      val t = MBDecoder808_Track.decodeTrack(protoVer, m, buf, tempBuf, recvTime, retransmit)
      tracks(i) = t
    }

    m.setRetransmit(retransmit)
    m.setTrks(tracks)
  }
}