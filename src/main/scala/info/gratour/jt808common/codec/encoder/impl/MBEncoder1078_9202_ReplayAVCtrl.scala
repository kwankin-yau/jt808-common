/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.JT808Utils
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9202_ReplayAVCtrl
import info.gratour.jtcommon.JTConsts
import io.netty.buffer.ByteBuf

object MBEncoder1078_9202_ReplayAVCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9202_ReplayAVCtrl] {
  override protected def encodeBody(m: JT1078Msg_9202_ReplayAVCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChannel)
    val ctrl = p.getCtrl
    val factor = p.getFactor
    val time = p.getTime
    ctrl match {
      case 3 | 4 =>
        if (factor == null)
          throw new CodecError("factory == null")

      case 5 =>
        if (time == null)
          throw new CodecError("time == null")

      case _ =>
    }
    out.writeByte(ctrl)

    out.writeByte(if (factor != null) factor.byteValue() else 0)
    if (time != null)
      out.writeBytes(JT808Utils.timestampToBcd6(time))
    else
      out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 6)
  }
}
