package info.gratour.jt808common

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDate, LocalDateTime, OffsetDateTime}

import info.gratour.jtcommon.{BcdUtils, JTConsts}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex

import scala.util.Random

object JT808Utils {

  private val random = new Random()

  def newAuthCode(): String = {
    val bytes = new Array[Byte](5)
    random.nextBytes(bytes)
    Hex.encodeHexString(bytes)
  }

  def bcd6ToTimestamp(bcd: Array[Byte], offset: Int): Long = {
    val y = BcdUtils.decodeByte(bcd(offset + 0)) + 2000
    val m = BcdUtils.decodeByte(bcd(offset + 1))
    val d = BcdUtils.decodeByte(bcd(offset + 2))
    val h = BcdUtils.decodeByte(bcd(offset + 3))
    val min = BcdUtils.decodeByte(bcd(offset + 4))
    val s = BcdUtils.decodeByte(bcd(offset + 5))

    val odt = OffsetDateTime.of(y, m, d, h, min, s, 0, JTConsts.ZONE_OFFSET_BEIJING)
    odt.toEpochSecond * 1000
  }

  def bcd6ToTimestamp(bcd: Array[Byte]): Long = bcd6ToTimestamp(bcd, 0)

  case class SixDigitsDateTime(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int) {
    def toBcd6: Array[Byte] = {
      val r = new Array[Byte](6)
      val y =
        if (year > 0)
          year - 2000
      else
        year
      r(0) = BcdUtils.encodeByte(y)
      r(1) = BcdUtils.encodeByte(month)
      r(2) = BcdUtils.encodeByte(day)
      r(3) = BcdUtils.encodeByte(hour)
      r(4) = BcdUtils.encodeByte(minute)
      r(5) = BcdUtils.encodeByte(second)

      r
    }
  }

  def parseSixDigitsDateTime(s: String): SixDigitsDateTime = {
    if (s == null)
      return SixDigitsDateTime(0, 0, 0, 0, 0, 0)

    if (s.length != 17)
      throw new RuntimeException("Invalid parameter: `Six digits date time`.")

    var year = s.substring(0, 2).toInt
    if (year > 0)
      year += 2000
    val month = s.substring(3, 5).toInt
    val day = s.substring(6, 8).toInt
    val hour = s.substring(9, 11).toInt
    val minute = s.substring(12, 14).toInt
    val second = s.substring(15).toInt

    SixDigitsDateTime(year, month, day, hour, minute, second)
  }

  def timestampToBcd6(time: Long, out: ByteBuf): Unit = {
    val odt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(time), JTConsts.ZONE_OFFSET_BEIJING)
    val y = odt.getYear - 2000
    val m = odt.getMonthValue
    val d = odt.getDayOfMonth
    val h = odt.getHour
    val min = odt.getMinute
    val s = odt.getSecond


