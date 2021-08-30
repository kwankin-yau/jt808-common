/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9102_LiveAVCtrl
import io.netty.buffer.ByteBuf

object MBEncoder1078_9102_LiveAVCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9102_LiveAVCtrl] {
  override protected def encodeBody(m: JT1078Msg_9102_LiveAVCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")
    val closeAction = p.getCloseAction
    val codeStream = p.getCodeStream
//    p.getCtrl match {
//      case 0 =>
//        if (closeAction == null)
//          close
//      case 1 =>
//        if (codeStream == null)
//          throw new CodecError("codeStream == null")
//      case _ =>
//    }

    out.writeByte(p.getChannel)
    out.writeByte(p.getCtrl)
    out.writeByte(if (closeAction != null) closeAction.byteValue() else 0)
    out.writeByte(if (codeStream != null) codeStream.byteValue() else 1)
  }
}
