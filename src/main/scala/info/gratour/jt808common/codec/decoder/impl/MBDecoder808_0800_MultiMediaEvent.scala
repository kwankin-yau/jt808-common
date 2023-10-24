/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0800_MultiMediaEvent
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent
import io.netty.buffer.ByteBuf

object MBDecoder808_0800_MultiMediaEvent extends JT808MsgBodyDecoder[JT808Msg_0800_MultiMediaEvent]{
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0800_MultiMediaEvent, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val event = new MQEventAddt_0800_MultiMediaEvent
    event.setMediaId(body.readUnsignedInt())
    event.setTyp(body.readByte())
    event.setFmt(body.readByte())
    event.setEvtCode(body.readByte())
    event.setChan(body.readByte())

    m.setEvent(event)
  }
}
