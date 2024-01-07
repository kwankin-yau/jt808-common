package info.gratour.jtcommon

import java.net.{InetAddress, UnknownHostException}
import java.nio.charset.Charset
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.util
import java.util.concurrent.ConcurrentHashMap

import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.protocol.msg.types.Coordinate
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex
import org.apache.commons.lang3.StringUtils
import org.apache.commons.validator.routines.InetAddressValidator
import org.xbill.DNS.{ARecord, Address, Lookup, SimpleResolver};

object JTUtils {

  private val logger = Logger(JTUtils.getClass)

  /**
   * 检测给定的值的某位是否置位。
   *
   * @param value    要检测的值。
   * @param bitIndex 位索引号，0-63。
   * @return 是否置位
   */
  def test(value: Int, bitIndex: Int): Boolean = (value & (1 << bitIndex)) != 0

  /**
   * 检测给定的值的某位是否置位。
   *
   * @param value    要检测的值。
   * @param bitIndex 位索引号，0-63。
   * @return 是否置位
   */
  def test(value: Long, bitIndex: Int): Boolean = (value & (1L << bitIndex)) != 0


  /**
   * 设置给定的值的某一位，返回新的值。32位版。
   *
   * @param value    给定的值。
   * @param bitIndex 位索引号，0-31。
   * @return 被置位后的新值。
   */
  def set(value: Int, bitIndex: Int): Int = {
    val value2 = 1 << bitIndex
    value | value2
  }

  /**
   * 清除给定的值的某一位，返回新的值。32位版。
   *
   * @param value    给定的值。
   * @param bitIndex 位索引号，0-31。
   * @return 被清除位后的新值。
   */
  def clear(value: Int, bitIndex: Int): Int = {
    val value2 = 1 << bitIndex
    value & ~value2
  }

  def intToHex(value: Int, minLen: Int, prepend0x: Boolean): String = {
    var r = Integer.toHexString(value)
    if (r.length < minLen)
      r = org.apache.commons.lang3.StringUtils.leftPad(r, minLen, '0')

    if (prepend0x)
      "0x" + r
    else
      r
  }

  def intToHex(value: Int, minLen: Int): String = intToHex(value, minLen, prepend0x = false)

  private val DIGITS = Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

  /**
   * 字节数组转HEX字符串。
   *
   * @param bytes
   * 给定的字节数组。
   * @return HEX字符串。
   */
  def hex(bytes: Array[Byte]): String = {
    if (bytes == null)
      return null
    else if (bytes.isEmpty)
      return "";

    val str = new StringBuilder
    for (b <- bytes) {
      str.append(DIGITS((0xF0 & b) >>> 4))
      str.append(DIGITS(0x0F & b))
    }
    str.toString
  }

  def hex(bytes: Array[Byte], offset: Int, len: Int): String = {
    if (bytes == null)
      return null

    val str = new StringBuilder
    var i = offset
    while ( {
      i < offset + len
    }) {
      val b = bytes(i)
      str.append(DIGITS((0xF0 & b) >>> 4))
      str.append(DIGITS(0x0F & b))

      {
        i += 1;
        i - 1
      }
    }
    str.toString
  }

  def hex(s: String): Array[Byte] = {
    if (s == null)
      return null

    val l = s.length
    if (l % 2 != 0)
      throw new RuntimeException(s"Invalid hexadecimal string `$s`.")

    val r = new Array[Byte](l / 2)
    var index = 0
    var h: Boolean = true
    var b: Byte = 0

    def put(digit: Int): Unit = {
      if (h) {
        b = (digit << 4).toByte
        h = false
      } else {
        b = (b | digit).toByte
        r(index) = b
        index = index + 1
        h = true
      }
    }

    s.foreach {
      case x if x >= '0' && x <= '9' =>
        put(x - '0')

      case x if x >= 'a' && x <= 'f' =>
        put(x - 'a' + 10)

      case x if x >= 'A' && x <= 'F' =>
        put(x - 'A' + 10)

      case _ =>
        throw new RuntimeException(s"Invalid hexadecimal string `$s`.")
    }

    r
  }


  def strLen(bytes: Array[Byte], offset: Int, maxLen: Int): Int = {
    val m =
      if (maxLen > (bytes.length - offset))
        bytes.length - offset
      else
        maxLen

    for (i <- 0 until m) {
      val b = bytes(i + offset)
      if (b == 0)
        return i
    }

    m
  }

