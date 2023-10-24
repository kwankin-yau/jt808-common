/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8108_UpgradePacket
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8108_UpgradePacket extends AbstractJT808MsgBodyEncoder[JT808Msg_8108_UpgradePacket] {
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8108_UpgradePacket, out: ByteBuf): Unit = {
    val data = m.getData
    if (data == null || data.isEmpty)
      throw new CodecError("data == null or empty")

    out.writeByte(m.getUpgradeType)
    out.writeFixedLenStr(m.getFactoryId, 5)
    out.writeByteLenPrefixedStr(m.getVersion)
    out.writeIntLenPrefixedBytes(data)
  }
}
