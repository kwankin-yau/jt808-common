/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JTSiChuanMsg_9212_AlmAttFileItemCompleted
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoderSiChuan_9212_AlarmAttFileItemCompleted extends AbstractJT808MsgBodyEncoder[JTSiChuanMsg_9212_AlmAttFileItemCompleted]{

  override protected def encodeBody(m: JTSiChuanMsg_9212_AlmAttFileItemCompleted, out: ByteBuf): Unit = {
    val params = m.getParams
    out.writeByteLenPrefixedStr(params.getFileItem.getFileName)

    out.writeByte(params.getFileItem.getFileType)

    if (params.getReTransFileBlocks == null || params.getReTransFileBlocks.isEmpty)
      out.writeByte(0)
    else {
      out.writeByte(1)
      for (i <- 0 until params.getReTransFileBlocks.size()) {
        val b = params.getReTransFileBlocks.get(i)
        out.writeInt(b.getOffset)
        out.writeInt(b.getSize)
      }
    }

  }
}
