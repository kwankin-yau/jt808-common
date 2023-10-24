/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9102_LiveAvCtrl
import io.netty.buffer.ByteBuf

object MBEncoder1078_9102_LiveAvCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9102_LiveAvCtrl] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9102_LiveAvCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")
    val closeAction = p.getCloseAction
    val codeStream = p.getCodeStrm
//    p.getCtrl match {
//      case 0 =>
//        if (closeAction == null)
//          close
//      case 1 =>
//        if (codeStream == null)
//          throw new CodecError("codeStream == null")
//      case _ =>
//    }

    out.writeByte(p.getChan)
    out.writeByte(p.getCtrl)
    out.writeByte(if (closeAction != null) closeAction.byteValue() else 0)
    out.writeByte(if (codeStream != null) codeStream.byteValue() else 1)
  }
}
