package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0107_QryAttrsAck
import info.gratour.jt808common.{AdasDialect, JT808Consts}
import io.netty.buffer.ByteBuf

object MBEncoder808_0107_QryAttrsAck extends AbstractJT808MsgBodyEncoder[JT808Msg_0107_QryAttrsAck] {
  override protected def encodeBody(
                                     protoVer: Byte,
                                     adasDialect: AdasDialect,
                                     m: JT808Msg_0107_QryAttrsAck,
                                     out: ByteBuf
                                   ): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val attrs = checkNotNull(m.getAttrs, "attrs")

    out.writeShort(attrs.getTerminalType)
    out.writeFixedLenStr(attrs.getFactoryId, 5)
    out.writeFixedLenStr(attrs.getModel,
      if (protoVer > JT808Consts.ProtocolVersions.PROTO_VER__REV2013) 30 else 20)
    out.writeFixedLenStr(attrs.getTerminalId,
      if (protoVer > JT808Consts.ProtocolVersions.PROTO_VER__REV2013) 30 else 7)
    out.writeBcdRightPad(attrs.getIccid, 10, '0')
    out.writeByteLenPrefixedStr(attrs.getHardwareVer)
    out.writeByteLenPrefixedStr(attrs.getFirmwareVer)
    out.writeByte(attrs.getGnssModuleAttrs)
    out.writeByte(attrs.getCommModuleAttrs)
  }
}
