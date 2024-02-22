/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.protocol.msg.types.AdasAlmNo
import info.gratour.jt808common.protocol.msg.types.trk.{AdasDriverBehavAlmAddt, Trk}
import info.gratour.jtcommon.{ByteBufHelper, JTCodecHelper}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBEncoder808_Track extends JTCodecHelper {

  def encodeTrackBasicInfo(protoVer: Byte, t: Trk, out: ByteBuf): Unit = {
    out.writeInt(t.getAlm)
    out.writeInt(t.getSt)
    out.writeAxis(t.getLat)
    out.writeAxis(t.getLng)
    out.writeShort(t.getAlt)
    out.writeShort((t.getSpd * 10).toInt)
    out.writeShort(t.getDir)
    JT808Utils.timestampToBcd6(t.getGpsTm, out)
  }

  def encodeTrack(protoVer: Byte, adasDialect: AdasDialect, t: Trk, out: ByteBuf): Unit = {
    encodeTrackBasicInfo(protoVer, t, out)

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

    def writeAlmNo(almNo: String): Unit = {
      val bytes = Hex.decodeHex(almNo)

      if (protoVer > 0) {
        if (bytes.length < AdasAlmNo.ID_LEN_2019)
          throw new CodecError(s"Invalid almNo: ${almNo}")
      } else {
        if (bytes.length != AdasAlmNo.ID_LEN_2013)
          throw new CodecError(s"Invalid almNo: ${almNo}")
      }
      out.writeBytes(bytes)
    }

    def addtWriteDriverBehvaAlm(alm: AdasDriverBehavAlmAddt): Unit = {
      out.writeByte(0x65)
      val pos = out.writerIndex()
      out.writeByte(0)

      out.writeInt(alm.getAlmId)
      out.writeByte(alm.getFlag)
      out.writeByte(alm.getTyp)
      out.writeByte(alm.getLvl)
      out.writeByte(alm.getFatigue)
      out.writeZero(4)
      out.writeByte(alm.getSpd)
      out.writeShort(alm.getAlt)
      out.writeAxis(alm.getLat)
      out.writeAxis(alm.getLng)
      out.writeBcd6Timestamp(alm.getTm)
      out.writeShort(alm.getVehSt)
      writeAlmNo(alm.getAlmNo)

      val sz = out.writerIndex() - pos - 1
      out.setByte(pos, sz)
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

    if (t.getAddt != null) {
      val driverBehavAlmAddt = t.getAddt.getDriverBehavAlm
      if (driverBehavAlmAddt != null)
        addtWriteDriverBehvaAlm(driverBehavAlmAddt)
    }
  }

}