    out.writeByte(BcdUtils.encodeByte(y))
    out.writeByte(BcdUtils.encodeByte(m))
    out.writeByte(BcdUtils.encodeByte(d))
    out.writeByte(BcdUtils.encodeByte(h))
    out.writeByte(BcdUtils.encodeByte(min))
    out.writeByte(BcdUtils.encodeByte(s))
  }

  def timestampToBcd6(time: Long): Array[Byte] = {
    val odt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(time), JTConsts.ZONE_OFFSET_BEIJING)
    val y = odt.getYear - 2000
    val m = odt.getMonthValue
    val d = odt.getDayOfMonth
    val h = odt.getHour
    val min = odt.getMinute
    val s = odt.getSecond


    Array(BcdUtils.encodeByte(y), BcdUtils.encodeByte(m), BcdUtils.encodeByte(d), BcdUtils.encodeByte(h), BcdUtils.encodeByte(min), BcdUtils.encodeByte(s))
  }

  def localDateTimeToBcd6(ldt: LocalDateTime): Array[Byte] = {
    val y = ldt.getYear - 2000
    val m = ldt.getMonthValue
    val d = ldt.getDayOfMonth
    val h = ldt.getHour
    val min = ldt.getMinute
    val s = ldt.getSecond


    Array(BcdUtils.encodeByte(y), BcdUtils.encodeByte(m), BcdUtils.encodeByte(d), BcdUtils.encodeByte(h), BcdUtils.encodeByte(min), BcdUtils.encodeByte(s))
  }

  def readBcd6Timestamp(byteBuf: ByteBuf, tempBuf: Array[Byte], offset: Int): Long = {
    byteBuf.readBytes(tempBuf, offset, 6)
    bcd6ToTimestamp(tempBuf, 0)
  }

  def readBcd6Timestamp(byteBuf: ByteBuf, tempBuf: Array[Byte]): Long = readBcd6Timestamp(byteBuf, tempBuf, 0)

  def bcd4ToLocalDate(bcd: Array[Byte], offset: Int): LocalDate = {

    def b(delta: Int): Byte = {
      BcdUtils.decodeByte(bcd(offset + delta))
    }

    val y = b(0) * 100 + b(1)
    val m = b(2)
    val d = b(3)

    LocalDate.of(y, m, d)
  }

  def bcd4ToLocalDate(bcd: Array[Byte]): LocalDate = bcd4ToLocalDate(bcd, 0)

  val VTDR_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");

  def vtdrStrToLocalDateTime(s: String): LocalDateTime = {
    if (s == null)
      throw new RuntimeException("Invalid parameter: `vtdr string`.");

    var hex: Array[Byte] = null
    try hex = Hex.decodeHex(s)
    catch {
      case _: DecoderException =>
        throw new RuntimeException("Invalid parameter: `vtdr string`.")
    }

    if (hex.length != 6) throw new RuntimeException("Invalid parameter: `vtdr string`.")

    val year = 2000 + hex(0)
    val month = hex(1)
    val day = hex(2)
    val hour = hex(3)
    val minute = hex(4)
    val second = hex(5)

    LocalDateTime.of(year, month, day, hour, minute, second)
  }

  def vtdrLocalDateTimeToStr(dateTime: LocalDateTime): String = dateTime.format(VTDR_DATE_TIME_FORMATTER)

//  def encodeTrkIdWithEpochDay(seqValue: Long, epochDay: Long): Long = {
//    val hiLong = epochDay << (64 - 18)
//    val loLong = seqValue & 0x3FFFFFFFFFFFL
//    hiLong | loLong
//  }
//
//  def encodeTrkId(seqValue: Long, time: EpochMillis): Long = {
//    val epochDay = time.toInstant.atOffset(Consts.ZONE_OFFSET_BEIJING).toLocalDate.toEpochDay
//    encodeTrkIdWithEpochDay(seqValue, epochDay)
//  }
//
//  def decodeEpochDayOfTrk(trkId: Long): Long = {
//    val v = trkId & 0xFFFFC00000000000L;
//    v >>> (64 - 18)
//  }
//
//  def decodeDateOfTrk(trkId: Long): LocalDate = {
//    val epochDay = decodeEpochDayOfTrk(trkId)
//    LocalDate.ofEpochDay(epochDay)
//  }
//
//  def encodeAlmIdWithEpochDay(seqValue: Long, epochDay: Long): Long = encodeTrkIdWithEpochDay(seqValue, epochDay)
//  def encodeAlmId(seqValue: Long, time: EpochMillis): Long = encodeTrkId(seqValue, time)
//  def decodeEpochDayOfAlm(almId: Long): Long = decodeEpochDayOfTrk(almId)
//  def decodeDateOfAlm(almId: Long): LocalDate = decodeDateOfTrk(almId)
//
//  /**
//   * Decode datetime range from encoded trk/alm ID.
//   *
//   * @param encodedId encoded trk/alm Id
//   * @return (startEpochMillis, endEpochMillis) pair
//   */
//  def dateTimeRangeFromEncodedId(encodedId: Long): (Long, Long) = {
//    val date = JT808Utils.decodeDateOfTrk(encodedId)
//    val startDate = date.atStartOfDay(Consts.ZONE_OFFSET_BEIJING);
//    val nextDate = startDate.plusDays(1)
//    val startEpoch = startDate.toInstant.toEpochMilli
//    val endEpoch = nextDate.toInstant.toEpochMilli
//    (startEpoch, endEpoch)
//  }
}