  def strLen(bytes: Array[Byte], maxLen: Int): Int = strLen(bytes, 0, maxLen)

  def strLen(bytes: Array[Byte]): Int = strLen(bytes, 0, bytes.length)

  def cStr(bytes: Array[Byte], offset: Int, maxLen: Int): String = {
    if (bytes == null)
      return null

    val l = strLen(bytes, offset, maxLen)
    new String(bytes, offset, l)
  }

  def cStr(bytes: Array[Byte], maxLen: Int): String = cStr(bytes, 0, maxLen)

  def cStr(bytes: Array[Byte]): String =
    if (bytes == null)
      null
    else
      cStr(bytes, bytes.length)

  def cStr(bytes: Array[Byte], offset: Int, maxLen: Int, charset: Charset): String = {
    if (bytes == null)
      return null

    val l = strLen(bytes, offset, maxLen)
    new String(bytes, offset, l, charset)
  }

  def cStr(bytes: Array[Byte], maxLen: Int, charset: Charset): String = cStr(bytes, 0, maxLen, charset)

  def cStr(bytes: Array[Byte], charset: Charset): String =
    if (bytes == null)
      null
    else
      cStr(bytes, bytes.length, charset)

  def jtMsgIdOf(msgClass: Class[_]): Int = {
    val annotation = msgClass.getAnnotation(classOf[JTMsgId]);
    if (annotation == null) {
      val errMsg = s"The class $msgClass has no JTMsgId annotation definition."
      logger.error(errMsg)
      throw new RuntimeException(errMsg)
    }

    annotation.value()
  }

  case class MsgAckInfo(withSeqNo: Boolean)


  val MsgAckInfoMap: Map[String, MsgAckInfo] = {
    def e(msgId: String, withSeqNo: Boolean = true) =
      msgId -> MsgAckInfo(withSeqNo)

    Map(
      // jt808
      e("8103"),
      e("8104"),
      e("8106"),
      e("8105"),
      e("8107", false),
      e("8108"),
      e("8201"),
      e("8202"),
      e("8300"),
      e("8301"),
      e("8302"),
      e("8303"),
      e("8304"),
      e("8400"),
      e("8401"),
      e("8500"),
      e("8600"),
      e("8601"),
      e("8602"),
      e("8603"),
      e("8604"),
      e("8605"),
      e("8606"),
      e("8607"),
      e("8700"),
      e("8701"),
      e("8702", false),
      e("8801"),
      e("8802"),
      e("8803"),
      e("8804"),
      e("8805"),

      // jt1078
      e("9003", false),
      e("9101"),
      e("9102"),
      e("9205"),
      e("9201"),
      e("9202"),
      e("9206"),
      e("9207"),
      e("9301"),
      e("9302"),
      e("9303"),
      e("9304"),
      e("9305"),
      e("9306"),

      // si-chuan ADAS
      e("9208")
    )
  }

  def msgHasAck(msgId: String): Boolean = MsgAckInfoMap.contains(msgId)

  def isMsgAckWithSeqNo(msgId: String): Boolean = MsgAckInfoMap.get(msgId).exists(_.withSeqNo)


  def byteBufToHexStringKeepReaderIndex(buf: ByteBuf): String = {
    val readerIndex = buf.readerIndex
    val size = buf.readableBytes
    val bytes = new Array[Byte](size)
    buf.readBytes(bytes)
    buf.readerIndex(readerIndex)
    Hex.encodeHexString(bytes)
  }

  def stringMaxLen(bytes: Array[Byte], offset: Int, maxLen: Int): String = {
    var l = maxLen
    var break: Boolean = false
    for (i <- 0 until maxLen if !break) {
      val b = bytes(i + offset)
      if (b == 0) {
        l = i
        break = true
      }
    }

    new String(bytes, offset, l, JTConsts.DEFAULT_CHARSET)
  }

  val AxisFormatter: DecimalFormat = new DecimalFormat("0.000000")

  def formatAxis(axis: Double): String = AxisFormatter.format(axis)

  def intAxisToDouble(axis: Int): Double = axis / 1000000d

  def doubleAxisToInt(axis: Double): Int = (axis * 1000000).toInt

  def msgIdToHex(msgId: Int): String = intToHex(msgId, 4, prepend0x = false)
  def hexToMsgId(hex: String): Int = Integer.parseInt(hex, 16)

