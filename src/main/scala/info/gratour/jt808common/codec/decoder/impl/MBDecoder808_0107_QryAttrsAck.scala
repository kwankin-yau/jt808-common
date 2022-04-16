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
import info.gratour.jt808common.protocol.msg.JT808Msg_0107_QryAttrsAck
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0107_QryAttrsAck
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBDecoder808_0107_QryAttrsAck extends JT808MsgBodyDecoder[JT808Msg_0107_QryAttrsAck]{

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0107_QryAttrsAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val attrs = new JT808AckParams_0107_QryAttrsAck
    attrs.setTerminalType(body.readShort())
    attrs.setFactoryId(body.readStr(5))
    attrs.setModel(body.readStr(20))
    attrs.setTerminalId(body.readStr(7))
    attrs.setIccid(body.readBcd(10))
    attrs.setHardwareVer(body.readByteLenPrefixedStr())
    attrs.setFirmwareVer(body.readByteLenPrefixedStr())
    attrs.setGnssModuleAttrs(body.readByte())
    attrs.setCommModuleAttrs(body.readByte())

    m.setAttrs(attrs)
  }

}
