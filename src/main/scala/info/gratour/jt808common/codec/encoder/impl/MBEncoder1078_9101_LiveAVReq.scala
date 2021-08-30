/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.JT808Consts
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder2019Support
import info.gratour.jt808common.protocol.msg.JT1078Msg_9101_LiveAVReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder1078_9101_LiveAVReq extends AbstractJT808MsgBodyEncoder2019Support[JT1078Msg_9101_LiveAVReq] {
  override protected def encodeBody(termRev: Byte, m: JT1078Msg_9101_LiveAVReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    if (termRev >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019) {
      out.writeShort(p.getTcpPort2019)
      out.writeShort(p.getUdpPort2019)
    } else {
      out.writeShort(p.getTcpPort)
      out.writeShort(p.getUdpPort)
    }
    out.writeByte(p.getChannel)
    out.writeByte(if (p.getDataType != null) p.getDataType.byteValue() else 0)
    out.writeByte(if (p.getCodeStream != null) p.getCodeStream.byteValue() else 0)
  }
}
