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
import info.gratour.jt808common.protocol.msg.JT808Msg_8602_SetRectRegion
import info.gratour.jtcommon.{ByteBufHelper, JTUtils}
import io.netty.buffer.ByteBuf

object MBEncoder808_8602_SetRectRegion extends AbstractJT808MsgBodyEncoder[JT808Msg_8602_SetRectRegion] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8602_SetRectRegion, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val regions = checkNotEmpty(params.getRegions, "regions")

    out.writeByte(params.getAction)
    out.writeByte(regions.length)
    regions.foreach(r => {
      out.writeInt(r.getRegionId)
      val attrs = r.getAttrs
      out.writeShort(attrs)
      val minXMinY = checkNotNull(r.getMinXMinY, "minXMinY")
      out.writeAxis(minXMinY.getLat)
      out.writeAxis(minXMinY.getLng)
      val maxXMaxY = checkNotNull(r.getMaxXMaxY, "maxXMaxY")
      out.writeAxis(maxXMaxY.getLat)
      out.writeAxis(maxXMaxY.getLng)
      if (JTUtils.test(attrs, 0)) {
        if (r.getStartTm == null)
          throw new RuntimeException("Invalid parameter: `startTm`.")
        if (r.getEndTm == null)
          throw new RuntimeException("Invalid parameter: `endTm`.")

        var ldt = JT808Utils.parseSixDigitsDateTime(r.getStartTm)
        out.writeBytes(ldt.toBcd6)
        ldt = JT808Utils.parseSixDigitsDateTime(r.getEndTm)
        out.writeBytes(ldt.toBcd6)
      }

      if (JTUtils.test(attrs, 1)) {
        if (r.getSpdUpperLimit == null)
          throw new RuntimeException("Invalid parameter: `spdUpperLimit`.")
        if (r.getTimeThreshold == null)
          throw new RuntimeException("Invalid parameter: `timeThreshold`.")

        out.writeShort(r.getSpdUpperLimit.shortValue())
        out.writeByte(r.getTimeThreshold.byteValue())
      }
    })
  }
}
