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
import info.gratour.jt808common.protocol.msg.JT808Msg_8004_QryServerTimeAck
import io.netty.buffer.ByteBuf

object MBDecoder808_8004_QryServerTimeAck extends JT808MsgBodyDecoder[JT808Msg_8004_QryServerTimeAck] {
  import info.gratour.jtcommon.ByteBufHelper
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8004_QryServerTimeAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    body.writeBcd6Timestamp(m.getServerTime)
  }
}