  def bitTest(value: Int, bitIndex: Int): Boolean = (value & (1 << bitIndex)) != 0

  //  private val SIM_NO_REGEX: Regex = "\\d{11,12}".r

  def isValidSimNo(simNo: String): Boolean = {
    //    (simNo != null) && SIM_NO_REGEX.pattern.matcher(simNo).matches()

    if (simNo == null)
      return false

    val l = simNo.length
    if (l < 1 || l > 20)
      return false

    (0 until l).foreach(i => {
      val c = simNo.charAt(i)
      if (c < '0' || c > '9')
        return false
    })

    true
  }

  /**
   * 是否有效的交通部796终端厂商ID（5位全数字）
   *
   * @param factoryId
   * @return
   */
  def isValidFactoryId(factoryId: String): Boolean = {
    if (factoryId != null && factoryId.length == 5) {
      factoryId.forall(Character.isDigit)
    } else
       false
  }

  def tryParseInt(s: String): java.lang.Integer =
    try
      s.toInt
    catch {
      case e: NumberFormatException =>
        null
    }

  def tryParseBool(value: String): java.lang.Boolean =
    try
      java.lang.Boolean.valueOf(value)
    catch {
      case e: IllegalArgumentException =>
        null
    }


  def isValidIpV4Addr(ipv4: String): Boolean =
    InetAddressValidator.getInstance().isValidInet4Address(ipv4)

  def isValidIpV6Addr(ipv6: String): Boolean =
    InetAddressValidator.getInstance().isValidInet6Address(ipv6)

  def isValidIp(ip: String): Boolean =
    InetAddressValidator.getInstance().isValid(ip)

  private val resolverMap = new ConcurrentHashMap[String, SimpleResolver]()

  /**
   * Determines the IP address of a host using specified dns server
   *
   * @param host The hostname to look up
   * @param dns  the dns server
   * @return The first matching IP address
   * @exception UnknownHostException The hostname does not have any addresses
   */
  def resolvePublicIp(host: String, dns: String): InetAddress = {
    if (dns == null)
      return Address.getByName(host)

    var resolver = resolverMap.get(dns)
    if (resolver == null) {
      resolver = new SimpleResolver(dns)
      val old = resolverMap.putIfAbsent(dns, resolver)
      if (old != null)
        resolver = old
    }

    val lookup = new Lookup(host)
    lookup.setResolver(resolver)

    val records = lookup.run()
    if (records != null && records.nonEmpty) {
      records(0).asInstanceOf[ARecord].getAddress
    } else
      throw new UnknownHostException(host)
  }


  def normalizeSimNo(simNo: String): String = {
    var start = -1
    var i = 0

    while (i < simNo.length && start == -1) {
      val c = simNo.charAt(i)
      if (c != '0')
        start = i
      i += 1
    }

    if (start >= 0)
      simNo.substring(start)
    else
      simNo
  }

  def decodeBcdDateTime(bytes: Array[Byte]): LocalDateTime = {
    val s = BcdUtils.decode(bytes, 0, 6)
    LocalDateTime.parse(s, JTConsts.BCD_DATE_TIME_FORMATTER)
  }

  def encodeBcdDateTime(dateTime: LocalDateTime, result: Array[Byte]): Unit = {
    result(0) = BcdUtils.encodeByte(dateTime.getYear - 2000)
    result(1) = BcdUtils.encodeByte(dateTime.getMonthValue)
    result(2) = BcdUtils.encodeByte(dateTime.getDayOfMonth)
    result(3) = BcdUtils.encodeByte(dateTime.getHour)
    result(4) = BcdUtils.encodeByte(dateTime.getMinute)
    result(5) = BcdUtils.encodeByte(dateTime.getSecond)
  }

  def encodeBcdDateTime(dateTime: LocalDateTime): Array[Byte] = {
    val r = new Array[Byte](6)
    encodeBcdDateTime(dateTime, r)
    r
  }

  private def decodeXY(s: String): Coordinate = {
    val xy = s.split(" ")
    if (xy.size < 2)
      return null
    new Coordinate(xy(0).toDouble, xy(1).toDouble)
  }

  private val POINT_PREFIX = "POINT("
  private val POINT_PREFIX_LEN = POINT_PREFIX.length

