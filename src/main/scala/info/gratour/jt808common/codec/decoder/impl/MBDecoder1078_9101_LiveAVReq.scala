/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9101_LiveAVReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9101_LiveAVReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder1078_9101_LiveAVReq extends JT808MsgBodyDecoder[JT1078Msg_9101_LiveAVReq]{

  override def decodeMsgBody(m: JT1078Msg_9101_LiveAVReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {

    val cp = new CP_9101_LiveAVReq
    cp.setServerIp(body.readByteLenPrefixedStr())
    cp.setTcpPort(body.readUnsignedShort())
    cp.setUdpPort(body.readUnsignedShort())
    cp.setChannel(body.readByte())
    cp.setDataType(body.readByte())
    cp.setCodeStream(body.readByte())

    m.setParams(cp)
  }

}
