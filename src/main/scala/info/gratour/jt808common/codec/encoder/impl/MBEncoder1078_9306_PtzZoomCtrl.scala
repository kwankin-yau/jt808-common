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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9306_PtzZoomCtrl
import io.netty.buffer.ByteBuf

object MBEncoder1078_9306_PtzZoomCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9306_PtzZoomCtrl] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9306_PtzZoomCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChan)
    out.writeByte(p.getCtrl)
  }
}
