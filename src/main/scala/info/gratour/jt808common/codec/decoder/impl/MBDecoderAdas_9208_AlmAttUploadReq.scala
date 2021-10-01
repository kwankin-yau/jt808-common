/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder2019Support
import info.gratour.jt808common.protocol.msg.JTAdasMsg_9208_AlmAttUploadReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9208_AlmAddtUploadReq
import io.netty.buffer.ByteBuf

object MBDecoderAdas_9208_AlmAttUploadReq extends JT808MsgBodyDecoder2019Support[JTAdasMsg_9208_AlmAttUploadReq] {

  override def decodeMsgBodyNew(protoVer: Byte, m: JTAdasMsg_9208_AlmAttUploadReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9208_AlmAddtUploadReq
    cp.setServerIp(body.readByteLenPrefixedStr())
    cp.setTcpPort(body.readUnsignedShort())
    cp.setUdpPort(body.readUnsignedShort())


    val almNoLen = if (protoVer > 1) 40 else 16
    cp.setAlmNo(body.readBytesHex(almNoLen))
    cp.setAlmId(body.readBytesHex(32))

    body.skipBytes(16)
  }

}
