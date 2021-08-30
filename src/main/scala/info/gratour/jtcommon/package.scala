package info.gratour

import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

package object jtcommon {

  implicit class CollectionHelper[+T](collection: java.util.Collection[T]) {
    def find(p: T => Boolean): Option[T] = {
      val iter = collection.iterator()
      while (iter.hasNext) {
        val t = iter.next()
        if (p(t))
          return Some(t)
      }

      None
    }

    def exists(p: T => Boolean): Boolean = {
      val iter = collection.iterator()
      while (iter.hasNext) {
        val t = iter.next()
        if (p(t))
          return true
      }

      false
    }

    def removeWhere(p: T => Boolean): T = {
      val iter = collection.iterator()
      while (iter.hasNext) {
        val t = iter.next()
        if (p(t)) {
          iter.remove()
          return t
        }
      }

      null.asInstanceOf[T]
    }

    def nonEmpty: Boolean = !collection.isEmpty
  }

  implicit class ListHelper[+T](list: java.util.List[T]) {

    def indexWhere(p: T => Boolean): Int = {
      for (i <- 0 until list.size()) {
        val item = list.get(i)
        if (p(item))
          return i
      }

      -1
    }

    def nonEmpty: Boolean = !list.isEmpty
  }


  implicit class ByteBufHelper(byteBuf: ByteBuf) {

    def convertToByteArray: Array[Byte] = {
      if (byteBuf.hasArray)
        byteBuf.array()
      else {
        val readerIndex = byteBuf.readerIndex()
        byteBuf.readerIndex(0)
        val r = new Array[Byte](byteBuf.readableBytes())
        byteBuf.readBytes(r)
        byteBuf.readerIndex(readerIndex)
        r
      }
    }

    def remainingToHexString: String = {
      val size = byteBuf.readableBytes()
      if (size > 0) {
        val bytes = new Array[Byte](size)
        val readerIndex = byteBuf.readerIndex()
        byteBuf.readBytes(bytes)
        byteBuf.readerIndex(readerIndex)
        Hex.encodeHexString(bytes)
      } else
        ""
    }

    def readBytesLen(len: Int): Array[Byte] = {
      val r = new Array[Byte](len)
      byteBuf.readBytes(r)
      r
    }

    def readStr(len: Int): String = {
      val bytes = new Array[Byte](len)
      byteBuf.readBytes(bytes)
      new String(bytes, JTConsts.DEFAULT_CHARSET)
    }

    def readCStr(maxLen: Int): String = {
      val bytes = new Array[Byte](maxLen)
      byteBuf.readBytes(bytes)
      val l = JTUtils.strLen(bytes)
      new String(bytes, 0, l, JTConsts.DEFAULT_CHARSET)
    }

    def readStrMaxLen(maxLen: Int): String = {
      val bytes = new Array[Byte](maxLen)
      byteBuf.readBytes(bytes)

      JTUtils.stringMaxLen(bytes, 0, maxLen)
    }

    def readRemainingAsStr(): String = {
      val size = byteBuf.readableBytes()
      if (size > 0)
        readStr(size)
      else
        ""
    }

    private val EMPTY_BYTE_ARRAY: Array[Byte] = new Array[Byte](0)

    def readRemainingAsBytes(): Array[Byte] = {
      val size = byteBuf.readableBytes()
      if (size > 0) {
        val r = new Array[Byte](size)
        byteBuf.readBytes(r)
        r
      }
      else
        EMPTY_BYTE_ARRAY
    }

    def readByteLenPrefixedStr(): String = {
      val size = byteBuf.readUnsignedByte()
      readStr(size)
    }

    def readShortLenPrefixedStr(): String = {
      val size = byteBuf.readUnsignedShort()
      readStr(size)
    }

    def readIntLenPrefixedStr(): String = {
      val size = byteBuf.readInt()
      readStr(size)
    }

    def readBcd(bytes: Int): String = {
      val buf = new Array[Byte](bytes)
      byteBuf.readBytes(buf)
      BcdUtils.decode(buf)
    }

    def readAxis(): Double = {
      val i: Double = byteBuf.readInt()
      i / 1000000d
    }

    def writeStr(s: String): Unit = {
      if (s != null) {
        val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
        byteBuf.writeBytes(bytes)
      }
    }

    def writeFixedLenStr(s: String, len: Int): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeZero(len)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      val l = bytes.length
      if (l > len) {
        throw new RuntimeException(s"String `$s` is too long(limit=$len).")
      }

      byteBuf.writeBytes(bytes)
      val delta = len - l
      if (delta > 0)
        byteBuf.writeZero(delta)
    }

    def writeFixedLenBytes(bytes: Array[Byte], len: Int): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeZero(len)
        return
      }

      val l = bytes.length
      if (l > len) {
        throw new RuntimeException(s"Bytes `$bytes` is too long(limit=$len).")
      }

      byteBuf.writeBytes(bytes)
      val delta = len - l
      if (delta > 0)
        byteBuf.writeZero(delta)
    }

    def writeByteLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeByte(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeByte(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeShortLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeShort(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeShort(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeIntLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeInt(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeInt(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeByteLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeByte(0)
        return
      }

      byteBuf.writeByte(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeShortLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeShort(0)
        return
      }

      byteBuf.writeShort(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeIntLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeInt(0)
        return
      }

      byteBuf.writeInt(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeBcd(s: String): Unit = {
      val bytes = BcdUtils.encode(s)
      byteBuf.writeBytes(bytes)
    }

    def writeAxis(axis: Double): Unit = {
      val i = (axis * 1000000).toInt
      byteBuf.writeInt(i)
    }
  }

}
