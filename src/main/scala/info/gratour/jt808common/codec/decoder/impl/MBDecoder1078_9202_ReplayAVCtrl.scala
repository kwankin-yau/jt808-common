/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder2019Support
import info.gratour.jt808common.protocol.msg.JT1078Msg_9202_ReplayAVCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9202_ReplayAVCtrl
import io.netty.buffer.ByteBuf

object MBDecoder1078_9202_ReplayAVCtrl extends JT808MsgBodyDecoder2019Support[JT1078Msg_9202_ReplayAVCtrl] {

  override def decodeMsgBodyNew(protoVer: Byte, m: JT1078Msg_9202_ReplayAVCtrl, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9202_ReplayAVCtrl
    cp.setChannel(body.readByte())

    cp.setCtrl(body.readByte())

    cp.setFactor(body.readByte())

    if (cp.getCtrl == 5)
      cp.setTime(body.readBcd6Timestamp(tempBuf))
    else
      body.skipBytes(6)

    m.setParams(cp)
  }

}
