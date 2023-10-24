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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9201_ReplayAvReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9201_ReplayAvReq
import io.netty.buffer.ByteBuf

object MBDecoder1078_9201_ReplayAvReq extends JT808MsgBodyDecoder[JT1078Msg_9201_ReplayAvReq] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9201_ReplayAvReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9201_ReplayAvReq

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

    cp.setChan(body.readByte())

    cp.setMediaTyp(body.readByte())

    cp.setCodeStrm(body.readByte())

    cp.setStgTyp(body.readByte())

    cp.setMode(body.readByte())

    cp.setFactor(body.readByte())

    cp.setStartTm(body.readBcd6Timestamp(tempBuf))
    cp.setEndTm(body.readBcd6Timestamp(tempBuf))

    m.setParams(cp)
  }
}
