/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import java.util

import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.JT808Utils
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jt808common.protocol.msg.types.trk.{AcrossAreaAddt, AdasBlindAreaAlmAddt, AdasDriverBehavAlmAddt, AdasDrivingAssistAlmAddt, AdasIntenseDrivingAlmAddt, AdasOverSpdAlmAddt, AdasTyreState, AnalogQty, OverSpdAddt, PressureAlarmInfo, RouteAlmAddt, Trk, TrkAddt, UnusualDriveBehav}
import info.gratour.jtcommon.{ByteBufHelper, JTCodecHelper, JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

private class MBDecoder808_Track

object MBDecoder808_Track extends JTCodecHelper {

  private val logger = Logger[MBDecoder808_Track]

  private def readAdasAlarmIdentity(protoVer: Byte, buf: ByteBuf, tempBuf: Array[Byte]): String = {
    val sz =
      if (protoVer >= JTConsts.PROTO_VER__REV2019)
        40
      else
        16

    buf.readBytes(tempBuf, 0, sz)
    JTUtils.hex(tempBuf, 0, sz)
  }


  def decodeTrack(protoVer: Byte, m: JT808Msg, buf: ByteBuf, tempBuf: Array[Byte], recvTime: Long, retransmit: Boolean): Trk = {
    val t = new Trk
    t.setSimNo(m.getSimNo)
    //    t.setMsgSeqNo(m.getSeqNo)
    t.setRecvTm(recvTime)
    if (retransmit)
      t.setReTrans(true)

    t.setAlm(buf.readInt())
    t.setSt(buf.readInt())
    t.setLat(buf.readAxis())
    t.setLng(buf.readAxis())
    t.setAlt(buf.readShort())
    t.setSpd((buf.readShort() / 10).toFloat)
    t.setDir(buf.readShort())
    buf.readBytes(tempBuf, 0, 6)
    t.setGpsTm(JT808Utils.bcd6ToTimestamp(tempBuf))

    var _addt: TrkAddt = null

    def addt: TrkAddt = {
      if (_addt == null) {
        _addt = new TrkAddt
        t.setAddt(_addt)
      }

      _addt
    }

    while (buf.readableBytes() >= 2) {
      val infoId = buf.readUnsignedByte()
      val len = buf.readUnsignedByte()
      if (len > 0) {}
      val readerIndex = buf.readerIndex()

      //      logger.debug("infoId: " + StringUtils.intToHex(infoId, 2))
      //      logger.debug("len: " + len)

      infoId match {
        case 0x01 =>
          val mile = buf.readInt() / 10f
          t.setMile(mile)

        case 0x02 =>
          val gas = buf.readShort() / 10f
          t.setGas(gas)

        case 0x03 =>
          val spd = buf.readShort() / 10f
          t.setRecSpd(spd)

        case 0x04 =>
          addt.setConfirmAlmId(buf.readUnsignedShort())

        case 0x11 =>
          val info = new OverSpdAddt
          info.setTyp(buf.readByte())
          if (info.getTyp != 0 && len > 1)
            info.setAreaId(buf.readInt())
          addt.setOverSpd(info)

        case 0x12 =>
          val info = new AcrossAreaAddt
          info.setTyp(buf.readByte())
          info.setAreaId(buf.readInt())
          info.setDir(buf.readByte())
          addt.setAcrossArea(info)

        case 0x13 =>
          val info = new RouteAlmAddt
          info.setRouteId(buf.readInt())
          info.setTm(buf.readUnsignedShort())
          info.setTyp(buf.readByte())
          addt.setRouteAlm(info)

        case 0x25 =>
          t.setSignal(buf.readInt())

        case 0x2A =>
          t.setIoSt(buf.readShort())

        case 0x2B =>
          val qty = new AnalogQty
          qty.setAd0(buf.readUnsignedShort())
          qty.setAd1(buf.readUnsignedShort())
          addt.setAnQty(qty)

        case 0x30 =>
          addt.setNetSigStr(buf.readByte().toShort)

        case 0x31 =>
          addt.setSat(buf.readByte().toShort)

        // 1078
        case 0x14 =>
          t.setVidAlm(buf.readInt())

        case 0x15 =>
          addt.setVidLoss(buf.readInt())

        case 0x16 =>
          addt.setVidCover(buf.readInt())

        case 0x17 =>
          addt.setVidStgAlm(buf.readShort())

        case 0x18 =>
          val typ = buf.readShort()
          if (len > 2) {
            val lvl = buf.readByte()
            if (typ != 0) {
              val info = new UnusualDriveBehav
              info.setTyp(typ)
              info.setTiredLvl(lvl)
              t.setUnusualDriveBehav(info)
            }
          }

        // ADAS
        case 0x64 =>
          val alarm = new AdasDrivingAssistAlmAddt
          val p = buf.readerIndex()
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setLvl(buf.readByte())
          alarm.setFrontCarSpd(buf.readUnsignedByte())
          alarm.setFrontCarDist(buf.readUnsignedByte() * 0.1f)
          alarm.setDeviateTyp(buf.readByte())
          alarm.setRdRecogMark(buf.readByte())
          alarm.setRdRecogDat(buf.readByte())
          alarm.setSpd(buf.readByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          val almNo =
            if (protoVer > 0) {
              val read = buf.readerIndex() - p
              val remains = len - read
              if (remains < 40)
                readAdasAlarmIdentity(0, buf, tempBuf)
              else
                readAdasAlarmIdentity(protoVer, buf, tempBuf)
            } else
              readAdasAlarmIdentity(protoVer, buf, tempBuf)
          alarm.setAlmNo(almNo)

          t.setDrivingAssistAlm(alarm)

        case 0x65 =>
          val alarm = new AdasDriverBehavAlmAddt
          val p = buf.readerIndex()
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setLvl(buf.readByte())
          alarm.setFatigue(buf.readByte())
          buf.skipBytes(4)
          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          val almNo =
            if (protoVer > 0) {
              val read = buf.readerIndex() - p
              val remains = len - read
              if (remains < 40)
                readAdasAlarmIdentity(0, buf, tempBuf)
              else
                readAdasAlarmIdentity(protoVer, buf, tempBuf)
            } else
              readAdasAlarmIdentity(protoVer, buf, tempBuf)
          alarm.setAlmNo(almNo)

          t.setDriverBehavAlm(alarm)

        case 0x66 =>
          val p = buf.readerIndex()

          def parseTyreState(protoVer: Byte): AdasTyreState = {
            val alarm = new AdasTyreState
            alarm.setAlmId(buf.readInt())

            alarm.setFlag(buf.readByte())
            alarm.setSpd(buf.readUnsignedByte())
            alarm.setAlt(buf.readShort())
            alarm.setLat(buf.readAxis())
            alarm.setLng(buf.readAxis())
            buf.readBytes(tempBuf, 0, 6)
            alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
            alarm.setVehSt(buf.readShort())
            alarm.setAlmNo(readAdasAlarmIdentity(protoVer, buf, tempBuf))
            val list = new util.ArrayList[PressureAlarmInfo]()
            alarm.setAlms(list)
            val cnt = buf.readUnsignedByte()
            for (_ <- 1 to cnt) {
              val info = new PressureAlarmInfo
              info.setTyreNo(buf.readByte())
              info.setTyp(buf.readShort())
              info.setPress(buf.readUnsignedShort())
              info.setTemp(buf.readUnsignedShort())
              info.setBatt(buf.readShort())

              list.add(info)
            }
            alarm.setAlms(list)

            alarm
          }

          val alarm =
            try {
              parseTyreState(protoVer)
            } catch {
              case t: Throwable =>
                if (protoVer > 0) {
                  // try parse as 16 digit almNo
                  parseTyreState(0)
                } else
                  throw t
            }

          t.setAdasTyreState(alarm)

        case 0x67 =>
          val alarm = new AdasBlindAreaAlmAddt
          val p = buf.readerIndex()
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          val almNo =
            if (protoVer > 0) {
              val read = buf.readerIndex() - p
              val remains = len - read
              if (remains < 40)
                readAdasAlarmIdentity(0, buf, tempBuf)
              else
                readAdasAlarmIdentity(protoVer, buf, tempBuf)
            } else
              readAdasAlarmIdentity(protoVer, buf, tempBuf)
          alarm.setAlmNo(almNo)

          t.setAdasBlindAreaAlarm(alarm)

        case 0x70 =>
          val alarm = new AdasIntenseDrivingAlmAddt
          val p = buf.readerIndex()
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setDur(buf.readShort())
          alarm.setThold1(buf.readShort())
          alarm.setThold2(buf.readShort())

          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          val almNo =
            if (protoVer > 0) {
              val read = buf.readerIndex() - p
              val remains = len - read
              if (remains < 40)
                readAdasAlarmIdentity(0, buf, tempBuf)
              else
                readAdasAlarmIdentity(protoVer, buf, tempBuf)
            } else
              readAdasAlarmIdentity(protoVer, buf, tempBuf)
          alarm.setAlmNo(almNo)

          t.setAdasIntenseDrivingAlarm(alarm)

        case 0x71 =>
          if (len >= 44) {
            val alarm = new AdasOverSpdAlmAddt
            val p = buf.readerIndex()
            alarm.setAlmId(buf.readInt()) // 4
            alarm.setFlag(buf.readByte()) // 1
            alarm.setTyp(buf.readByte()) // 1
            alarm.setOverSpdAlmTyp(buf.readByte()) // 1
            alarm.setTermSpdThold(buf.readUnsignedByte()) // 1
            alarm.setRdSpdThold(buf.readUnsignedByte()) // 1

            alarm.setSpd(buf.readUnsignedByte()) // 1
            alarm.setAlt(buf.readShort()) // 2
            alarm.setLat(buf.readAxis()) // 4
            alarm.setLng(buf.readAxis()) // 4
            buf.readBytes(tempBuf, 0, 6) // 6
            alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
            alarm.setVehSt(buf.readShort()) // 2
            val almNo =
              if (protoVer > 0) {
                val read = buf.readerIndex() - p
                val remains = len - read
                if (remains < 40)
                  readAdasAlarmIdentity(0, buf, tempBuf)
                else
                  readAdasAlarmIdentity(protoVer, buf, tempBuf)
              } else
                readAdasAlarmIdentity(protoVer, buf, tempBuf)
            alarm.setAlmNo(almNo) // 16 or 40

            t.setAdasOverSpdAlarm(alarm)
          }

        case _ =>
      }

      val delta = len - (buf.readerIndex() - readerIndex)
      if (delta > 0) {
        //        logger.debug(s"skip $delta bytes")
        buf.skipBytes(delta)
      }
    }

    t
  }
}
