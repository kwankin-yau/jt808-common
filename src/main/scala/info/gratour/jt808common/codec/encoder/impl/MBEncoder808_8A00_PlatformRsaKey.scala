/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8A00_PlatformRSAKey
import io.netty.buffer.ByteBuf

object MBEncoder808_8A00_PlatformRsaKey extends AbstractJT808MsgBodyEncoder[JT808Msg_8A00_PlatformRSAKey] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8A00_PlatformRSAKey, out: ByteBuf): Unit = {
    out.writeInt(m.getE.intValue())
    out.writeBytes(checkNotEmpty(m.getN, "n"))
  }
}
