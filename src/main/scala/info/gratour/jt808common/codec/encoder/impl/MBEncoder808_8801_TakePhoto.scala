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
import info.gratour.jt808common.protocol.msg.JT808Msg_8801_TakePhoto
import io.netty.buffer.ByteBuf

object MBEncoder808_8801_TakePhoto extends AbstractJT808MsgBodyEncoder[JT808Msg_8801_TakePhoto] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8801_TakePhoto, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChannel)
    val cnt: Short = if (p.getCount == null) 1 else p.getCount
    out.writeShort(if (p.getCmd == 1) cnt else p.getCmd)
    out.writeShort(if (p.getInterval == null) 0 else p.getInterval.shortValue())
    out.writeByte(if (p.getSave != null) p.getSave.byteValue() else 0)
    out.writeByte(if (p.getResolution != null) p.getResolution.byteValue() else 0)
    out.writeByte(if (p.getQuality != null) p.getQuality.byteValue() else 10)
    out.writeByte(if (p.getBrightness != null) p.getBrightness.byteValue() else 127)
    out.writeByte(if (p.getContrast != null) p.getContrast.byteValue() else 63)
    out.writeByte(if (p.getSaturability != null) p.getSaturability.byteValue() else 63)
    out.writeByte(if (p.getChroma != null) p.getChroma.byteValue() else 127)
  }
}
