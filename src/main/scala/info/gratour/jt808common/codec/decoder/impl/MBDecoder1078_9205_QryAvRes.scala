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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9205_QryAvRes
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9205_QryAvRes
import io.netty.buffer.ByteBuf

object MBDecoder1078_9205_QryAvRes extends JT808MsgBodyDecoder[JT1078Msg_9205_QryAvRes] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9205_QryAvRes, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9205_QryAvRes

    cp.setChan(body.readByte())

    cp.setStartTm(body.readBcd6Timestamp(tempBuf))

    cp.setEndTm(body.readBcd6Timestamp(tempBuf))

    cp.setAlarmState(body.readLong())

    cp.setMediaTyp(body.readByte())

    cp.setCodeStrm(body.readByte())

    cp.setStgTyp(body.readByte())

    m.setParams(cp)
  }

}
