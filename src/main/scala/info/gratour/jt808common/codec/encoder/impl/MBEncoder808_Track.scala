/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.JT808Utils
import info.gratour.jt808common.protocol.msg.types.trk.Trk
import info.gratour.jtcommon.{ByteBufHelper, JTCodecHelper}
import io.netty.buffer.ByteBuf

object MBEncoder808_Track extends JTCodecHelper {

  def encodeTrack(protoVer: Byte, t: Trk, out: ByteBuf): Unit = {
    out.writeInt(t.getAlm)
    out.writeInt(t.getSt)
    out.writeAxis(t.getLat)
    out.writeAxis(t.getLng)
    out.writeShort(t.getAlt)
    out.writeShort((t.getSpd * 10).toInt)
    out.writeShort(t.getDir)
    JT808Utils.timestampToBcd6(t.getGpsTm, out)

    def addtWriteShort(id: Int, value: Short): Unit = {
      out.writeByte(id)
      out.writeByte(2)
      out.writeShort(value)
    }

    def addtWriteInt(id: Int, value: Int): Unit = {
      out.writeByte(id)
      out.writeByte(4)
      out.writeInt(value)
    }

    val mile = t.getMile
    if (mile != null) {
      val v = (mile * 10).toInt
      addtWriteInt(0x01, v)
    }

    val gas = t.getGas
    if (gas != null) {
      val v = (gas * 10).toShort
      addtWriteShort(0x02, v)
    }

    val recSpd = t.getRecSpd
    if (recSpd != null) {
      val v = (recSpd * 10).toShort
      addtWriteShort(0x03, v)
    }
  }

}
