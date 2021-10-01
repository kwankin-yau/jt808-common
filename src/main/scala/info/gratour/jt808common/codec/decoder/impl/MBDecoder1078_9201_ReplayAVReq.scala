/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder2019Support
import info.gratour.jt808common.protocol.msg.JT1078Msg_9201_ReplayAVReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9201_ReplayAVReq
import io.netty.buffer.ByteBuf

object MBDecoder1078_9201_ReplayAVReq extends JT808MsgBodyDecoder2019Support[JT1078Msg_9201_ReplayAVReq] {

  override def decodeMsgBodyNew(protoVer: Byte, m: JT1078Msg_9201_ReplayAVReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9201_ReplayAVReq

    cp.setServerIp(body.readByteLenPrefixedStr())

    val tcpPort = body.readUnsignedShort()
    if (protoVer > 0)
      cp.setTcpPort2019(tcpPort)
    else
      cp.setTcpPort(tcpPort)

    val udpPort = body.readUnsignedShort()
    if (protoVer > 0)
      cp.setUdpPort2019(udpPort)
    else
      cp.setUdpPort(udpPort)

    cp.setChannel(body.readByte())

    cp.setMediaType(body.readByte())

    cp.setCodeStream(body.readByte())

    cp.setStorageType(body.readByte())

    cp.setMode(body.readByte())

    cp.setFactor(body.readByte())

    cp.setStartTime(body.readBcd6Timestamp(tempBuf))
    cp.setEndTime(body.readBcd6Timestamp(tempBuf))

    m.setParams(cp)
  }
}
