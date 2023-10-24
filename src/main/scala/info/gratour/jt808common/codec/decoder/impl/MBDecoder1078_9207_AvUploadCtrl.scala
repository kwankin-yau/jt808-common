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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9207_AvUploadCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9207_AvUploadCtrl
import io.netty.buffer.ByteBuf

object MBDecoder1078_9207_AvUploadCtrl extends JT808MsgBodyDecoder[JT1078Msg_9207_AvUploadCtrl]{

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9207_AvUploadCtrl, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val cp = new CP_9207_AvUploadCtrl

    cp.setOrigSeqNo(body.readUnsignedShort())

    cp.setCtrl(body.readByte())

    m.setParams(cp)
  }

}
