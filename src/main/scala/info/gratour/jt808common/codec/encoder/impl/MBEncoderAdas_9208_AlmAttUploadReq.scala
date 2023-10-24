/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JTAdasMsg_9208_AlmAttUploadReq
import info.gratour.jtcommon.{ByteBufHelper, JTConsts}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBEncoderAdas_9208_AlmAttUploadReq extends AbstractJT808MsgBodyEncoder[JTAdasMsg_9208_AlmAttUploadReq] {

  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_9208_AlmAttUploadReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    out.writeShort(p.getTcpPort)
    out.writeShort(p.getUdpPort)
    val bytes = Hex.decodeHex(checkNotNull(p.getAlmNo, "almNo"))
    if (protoVer == 0) {
      if (bytes.length != 16)
        throw new CodecError("Invalid `almNo`: %s.".format(p.getAlmNo))
    } else {
      if (bytes.length != 40 && bytes.length != 16) // compatible with old
        throw new CodecError("Invalid `almNo`: %s.".format(p.getAlmNo))
    }
    out.writeBytes(bytes)
    //    out.writeFixedLenStr(StringUtils.leftPad(p.getAlmId.toString, 32, '0'), 32)
    //    out.writeFixedLenStr(p.getAlmId + ":" + p.getAlmTm1.toString, 32)
//    val id =
//      if (p.getAlmId.length < 32)
//        StringUtils.leftPad(p.getAlmId, 32, '0')
//      else
//        p.getAlmId

    out.writeFixedLenStr(p.getAlmId, 32)
    out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 16)
  }

}
