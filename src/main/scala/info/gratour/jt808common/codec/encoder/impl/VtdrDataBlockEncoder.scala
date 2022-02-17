/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

//import info.gratour.common.error.ErrorWithCode
//import info.gratour.common.utils.BcdUtils
//import info.gratour.jt808common.protocol.msg.types.vtdr.{JT808VTDRDataBlock, JT808VTDR_DriverInfo_01, JT808VTDR_Id_07, JT808VTDR_Mileage_03, JT808VTDR_PulseFactor_04, JT808VTDR_SpdRecords_08, JT808VTDR_StatusSignalConfig_06, JT808VTDR_Time_02, JT808VTDR_VehInfo_05, JT808VTDR_VerInfo_00}
//import io.netty.buffer.{ByteBuf, ByteBufAllocator}
//import org.apache.commons.codec.binary.Hex
//import org.apache.commons.lang3.StringUtils

object VtdrDataBlockEncoder {

//  def encode(dataBlock: JT808VTDRDataBlock, out: ByteBuf): Unit = {
//
//    def checkDateTime(dt: String, propName: String): Unit = {
//      if (dt == null || dt.length != 6)
//        throw ErrorWithCode.invalidParam(propName)
//    }
//
//    def writeDateTime(dt: String, propName: String): Unit = {
//      checkDateTime(dt, propName)
//      val bytes = Hex.decodeHex(dt)
//      out.writeBytes(bytes)
//    }
//
//    def writeMile(mile: Float): Unit = {
//      val i = (mile * 10).toInt
//      val s = StringUtils.leftPad(i.toString, 8, '0')
//      val bytes = Hex.decodeHex(s)
//      out.writeBytes(bytes)
//    }
//
//    def write2DigitBcd(value: String): Unit = {
//      out.writeByte(BcdUtils.encodeByte(value.toInt))
//    }
//
//    def write8DigitBcd(value: String, propName: String): Unit = {
//      val bytes = BcdUtils.encode(value)
//      if (bytes.length != 8)
//        throw ErrorWithCode.invalidParam(propName)
//
//      out.writeBytes(bytes)
//    }
//
//    dataBlock match {
//      case verInfo_00: JT808VTDR_VerInfo_00 =>
//        write2DigitBcd(verInfo_00.getYear)
//        write2DigitBcd(verInfo_00.getRev)
//
//      case driverInfo_01: JT808VTDR_DriverInfo_01 =>
//        out.writeFixedLenStr(driverInfo_01.getLicenseNo, 18)
//
//      case time_02: JT808VTDR_Time_02 =>
//        checkDateTime(time_02.getDateTime, "dateTime")
//
//        val bytes = Hex.decodeHex(time_02.getDateTime)
//        out.writeBytes(bytes)
//
//      case mileage_03: JT808VTDR_Mileage_03 =>
//        writeDateTime(mileage_03.getDateTime, "dateTime")
//        writeDateTime(mileage_03.getInstallTime, "installTime")
//        writeMile(mileage_03.getInitMile)
//        writeMile(mileage_03.getMile)
//
//      case factor_04: JT808VTDR_PulseFactor_04 =>
//        writeDateTime(factor_04.getDateTime, "dateTime")
//        out.writeShort(factor_04.getFactor)
//
//      case info_05: JT808VTDR_VehInfo_05 =>
//        out.writeFixedLenStr(info_05.getVin, 17)
//        out.writeFixedLenStr(info_05.getPlateNo, 9)
//        out.writeFixedLenStr(info_05.getPlateCategory, 8)
//
//      case config_06: JT808VTDR_StatusSignalConfig_06 =>
//        writeDateTime(config_06.getDateTime, "dateTime")
//        if (config_06.getStatus == null || config_06.getStatus.isEmpty)
//          throw ErrorWithCode.invalidParam("status")
//        out.writeByte(config_06.getStatus.size())
//        config_06.getStatus.forEach(st => {
//          st.getBitDesc.forEach(desc => {
//            out.writeFixedLenStr(desc, 10)
//          })
//        })
//
//      case id_07: JT808VTDR_Id_07 =>
//        out.writeFixedLenStr(id_07.getCcc, 7)
//        out.writeFixedLenStr(id_07.getModel, 16)
//        write2DigitBcd(id_07.getProdYear)
//        write2DigitBcd(id_07.getProdMonth)
//        write2DigitBcd(id_07.getProdDay)
//        write8DigitBcd(id_07.getSerialNum.toString, "serialNum")
//        out.writeZero(5)
//
//      case records_08: JT808VTDR_SpdRecords_08 =>
//        if (records_08.getSpdRecords == null || records_08.getSpdRecords.isEmpty)
//          throw ErrorWithCode.invalidParam("spdRecords")
//        records_08.getSpdRecords.forEach(spdRec => {
//          writeDateTime(spdRec.getStartTime, "startTime")
//          if (spdRec.getSpdAndStatus == null || spdRec.getSpdAndStatus.isEmpty)
//            throw ErrorWithCode.invalidParam("spdAndStatus")
//
//          spdRec.getSpdAndStatus.forEach(spdAndStatus => {
//
//          })
//        })
//
//      case _ =>
//        ???
//    }
//  }
//
//  def encodeToString(dataBlock: JT808VTDRDataBlock, alloc: ByteBufAllocator): String = {
//    val out = alloc.buffer()
//    try {
//      encode(dataBlock, out)
//
//      val sz = out.readableBytes()
//      val bytes = new Array[Byte](sz)
//      out.readBytes(bytes)
//      new String(bytes)
//    } finally {
//      out.release()
//    }
//  }
}
