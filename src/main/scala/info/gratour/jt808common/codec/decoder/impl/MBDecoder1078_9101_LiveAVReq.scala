/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder2019Support
import info.gratour.jt808common.protocol.msg.JT1078Msg_9101_LiveAVReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9101_LiveAVReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder1078_9101_LiveAVReq extends JT808MsgBodyDecoder2019Support[JT1078Msg_9101_LiveAVReq]{

  override def decodeMsgBodyNew(protoVer: Byte, m: JT1078Msg_9101_LiveAVReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val cp = new CP_9101_LiveAVReq
    cp.setServerIp(body.readByteLenPrefixedStr())
    val tcpPort = body.readUnsignedShort()
    val udpPort = body.readUnsignedShort()

    if (protoVer > 0) {
      cp.setTcpPort2019(tcpPort)
      cp.setUdpPort2019(udpPort)
    } else {
      cp.setTcpPort(tcpPort)
      cp.setUdpPort(udpPort)
    }

    cp.setChannel(body.readByte())
    cp.setDataType(body.readByte())
    cp.setCodeStream(body.readByte())

    m.setParams(cp)
  }

}
