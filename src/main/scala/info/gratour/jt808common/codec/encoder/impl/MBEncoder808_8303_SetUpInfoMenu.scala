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
import info.gratour.jt808common.protocol.msg.JT808Msg_8303_SetUpInfoMenu
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

object MBEncoder808_8303_SetUpInfoMenu extends AbstractJT808MsgBodyEncoder[JT808Msg_8303_SetUpInfoMenu] {
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8303_SetUpInfoMenu, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val list = checkNotEmpty(params.getMenuItems, "menuItems")

    out.writeByte(params.getAction)
    out.writeByte(list.length)
    list.foreach(item => {
      out.writeByte(item.getInfoType)
      out.writeShortLenPrefixedStr(item.getInfoName)
    })
  }
}
