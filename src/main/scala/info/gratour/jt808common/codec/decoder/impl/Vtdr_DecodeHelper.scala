/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.protocol.msg.types.vtdr.Vtdr_SpdAndStatus
import info.gratour.jtcommon.{BcdUtils, JTConsts, JTUtils}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

trait Vtdr_DecodeHelper {

  def decode2DigitBcdStr(buf: ByteBuf): String = {
    val b = buf.readByte()
    BcdUtils.decodeByte(b).toString
  }

  def decode8DigitBcdStr(buf: ByteBuf): String = {
    val temp = new Array[Byte](4)
    buf.readBytes(temp)
    Hex.encodeHexString(temp)
  }

  def decodeDateTime(buf: ByteBuf): String = {
    val temp: Array[Byte] = new Array[Byte](6)
    buf.readBytes(temp)
    Hex.encodeHexString(temp)
  }

  def readFixedLenStr(buf: ByteBuf, len: Int): String = {
    val temp: Array[Byte] = new Array[Byte](len)
    buf.readBytes(temp)
    new String(temp, JTConsts.DEFAULT_CHARSET)
  }

  def readFixedLenCStr(buf: ByteBuf, len: Int): String = {
    val temp: Array[Byte] = new Array[Byte](len)
    buf.readBytes(temp)
    JTUtils.cStr(temp, JTConsts.DEFAULT_CHARSET)
  }

  def decodeSpdAndStatus(buf: ByteBuf): Vtdr_SpdAndStatus = {
    val b = buf.readByte()
    if (b == -1) {
      buf.skipBytes(1)
      return null
    }

    val r = new Vtdr_SpdAndStatus
    r.setSpd((b & 0xFF).toShort)
    r.setStatus(buf.readByte())
    r
  }

}
