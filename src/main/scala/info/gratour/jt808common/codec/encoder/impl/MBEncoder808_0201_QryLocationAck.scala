/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder2019Support
import info.gratour.jt808common.protocol.msg.JT808Msg_0201_QryLocationAck
import io.netty.buffer.ByteBuf

object MBEncoder808_0201_QryLocationAck extends AbstractJT808MsgBodyEncoder2019Support[JT808Msg_0201_QryLocationAck]{
  override protected def encodeBody(protoVer: Byte, m: JT808Msg_0201_QryLocationAck, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    MBEncoder808_Track.encodeTrack(protoVer, m.getAckParams.getTrk, out)
  }
}
