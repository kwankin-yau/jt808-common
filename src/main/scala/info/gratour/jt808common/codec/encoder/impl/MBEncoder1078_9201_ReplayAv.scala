/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9201_ReplayAvReq
import info.gratour.jt808common.{AdasDialect, JT808Consts, JT808Utils}
import info.gratour.jtcommon.{ByteBufHelper, JTConsts}
import io.netty.buffer.ByteBuf

object MBEncoder1078_9201_ReplayAv extends AbstractJT808MsgBodyEncoder[JT1078Msg_9201_ReplayAvReq] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9201_ReplayAvReq, out: ByteBuf): Unit = {
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
    out.writeByte(p.getMediaTyp)
    out.writeByte(p.getCodeStrm)
    out.writeByte(p.getStgTyp)
    val mode = p.getMode
    val factor = p.getFactor
    mode match {
      case 1 | 2 =>
        if (factor == null)
          throw new CodecError("factor == null")

      case _ =>
    }
    out.writeByte(mode)
    out.writeByte(if (factor != null) factor.byteValue() else 0)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTm))
    if (p.getEndTm != null && p.getEndTm != 0L)
      out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTm))
    else
      out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 6)
  }
}
