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
import info.gratour.jt808common.protocol.msg.JT808Msg_0108_UpgradeResult
import io.netty.buffer.ByteBuf

object MBDecoder808_0108_UpgradeResult extends JT808MsgBodyDecoder[JT808Msg_0108_UpgradeResult]{
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0108_UpgradeResult, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setUpgradeType(body.readByte())
    m.setResult(body.readByte())
  }
}
