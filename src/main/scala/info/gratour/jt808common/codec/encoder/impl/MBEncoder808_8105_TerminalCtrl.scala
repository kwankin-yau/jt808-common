/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8105_TerminalCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl.{Cmd1_WirelessUpgrade, Cmd2_ConnSpecialServer}
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8105_TerminalCtrl extends AbstractJT808MsgBodyEncoder[JT808Msg_8105_TerminalCtrl] {
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8105_TerminalCtrl, out: ByteBuf): Unit = {
    val params = m.getParams
    if (params == null)
      throw new CodecError("params == null")

    def cmdParams: CP_8105_TerminalCtrl.CP_8105_Params = {
      val r = params.getParams
      if (r == null)
        throw new CodecError("params.params == null")

      r
    }

    out.writeByte(params.getCmd)
    val s = params.getCmd match {
      case 1 =>
        val p = cmdParams.asInstanceOf[Cmd1_WirelessUpgrade]
        p.toCmdParams

      case 2 =>
        val p = cmdParams.asInstanceOf[Cmd2_ConnSpecialServer]
        p.toCmdParams

      case x if 3 to 7 contains x =>
        return

      case _ =>
        throw new CodecError(s"Unsupported command word: `${params.getCmd}`.")
    }
    out.writeStr(s)
  }
}
