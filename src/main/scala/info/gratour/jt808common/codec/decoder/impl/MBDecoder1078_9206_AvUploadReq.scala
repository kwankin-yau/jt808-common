/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9206_AvUploadReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9206_AvUploadReq
import io.netty.buffer.ByteBuf

object MBDecoder1078_9206_AvUploadReq extends JT808MsgBodyDecoder[JT1078Msg_9206_AvUploadReq] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9206_AvUploadReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9206_AvUploadReq

    cp.setFtpHost(body.readByteLenPrefixedStr())

    cp.setFtpPort(body.readUnsignedShort())

    cp.setFtpUser(body.readByteLenPrefixedStr())

    cp.setFtpPwd(body.readByteLenPrefixedStr())

    cp.setUploadPath(body.readByteLenPrefixedStr())

    cp.setChan(body.readByte())

    cp.setStartTm(body.readBcd6Timestamp(tempBuf))

    cp.setEndTm(body.readBcd6Timestamp(tempBuf))

    cp.setAlmFilter1078(body.readInt())

    cp.setAlmFilter808(body.readInt())

    cp.setMediaTyp(body.readByte())

    cp.setCodeStrm(body.readByte())

    cp.setStgTyp(body.readByte())

    cp.setWhen(body.readByte())

    m.setParams(cp)
  }

}
