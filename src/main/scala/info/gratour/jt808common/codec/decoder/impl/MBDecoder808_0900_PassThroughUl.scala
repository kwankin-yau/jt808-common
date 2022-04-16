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
import info.gratour.jt808common.protocol.msg.JT808Msg_0900_PassThroughUL
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0900_PassThroughUl
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder808_0900_PassThroughUl extends JT808MsgBodyDecoder[JT808Msg_0900_PassThroughUL] {

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0900_PassThroughUL, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val data = new MQEventAddt_0900_PassThroughUl
    data.setTyp(body.readByte())
    data.setData(body.readRemainingAsBytes())
    m.setData(data)
  }

}
