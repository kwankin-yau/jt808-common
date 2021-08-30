/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9102_LiveAVCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9102_LiveAVCtrl
import io.netty.buffer.ByteBuf

object MBDecoder1078_9102_LiveAVCtrl extends JT808MsgBodyDecoder[JT1078Msg_9102_LiveAVCtrl]{

  override def decodeMsgBody(m: JT1078Msg_9102_LiveAVCtrl, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val cp = new CP_9102_LiveAVCtrl
    cp.setChannel(body.readByte())
    cp.setCtrl(body.readByte())
    cp.setCloseAction(body.readByte())
    cp.setCodeStream(body.readByte())

    m.setParams(cp)
  }

}