  def decodeWKTPoint(wktPoint: String): Coordinate = {
    if (wktPoint == null)
      null
    else {
      val pStart = wktPoint.indexOf(POINT_PREFIX)
      if (pStart < 0)
        return null
      val pEnd = wktPoint.indexOf(')', pStart + 1)
      if (pEnd <= pStart)
        return null

      val s = wktPoint.substring(pStart + POINT_PREFIX_LEN, pEnd)
      decodeXY(s)
    }
  }

  def encodeWKTPoint(coord: Coordinate): String =
    s"SRID=4326;POINT(${coord.lngStr()} ${coord.latStr()})"

  private val POLY_LEFT_PAREN = 1
  private val POLY_X = 2
  private val POLY_X_OR_SPACE = 3
  private val POLY_Y = 4

  private def internalDecodePolygon(s: String): java.util.List[java.util.List[Coordinate]] = {
    var st = POLY_LEFT_PAREN
    var i = 0
    var numStart = 0
    var x: Double = 0d
    var y: Double = 0d
    val r = new util.ArrayList[java.util.List[Coordinate]]()
    var currPolygon: util.ArrayList[Coordinate] = null

    val last = s.length - 1
    for (i <- 0 to last) {
      val c = s.charAt(i)

      st match {
        case POLY_LEFT_PAREN =>
          if (c == '(') {
            currPolygon = new util.ArrayList[Coordinate]()
            r.add(currPolygon)
            st = POLY_X
            numStart = i + 1
          }

        case POLY_X =>
          c match {
            case '+' | '-' | '.' =>
            case _ =>
              if (c == ' ') {
                val num = s.substring(numStart, i)
                x = num.toDouble
                st = POLY_Y
                numStart = i + 1
              } else if (!Character.isDigit(c))
                throw new RuntimeException(s"Invalid polygon `$s`.")
          }

        case POLY_X_OR_SPACE =>
          c match {
            case '+' | '-' | '.' =>
              if (numStart == -1) {
                numStart = i
                st = POLY_X
              }

            case ' ' =>
            case _ =>
              if (!Character.isDigit(c))
                throw new RuntimeException(s"Invalid polygon `$s`.")
              else {
                if (numStart == -1) {
                  numStart = i
                  st = POLY_X
                }
              }
          }

        case POLY_Y =>
          c match {
            case '+' | '-' | '.' =>
            case ')' =>
              val num = s.substring(numStart, i)
              y = num.toDouble
              val coord = new Coordinate(x, y)
              currPolygon.add(coord)

              st = POLY_LEFT_PAREN
            case ',' =>
              val num = s.substring(numStart, i)
              y = num.toDouble
              val coord = new Coordinate(x, y)
              currPolygon.add(coord)
              st = POLY_X_OR_SPACE
              numStart = -1
            case _ =>
              if (!Character.isDigit(c))
                throw new RuntimeException(s"Invalid polygon `$s`.")
          }
      }
    }

    r
  }

  private val POLYGON_PREFIX = "POLYGON("
  private val POLYGON_PREFIX_LEN = POLYGON_PREFIX.length

  def decodeWKTPolygon(wktPolygon: String): java.util.List[java.util.List[Coordinate]] = {
    if (wktPolygon == null)
      null
    else {
      val pStart = wktPolygon.indexOf(POLYGON_PREFIX)
      if (pStart < 0)
        return null

      val pEnd = wktPolygon.lastIndexOf(')')
      if (pEnd <= pStart)
        return null

      val s = wktPolygon.substring(pStart + POLYGON_PREFIX_LEN, pEnd)
      internalDecodePolygon(s)
    }
  }

  def decodeSimpleWKTPolygon(wktPolygon: String): java.util.List[Coordinate] = {
    if (wktPolygon == null)
      return null

    val ll = decodeWKTPolygon(wktPolygon)
    if (ll == null)
      return null

    if (ll.size() != 1)
      throw new RuntimeException(s"Not a simple polygon `$wktPolygon`.")

    ll.get(0)
  }

  def encodeWKTPolygon(vectors: java.util.List[Coordinate]): String = {
    val s = new java.lang.StringBuilder("SRID=4326;POLYGON((")
    for (i <- 0 until vectors.size()) {
      val coord = vectors.get(i)
      if (i > 0)
        s.append(',')
      s.append(coord.lngStr()).append(' ').append(coord.latStr())
    }
    s.append("))")
    s.toString
  }

}
