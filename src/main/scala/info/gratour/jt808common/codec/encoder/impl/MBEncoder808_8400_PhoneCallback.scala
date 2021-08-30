/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8400_PhoneCallback
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8400_PhoneCallback extends AbstractJT808MsgBodyEncoder[JT808Msg_8400_PhoneCallback] {
  override protected def encodeBody(m: JT808Msg_8400_PhoneCallback, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")

    out.writeByte(params.getAction)
    out.writeStr(params.getPhoneNo)
  }
}
