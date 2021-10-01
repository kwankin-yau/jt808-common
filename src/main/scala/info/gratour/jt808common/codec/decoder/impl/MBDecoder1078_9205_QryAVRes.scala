/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9205_QryAVRes
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9205_QryAVRes
import io.netty.buffer.ByteBuf

object MBDecoder1078_9205_QryAVRes extends JT808MsgBodyDecoder[JT1078Msg_9205_QryAVRes] {

  override def decodeMsgBody(m: JT1078Msg_9205_QryAVRes, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9205_QryAVRes

    cp.setChannel(body.readByte())

    cp.setStartTime(body.readBcd6Timestamp(tempBuf))

    cp.setEndTime(body.readBcd6Timestamp(tempBuf))

    cp.setAlarmState(body.readLong())

    cp.setMediaType(body.readByte())

    cp.setCodeStream(body.readByte())

    cp.setStorageType(body.readByte())

    m.setParams(cp)
  }

}
