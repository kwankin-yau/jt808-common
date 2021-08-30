/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0700_VTDRData
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0700_VTDRData
import info.gratour.jt808common.protocol.msg.types.vtdr.{JT808VTDRDataBlock, JT808VTDR_AccidentPoints_10, JT808VTDR_DriveOverTime_11, JT808VTDR_DriverCardEvents_12, JT808VTDR_DriverInfo_01, JT808VTDR_Id_07, JT808VTDR_Locations_09, JT808VTDR_Mileage_03, JT808VTDR_PowerEvents_13, JT808VTDR_PulseFactor_04, JT808VTDR_RevEvents_14, JT808VTDR_SpdRecords_08, JT808VTDR_SpdStatusLog_15, JT808VTDR_StatusSignalConfig_06, JT808VTDR_Time_02, JT808VTDR_VehInfo_05, JT808VTDR_VerInfo_00, VTDRCmdConsts, VTDR_AccidentPoint, VTDR_CardEvent, VTDR_DriveOverTimeEntry, VTDR_Location, VTDR_LocationAndSpd, VTDR_LocationInfoPerHour, VTDR_LogRec, VTDR_PowerEvent, VTDR_RevEvent, VTDR_SpdAndStatus, VTDR_SpdLogEntry, VTDR_SpdRec, VTDR_Status}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBDecoder808_0700_VTDRData extends JT808MsgBodyDecoder[JT808Msg_0700_VTDRData] with VTDR_DecodeHelper {
  override def decodeMsgBody(m: JT808Msg_0700_VTDRData, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val ackParams = new JT808AckParams_0700_VTDRData
    val cmd = body.readByte()
    ackParams.setCmd(cmd)

    val bytes = new Array[Byte](body.readableBytes())
    body.getBytes(body.readerIndex(), bytes)
    ackParams.setRaw(Hex.encodeHexString(bytes))


    def decodeLocation: VTDR_Location = {
      val r = new VTDR_Location
      r.setLng(intAxisToDouble(body.readInt()))
      r.setLat(intAxisToDouble(body.readInt()))
      r.setAlt(body.readShort())
      r
    }

    val dataBlock: JT808VTDRDataBlock =
      cmd match {
        case VTDRCmdConsts.QRY_VER_INFO_00 =>
          val verInfo = new JT808VTDR_VerInfo_00
          verInfo.setYear(decode2DigitBcdStr(body))
          verInfo.setRev(decode2DigitBcdStr(body))
          verInfo

        case VTDRCmdConsts.QRY_DRIVER_INFO_01 =>
          val driverInfo = new JT808VTDR_DriverInfo_01
          driverInfo.setLicenseNo(readFixedLenCStr(body, 18))
          driverInfo

        case VTDRCmdConsts.QRY_TIME_02 =>
          val time = new JT808VTDR_Time_02
          time.setDateTime(decodeDateTime(body))
          time

        case VTDRCmdConsts.QRY_MILEAGE_03 =>
          val mileage = new JT808VTDR_Mileage_03
          mileage.setDateTime(decodeDateTime(body))
          mileage.setInstallTime(decodeDateTime(body))
          mileage.setInitMile(decode8DigitBcdStr(body).toFloat * 0.1f)
          mileage.setMile(decode8DigitBcdStr(body).toFloat * 0.1f)
          mileage

        case VTDRCmdConsts.QRY_PULSE_FACTOR_04 =>
          val pulseFactor = new JT808VTDR_PulseFactor_04
          pulseFactor.setDateTime(decodeDateTime(body))
          pulseFactor.setFactor(body.readShort() & 0xFFFF)
          pulseFactor

        case VTDRCmdConsts.QRY_VEH_INFO_05 =>
          val vehInfo = new JT808VTDR_VehInfo_05
          vehInfo.setVin(readFixedLenStr(body, 17))
          vehInfo.setPlateNo(readFixedLenCStr(body, 9))
          vehInfo.setPlateCategory(readFixedLenCStr(body, 8))
          vehInfo

        case VTDRCmdConsts.QRY_STATUS_SIGNAL_CONFIG_06 =>
          val config = new JT808VTDR_StatusSignalConfig_06
          config.setDateTime(decodeDateTime(body))
          val cnt = body.readUnsignedByte()
          (1 to cnt).foreach { _ =>
            val status = new VTDR_Status
            (1 to 8).foreach { _ =>
              val desc = readFixedLenCStr(body, 10)
              status.addBitDesc(desc)
            }
            config.addStatus(status)
          }
          config

        case VTDRCmdConsts.QRY_ID_07 =>
          val id = new JT808VTDR_Id_07
          id.setCcc(readFixedLenCStr(body, 7))
          id.setModel(readFixedLenCStr(body, 16))
          id.setProdYear(decode2DigitBcdStr(body))
          id.setProdMonth(decode2DigitBcdStr(body))
          id.setProdDay(decode2DigitBcdStr(body))
          id.setSerialNum(decode8DigitBcdStr(body).toInt)
          body.skipBytes(5)
          id

        case VTDRCmdConsts.QRY_SPD_RECORDS_08 =>
          val spdRecords = new JT808VTDR_SpdRecords_08
          while (body.readableBytes() > 0) {
            val spdRec = new VTDR_SpdRec
            spdRec.setStartTime(decodeDateTime(body))
            (1 to 60).foreach(_ => {
              val spdAndStatus = decodeSpdAndStatus(body)
              if (spdAndStatus != null)
                spdRec.addSpdAndStatus(spdAndStatus)
            })

            spdRecords.addSpdRec(spdRec)
          }
          spdRecords

        case VTDRCmdConsts.QRY_LOCATIONS_09 =>
          val locations = new JT808VTDR_Locations_09
          while (body.isReadable) {
            val locationInfoPerHour = new VTDR_LocationInfoPerHour
            locationInfoPerHour.setStartTime(decodeDateTime(body))
            (1 to 60).foreach(_ => {
              val lng = body.readInt()
              val lat = body.readInt()
              val alt = body.readShort()
              val spd = body.readUnsignedByte()

              if (lat != -1) {
                val locationAndSpd = new VTDR_LocationAndSpd
                val location = new VTDR_Location

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

        case VTDRCmdConsts.QRY_ACCIDENT_POINTS_10 =>
          val accidentPoints = new JT808VTDR_AccidentPoints_10
          while (body.isReadable) {
            val point = new VTDR_AccidentPoint
            point.setEndTime(decodeDateTime(body))
            point.setLicenseNo(readFixedLenCStr(body, 18))
            point.setSpd(body.readUnsignedByte())
            point.setStatus(body.readByte())
            (1 to 100).foreach(_ => {
              val spdAndStatus = new VTDR_SpdAndStatus
              spdAndStatus.setSpd(body.readUnsignedByte())
              spdAndStatus.setStatus(body.readByte())
              point.addSpdAndStatus(spdAndStatus)
            })

            accidentPoints.addAccidentPoint(point)
          }
          accidentPoints

        case VTDRCmdConsts.QRY_DRIVE_OVER_TIME_11 =>
          val driveOverTime = new JT808VTDR_DriveOverTime_11
          while (body.isReadable) {
            val entry = new VTDR_DriveOverTimeEntry
            entry.setLicenseNo(readFixedLenCStr(body, 18))
            entry.setStartTime(decodeDateTime(body))
            entry.setEndTime(decodeDateTime(body))
            entry.setStartLocation(decodeLocation)
            entry.setEndLocation(decodeLocation)
            driveOverTime.addDriveOverTimeEntry(entry)
          }
          driveOverTime

        case VTDRCmdConsts.QRY_DRIVER_CARD_EVENTS_12 =>
          val driverCardEvents = new JT808VTDR_DriverCardEvents_12
          while (body.isReadable) {
            val event = new VTDR_CardEvent
            event.setTime(decodeDateTime(body))
            event.setLicenseNo(readFixedLenCStr(body, 18))
            event.setTyp(body.readByte())
            driverCardEvents.addCardEvent(event)
          }
          driverCardEvents

        case VTDRCmdConsts.QRY_POWER_EVENTS_13 =>
          val powerEvents = new JT808VTDR_PowerEvents_13
          while (body.isReadable) {
            val event = new VTDR_PowerEvent
            event.setTime(decodeDateTime(body))
            event.setTyp(body.readByte())
            powerEvents.addPowerEvent(event)
          }
          powerEvents

        case VTDRCmdConsts.QRY_REV_EVENTS_14 =>
          val revEvents = new JT808VTDR_RevEvents_14
          while (body.isReadable) {
            val event = new VTDR_RevEvent
            event.setTime(decodeDateTime(body))
            event.setCmd(body.readByte())
            revEvents.addRevEvent(event)
          }
          revEvents

        case VTDRCmdConsts.QRY_SPD_STATUS_LOG_15 =>
          val spdStatusLog = new JT808VTDR_SpdStatusLog_15
          while (body.isReadable) {
            val logRec = new VTDR_LogRec
            logRec.setSpdState(body.readByte())
            logRec.setStartTime(decodeDateTime(body))
            logRec.setEndTime(decodeDateTime(body))
            for (_ <- 1 to 60) {
              val entry = new VTDR_SpdLogEntry
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
