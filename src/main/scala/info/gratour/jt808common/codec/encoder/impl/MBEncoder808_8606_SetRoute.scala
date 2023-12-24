/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8606_SetRoute
import info.gratour.jtcommon.{ByteBufHelper, JTUtils}
import io.netty.buffer.ByteBuf

object MBEncoder808_8606_SetRoute extends AbstractJT808MsgBodyEncoder[JT808Msg_8606_SetRoute] {
  override protected def encodeBody(
                                     protoVer: Byte,
                                     adasDialect: AdasDialect,
                                     m: JT808Msg_8606_SetRoute,
                                     out: ByteBuf
                                   ): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeInt(p.getRouteId)
    val attrs = p.getAttrs
    out.writeShort(attrs)

    val startTime = JT808Utils.parseSixDigitsDateTime(p.getStartTime)
    out.writeBytes(startTime.toBcd6)
    val endTime = JT808Utils.parseSixDigitsDateTime(p.getEndTime)
    out.writeBytes(endTime.toBcd6)

    val corners = checkNotEmpty(p.getCorners, "corners")
    out.writeShort(corners.length)
    corners.foreach(c => {
      out.writeInt(c.getCornerId)
      out.writeInt(c.getSegmentId)
      val coord = checkNotNull(c.getCoord, "coord")
      out.writeAxis(coord.getLat)
      out.writeAxis(coord.getLng)
      out.writeByte(c.getWidth)
      val cAttrs = c.getAttrs
      out.writeByte(cAttrs)
      if (JTUtils.test(cAttrs, 0)) {
        out.writeShort(c.getTmUpThold)
        out.writeShort(c.getTmLoThold)
      }
      if (JTUtils.test(cAttrs, 1)) {
        out.writeShort(c.getSpdUpThold)
        out.writeByte(c.getOverSpdTmThold)
      }
    })
  }
}
