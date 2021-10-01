/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1205_QryAVResAck
import io.netty.buffer.ByteBuf

object MBEncoder1078_1205_QryAVResAck extends AbstractJT808MsgBodyEncoder[JT1078Msg_1205_QryAVResAck]{

  override protected def encodeBody(m: JT1078Msg_1205_QryAVResAck, out: ByteBuf): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    out.writeShort(m.getAckSeqNo)

    val ap = m.getAckParams
    val list = ap.getResList

    out.writeInt(if (list == null) 0 else list.length)

    if (list != null) {
      list.foreach(av => {
        out.writeByte(av.getChan)
        out.writeBcd6Timestamp(av.getStartTm)
        out.writeBcd6Timestamp(av.getEndTm)
        out.writeInt(av.getAlmSt1078)
        out.writeInt(av.getAlmSt808)
        out.writeByte(av.getMediaTyp)
        out.writeByte(av.getCodeStrm)
        out.writeByte(av.getStgTyp)
        out.writeInt(av.getFileSz.toInt)
      })
    }
  }

}
