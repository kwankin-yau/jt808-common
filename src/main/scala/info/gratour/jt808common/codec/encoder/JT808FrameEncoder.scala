package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.{AdasDialect, JT808Consts}
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jtcommon.{BcdUtils, JTConsts, JTUtils}
import io.netty.buffer.ByteBuf
import org.apache.commons.lang3.StringUtils

object JT808FrameEncoder {

  @inline private def escapeByte(b: Byte, out: ByteBuf): Unit = {
    b match {
      case 0x7e =>
        out.writeShort(0x7d02)

      case 0x7d =>
        out.writeShort(0x7d01)

      case _ =>
        out.writeByte(b)
    }
  }

  /**
   * Encode message to frames. The encoded frames are crc-calculated and escaped.
   *
   * @param protoVer        protocol version, 0 for REV_2013, 1 for REV_2019, see also `PROTO_VER` serial constant
   *                        defined in [[info.gratour.jt808common.JT808Consts.ProtocolVersions]]
   * @param adasDialect     ADAS Dialect
   * @param seqNumAllocator message sequence number allocator.
   * @param m               message to encode
   * @param bodyEncoder     message body encoder
   * @param tempBuf         content in tempBuf will be clear
   * @param out             output buffer
   * @return packet/fragment count. One message may produce 1 or more packets, 1 packet may produce 1 or more fragments.
   *         This count is count in fragments.
   */
  def encode(
              protoVer: Byte,
              adasDialect: AdasDialect,
              seqNumAllocator: SeqNumAllocator,
              m: JT808Msg,
              bodyEncoder: JT808MsgBodyEncoder,
              tempBuf: ByteBuf,
              out: ByteBuf
            ): Int = {

    def calcCrcAndEscape(buf: ByteBuf): Unit = {
      out.writeByte(0x7E)
      val count = buf.readableBytes

      val bytes = new Array[Byte](count)
      buf.readBytes(bytes)

      var crc = 0

      for (idx <- 0 until count) {
        val b = bytes(idx)
        crc ^= b
        if (b == 0x7e)
          out.writeShort(0x7d02)
        else if (b == 0x7d)
               out.writeShort(0x7d01)
             else
               out.writeByte(b)
      }

      if (crc == 0x7e)
        out.writeShort(0x7d02)
      else if (crc == 0x7d)
             out.writeShort(0x7d01)
           else
             out.writeByte(crc)

      out.writeByte(0x7E)
    }

    val msgId = m.getMsgId
    val simNo = m.getSimNo
    val seqNo = m.getSeqNo
    tempBuf.clear
    tempBuf.writeShort(msgId) // message id

    tempBuf.writeShort(0) // attributes

    val simNoMaxLen =
      if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019) {
        tempBuf.writeByte(protoVer) // protoVer
        20
      } else
        12


    val canonicalSimNum =
      if (simNo.length > simNoMaxLen) simNo.substring(0, simNoMaxLen)
      else if (simNo.length < simNoMaxLen) StringUtils.leftPad(simNo, simNoMaxLen, '0')
      else simNo

    val simNoBcd = BcdUtils.encode(canonicalSimNum)
    tempBuf.writeBytes(simNoBcd) // simNo

    tempBuf.writeShort(seqNo) // seqNo

    val index = tempBuf.writerIndex
    bodyEncoder.encBody(protoVer, adasDialect, m, tempBuf) // body
    val index2 = tempBuf.writerIndex
    val bodySize = index2 - index
    if (bodySize > 1023) {
      val body = tempBuf.slice(index, bodySize)
      var sz = bodySize
      var fragmentCount = bodySize / 1023
      if (bodySize % 1023 != 0)
        fragmentCount += 1

      var fragmentIndex = 1
      val temp2 = tempBuf.alloc().buffer()
      try {
        var first = true
        while (sz > 0) {
          val blockSz =
            if (sz > 1023)
              1023
            else
              sz


          temp2.clear()
          temp2.writeShort(msgId) // message id
          temp2.writeShort(0) // attributes
          if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019)
            temp2.writeByte(protoVer) // protoVer

          // simNo
          temp2.writeBytes(simNoBcd)

          // seq-no
          if (first) {
            temp2.writeShort(seqNo)
            first = false
          } else
            temp2.writeShort(seqNumAllocator.nextSeqNo())

          // fragment
          temp2.writeShort(fragmentCount)
          temp2.writeShort(fragmentIndex)

          temp2.writeBytes(body, blockSz)

          var flags = JTUtils.set(blockSz, 13)
          if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019)
            flags = JTUtils.set(flags, 14)

          temp2.setShort(2, flags)

          calcCrcAndEscape(temp2)


          fragmentIndex += 1
          sz -= blockSz
        }
      } finally {
        temp2.release()
      }

      fragmentCount
    } else {
      val attr =
        if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019)
          JTUtils.set(bodySize, 14)
        else
          bodySize

      tempBuf.setShort(2, attr)

      calcCrcAndEscape(tempBuf)

      1
    }
  }

}
