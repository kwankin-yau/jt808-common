/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8302_Inquest
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8302_Inquest extends AbstractJT808MsgBodyEncoder[JT808Msg_8302_Inquest] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8302_Inquest, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val list = checkNotEmpty(params.getCandidates, "candidates")
    val question = checkNotNull(params.getQuestion, "question")

    out.writeByte(params.getFlags)
    out.writeByteLenPrefixedStr(question)
    list.foreach(candidate => {
      out.writeByte(candidate.getCandidateId)

      out.writeShortLenPrefixedStr(checkNotNull(candidate.getCandidate, "candidate"))
    })
  }
}
