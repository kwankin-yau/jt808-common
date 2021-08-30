/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8700_VTDRDataCollectReq
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VTDR_CmdArgs
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBEncoder808_8700_VTDRDataCollectReq extends AbstractJT808MsgBodyEncoder[JT808Msg_8700_VTDRDataCollectReq] {
  override protected def encodeBody(m: JT808Msg_8700_VTDRDataCollectReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getCmd)
    val data = p.getDataBlock
    if (data != null) {
      data match {
        case cmdArgs: JT808VTDR_CmdArgs =>
          out.writeBytes(Hex.decodeHex(cmdArgs.getStartTime))
          out.writeBytes(Hex.decodeHex(cmdArgs.getEndTime))
          out.writeShort(cmdArgs.getBlockCnt)

        case _ =>
          throw new RuntimeException("Unrecognized VTDR command data block type.")
      }
    }
  }
}
