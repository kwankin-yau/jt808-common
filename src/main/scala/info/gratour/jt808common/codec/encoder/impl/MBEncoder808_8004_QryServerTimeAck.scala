/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect

import java.time.OffsetDateTime
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8004_QryServerTimeAck
import info.gratour.jtcommon.{JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

object MBEncoder808_8004_QryServerTimeAck extends AbstractJT808MsgBodyEncoder[JT808Msg_8004_QryServerTimeAck]{

  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8004_QryServerTimeAck, out: ByteBuf): Unit = {
    val ldt = OffsetDateTime.now(JTConsts.ZONE_ID_Z).toLocalDateTime
    val bytes = JTUtils.encodeBcdDateTime(ldt)
    out.writeBytes(bytes)
  }

}
