/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0700_VtdrData
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0700_VtdrData
import info.gratour.jt808common.protocol.msg.types.vtdr.{JT808VtdrDataBlock, JT808Vtdr_AccidentPoints_10, JT808Vtdr_DriveOverTime_11, JT808Vtdr_DriverCardEvents_12, JT808Vtdr_DriverInfo_01, JT808Vtdr_Id_07, JT808Vtdr_Locations_09, JT808Vtdr_Mileage_03, JT808Vtdr_PowerEvents_13, JT808Vtdr_PulseFactor_04, JT808Vtdr_RevEvents_14, JT808Vtdr_SpdRecords_08, JT808Vtdr_SpdStatusLog_15, JT808Vtdr_StatusSignalConfig_06, JT808Vtdr_Time_02, JT808Vtdr_VehInfo_05, JT808Vtdr_VerInfo_00, VtdrCmdConsts, Vtdr_AccidentPoint, Vtdr_CardEvent, Vtdr_DriveOverTimeEntry, Vtdr_Location, Vtdr_LocationAndSpd, Vtdr_LocationInfoPerHour, Vtdr_LogRec, Vtdr_PowerEvent, Vtdr_RevEvent, Vtdr_SpdAndStatus, Vtdr_SpdLogEntry, Vtdr_SpdRec, Vtdr_Status}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBDecoder808_0700_VtdrData extends JT808MsgBodyDecoder[JT808Msg_0700_VtdrData] with Vtdr_DecodeHelper {
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0700_VtdrData, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val ackParams = new JT808AckParams_0700_VtdrData
    val cmd = body.readByte()
    ackParams.setCmd(cmd)

    val bytes = new Array[Byte](body.readableBytes())
    body.getBytes(body.readerIndex(), bytes)
    ackParams.setRaw(Hex.encodeHexString(bytes))


    def decodeLocation: Vtdr_Location = {
      val r = new Vtdr_Location
      r.setLng(intAxisToDouble(body.readInt()))
      r.setLat(intAxisToDouble(body.readInt()))
      r.setAlt(body.readShort())
      r
    }

    val dataBlock: JT808VtdrDataBlock =
      cmd match {
        case VtdrCmdConsts.QRY_VER_INFO_00 =>
          val verInfo = new JT808Vtdr_VerInfo_00
          verInfo.setYear(decode2DigitBcdStr(body))
          verInfo.setRev(decode2DigitBcdStr(body))
          verInfo

        case VtdrCmdConsts.QRY_DRIVER_INFO_01 =>
          val driverInfo = new JT808Vtdr_DriverInfo_01
          driverInfo.setLicenseNo(readFixedLenCStr(body, 18))
          driverInfo

        case VtdrCmdConsts.QRY_TIME_02 =>
          val time = new JT808Vtdr_Time_02
          time.setDateTime(decodeDateTime(body))
          time

        case VtdrCmdConsts.QRY_MILEAGE_03 =>
          val mileage = new JT808Vtdr_Mileage_03
          mileage.setDateTime(decodeDateTime(body))
          mileage.setInstallTime(decodeDateTime(body))
          mileage.setInitMile(decode8DigitBcdStr(body).toFloat * 0.1f)
          mileage.setMile(decode8DigitBcdStr(body).toFloat * 0.1f)
          mileage

        case VtdrCmdConsts.QRY_PULSE_FACTOR_04 =>
          val pulseFactor = new JT808Vtdr_PulseFactor_04
          pulseFactor.setDateTime(decodeDateTime(body))
          pulseFactor.setFactor(body.readShort() & 0xFFFF)
          pulseFactor

        case VtdrCmdConsts.QRY_VEH_INFO_05 =>
          val vehInfo = new JT808Vtdr_VehInfo_05
          vehInfo.setVin(readFixedLenStr(body, 17))
          vehInfo.setPlateNo(readFixedLenCStr(body, 9))
          vehInfo.setPlateCategory(readFixedLenCStr(body, 8))
          vehInfo

        case VtdrCmdConsts.QRY_STATUS_SIGNAL_CONFIG_06 =>
          val config = new JT808Vtdr_StatusSignalConfig_06
          config.setDateTime(decodeDateTime(body))
          val cnt = body.readUnsignedByte()
          (1 to cnt).foreach { _ =>
            val status = new Vtdr_Status
            (1 to 8).foreach { _ =>
              val desc = readFixedLenCStr(body, 10)
              status.addBitDesc(desc)
            }
            config.addStatus(status)
          }
          config

        case VtdrCmdConsts.QRY_ID_07 =>
          val id = new JT808Vtdr_Id_07
          id.setCcc(readFixedLenCStr(body, 7))
          id.setModel(readFixedLenCStr(body, 16))
          id.setProdYear(decode2DigitBcdStr(body))
          id.setProdMonth(decode2DigitBcdStr(body))
          id.setProdDay(decode2DigitBcdStr(body))
          id.setSerialNum(decode8DigitBcdStr(body).toInt)
          body.skipBytes(5)
          id

        case VtdrCmdConsts.QRY_SPD_RECORDS_08 =>
          val spdRecords = new JT808Vtdr_SpdRecords_08
          while (body.readableBytes() > 0) {
            val spdRec = new Vtdr_SpdRec
            spdRec.setStartTime(decodeDateTime(body))
            (1 to 60).foreach(_ => {
              val spdAndStatus = decodeSpdAndStatus(body)
              if (spdAndStatus != null)
                spdRec.addSpdAndStatus(spdAndStatus)
            })

            spdRecords.addSpdRec(spdRec)
          }
          spdRecords

        case VtdrCmdConsts.QRY_LOCATIONS_09 =>
          val locations = new JT808Vtdr_Locations_09
          while (body.isReadable) {
            val locationInfoPerHour = new Vtdr_LocationInfoPerHour
            locationInfoPerHour.setStartTime(decodeDateTime(body))
            (1 to 60).foreach(_ => {
              val lng = body.readInt()
              val lat = body.readInt()
              val alt = body.readShort()
              val spd = body.readUnsignedByte()

              if (lat != -1) {
                val locationAndSpd = new Vtdr_LocationAndSpd
                val location = new Vtdr_Location

                location.setLng(intAxisToDouble(lng))
                location.setLat(intAxisToDouble(lat))
                location.setAlt(alt)
                locationAndSpd.setLocation(location)
                locationAndSpd.setSpd(spd)
                locationInfoPerHour.addLcoationAndSpd(locationAndSpd)
              }
            })

            locations.addLocation(locationInfoPerHour)
          }
          locations

        case VtdrCmdConsts.QRY_ACCIDENT_POINTS_10 =>
          val accidentPoints = new JT808Vtdr_AccidentPoints_10
          while (body.isReadable) {
            val point = new Vtdr_AccidentPoint
            point.setEndTime(decodeDateTime(body))
            point.setLicenseNo(readFixedLenCStr(body, 18))
            point.setSpd(body.readUnsignedByte())
            point.setStatus(body.readByte())
            (1 to 100).foreach(_ => {
              val spdAndStatus = new Vtdr_SpdAndStatus
              spdAndStatus.setSpd(body.readUnsignedByte())
              spdAndStatus.setStatus(body.readByte())
              point.addSpdAndStatus(spdAndStatus)
            })

            accidentPoints.addAccidentPoint(point)
          }
          accidentPoints

        case VtdrCmdConsts.QRY_DRIVE_OVER_TIME_11 =>
          val driveOverTime = new JT808Vtdr_DriveOverTime_11
          while (body.isReadable) {
            val entry = new Vtdr_DriveOverTimeEntry
            entry.setLicenseNo(readFixedLenCStr(body, 18))
            entry.setStartTime(decodeDateTime(body))
            entry.setEndTime(decodeDateTime(body))
            entry.setStartLocation(decodeLocation)
            entry.setEndLocation(decodeLocation)
            driveOverTime.addDriveOverTimeEntry(entry)
          }
          driveOverTime

        case VtdrCmdConsts.QRY_DRIVER_CARD_EVENTS_12 =>
          val driverCardEvents = new JT808Vtdr_DriverCardEvents_12
          while (body.isReadable) {
            val event = new Vtdr_CardEvent
            event.setTime(decodeDateTime(body))
            event.setLicenseNo(readFixedLenCStr(body, 18))
            event.setTyp(body.readByte())
            driverCardEvents.addCardEvent(event)
          }
          driverCardEvents

        case VtdrCmdConsts.QRY_POWER_EVENTS_13 =>
          val powerEvents = new JT808Vtdr_PowerEvents_13
          while (body.isReadable) {
            val event = new Vtdr_PowerEvent
            event.setTime(decodeDateTime(body))
            event.setTyp(body.readByte())
            powerEvents.addPowerEvent(event)
          }
          powerEvents

        case VtdrCmdConsts.QRY_REV_EVENTS_14 =>
          val revEvents = new JT808Vtdr_RevEvents_14
          while (body.isReadable) {
            val event = new Vtdr_RevEvent
            event.setTime(decodeDateTime(body))
            event.setCmd(body.readByte())
            revEvents.addRevEvent(event)
          }
          revEvents

        case VtdrCmdConsts.QRY_SPD_STATUS_LOG_15 =>
          val spdStatusLog = new JT808Vtdr_SpdStatusLog_15
          while (body.isReadable) {
            val logRec = new Vtdr_LogRec
            logRec.setSpdState(body.readByte())
            logRec.setStartTime(decodeDateTime(body))
            logRec.setEndTime(decodeDateTime(body))
            for (_ <- 1 to 60) {
              val entry = new Vtdr_SpdLogEntry
              entry.setRecSpd(body.readUnsignedByte())
              entry.setRefSpd(body.readUnsignedByte())
              logRec.addSpdLogEntry(entry)
            }
            spdStatusLog.addLogRecord(logRec)
          }
          spdStatusLog

        case _ =>
          throw new RuntimeException(s"Unsupported VTDR command: $cmd.")
      }

    ackParams.setDataBlock(dataBlock)

    m.setAckParams(ackParams)
  }
}
