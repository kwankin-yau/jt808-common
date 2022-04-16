/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Consts}
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9101_LiveAvReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder1078_9101_LiveAvReq extends AbstractJT808MsgBodyEncoder[JT1078Msg_9101_LiveAvReq] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9101_LiveAvReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019) {
      out.writeShort(p.getTcpPort2019)
      out.writeShort(p.getUdpPort2019)
    } else {
      out.writeShort(p.getTcpPort)
      out.writeShort(p.getUdpPort)
    }
    out.writeByte(p.getChan)
    out.writeByte(if (p.getDataTyp != null) p.getDataTyp.byteValue() else 0)
    out.writeByte(if (p.getCodeStrm != null) p.getCodeStrm.byteValue() else 0)
  }
}
