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
import info.gratour.jt808common.protocol.msg.JTAdasMsg_9212_AlmAttFileItemCompleted
import info.gratour.jt808common.protocol.msg.types.almatt.{AlmAttFileItemWithType, AlmAttReTransFileBlock}
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9212_AlmAttFileItemCompleted
import io.netty.buffer.ByteBuf

import java.util

object MBDecoderAdas_9212_AlmAttFileItemCompleted extends JT808MsgBodyDecoder[JTAdasMsg_9212_AlmAttFileItemCompleted] {
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_9212_AlmAttFileItemCompleted, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val fileItem = new AlmAttFileItemWithType
    fileItem.setFileName(body.readByteLenPrefixedStr())
    fileItem.setFileType(body.readByte())


    val cp = new CP_9212_AlmAttFileItemCompleted
    cp.setFileItem(fileItem)

    body.skipBytes(1) // file type
    val cnt = body.readUnsignedByte()
    if (cnt > 0) {
      val blocks = new util.ArrayList[AlmAttReTransFileBlock]()

      for (_ <- 0 until cnt) {
        val block = new AlmAttReTransFileBlock
        block.setOffset(body.readInt())
        block.setSize(body.readInt())

        blocks.add(block)
      }

      cp.setReTransFileBlocks(blocks)
    }

    m.setParams(cp)
  }

}
