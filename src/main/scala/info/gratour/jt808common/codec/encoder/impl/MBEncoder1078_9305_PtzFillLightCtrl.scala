/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9305_PtzFillLightCtrl
import io.netty.buffer.ByteBuf

object MBEncoder1078_9305_PtzFillLightCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9305_PtzFillLightCtrl] {
  override protected def encodeBody(m: JT1078Msg_9305_PtzFillLightCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChan)
    out.writeByte(p.getCtrl)
  }
}
