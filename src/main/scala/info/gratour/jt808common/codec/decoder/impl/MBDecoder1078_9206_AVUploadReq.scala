/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9206_AVUploadReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9206_AVUploadReq
import io.netty.buffer.ByteBuf

object MBDecoder1078_9206_AVUploadReq extends JT808MsgBodyDecoder[JT1078Msg_9206_AVUploadReq] {

  override def decodeMsgBody(m: JT1078Msg_9206_AVUploadReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9206_AVUploadReq

    cp.setFtpHost(body.readByteLenPrefixedStr())

    cp.setFtpPort(body.readUnsignedShort())

    cp.setFtpUser(body.readByteLenPrefixedStr())

    cp.setFtpPwd(body.readByteLenPrefixedStr())

    cp.setUploadPath(body.readByteLenPrefixedStr())

    cp.setChannel(body.readByte())

    cp.setStartTime(body.readBcd6Timestamp(tempBuf))

    cp.setEndTime(body.readBcd6Timestamp(tempBuf))

    cp.setAlarmStateFilter1078(body.readInt())

    cp.setAlarmStateFilter808(body.readInt())

    cp.setMediaType(body.readByte())

    cp.setCodeStream(body.readByte())

    cp.setStorageType(body.readByte())

    cp.setWhen(body.readByte())

    m.setParams(cp)
  }

}
