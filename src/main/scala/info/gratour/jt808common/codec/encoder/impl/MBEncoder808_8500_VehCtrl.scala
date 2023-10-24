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
import info.gratour.jt808common.protocol.msg.JT808Msg_8500_VehCtrl
import io.netty.buffer.ByteBuf

object MBEncoder808_8500_VehCtrl extends AbstractJT808MsgBodyEncoder[JT808Msg_8500_VehCtrl] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8500_VehCtrl, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")

    out.writeByte(params.getFlags)
  }
}
