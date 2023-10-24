/** *****************************************************************************
 * Copyright (c) 2019, 2022 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0100_TerminalRegister
import io.netty.buffer.ByteBuf


object MBEncoder808_0100_TerminalRegister extends AbstractJT808MsgBodyEncoder[JT808Msg_0100_TerminalRegister]{

  import info.gratour.jtcommon.ByteBufHelper

  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0100_TerminalRegister, out: ByteBuf): Unit = {
    val info = m.getInfo
    out.writeShort(info.getProvinceId)
    out.writeShort(info.getCityId)
    out.writeFixedLenStr(info.getFactoryId, if (protoVer == 0) 5 else 11)
    out.writeFixedLenStr(info.getTerminalModel, if (protoVer == 0) 20 else 30)
    out.writeFixedLenStr(info.getTerminalId, if (protoVer == 0) 7 else 30)
    out.writeByte(info.getPlateColor)
    out.writeStr(info.getPlateNo)
  }
}
