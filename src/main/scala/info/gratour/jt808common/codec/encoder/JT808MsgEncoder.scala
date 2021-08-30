package info.gratour.jt808common.codec.encoder

import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.JT808ProtocolVariant
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jtcommon.{JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

trait JT808MsgEncoder {

  import JT808MsgEncoder.logger

  def msgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry

  /**
   * Encode message to `out` buffer. The method call JT808FrameEncoder to do frame level encoding.
   *
   * @param protoVer protocol version, 0 for REV_2013, 1 for REV_2019, see also `PROTO_VER` serial constant defined in [[JTConsts]]
   * @param seqNumAllocator message sequence number allocator
   * @param msg message to encode
   * @param tempBuf temporary buffer used for encoding
   * @param out output buffer
   *
   * @return fragment/packet count
   */
  def encode(protoVer: Byte, seqNumAllocator: SeqNumAllocator, msg: JT808Msg, tempBuf: ByteBuf, out: ByteBuf): Int = {
    val msgId = msg.getMsgId
    val encoder = msgBodyEncoderRegistry.get(msgId)
    if (encoder == null) {
      logger.warn("No message body encoder registered for : `{}`.", JTUtils.msgIdToHex(msgId))
      return 0
    }

    JT808FrameEncoder.encode(protoVer, seqNumAllocator, msg, encoder, tempBuf, out)
  }
}

object JT808MsgEncoder {
  val logger: Logger = Logger[JT808MsgEncoder]

  def apply(protocolVariant: JT808ProtocolVariant): JT808MsgEncoder = protocolVariant match {
    case JT808ProtocolVariant.REV_2013 => JT808MsgEncoder_Rev2013
    case JT808ProtocolVariant.REV_2019 => JT808MsgEncoder_Rev2019
    case JT808ProtocolVariant.SI_CHUAN => JT808MsgEncoder_SiChuan
    case JT808ProtocolVariant.GDRTA_2020 => JT808MsgEncoder_GDRTA2020
  }
}

object JT808MsgEncoder_Rev2013 extends JT808MsgEncoder {
  override def msgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = JT808MsgBodyEncoderRegistry_Rev2013
}

object JT808MsgEncoder_Rev2019 extends JT808MsgEncoder {
  override def msgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = JT808MsgBodyEncoderRegistry_Rev2019
}

object JT808MsgEncoder_SiChuan extends JT808MsgEncoder {
  override def msgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = JT808MsgBodyEncoderRegistry_SiChuan
}

object JT808MsgEncoder_GDRTA2020 extends JT808MsgEncoder {
  override def msgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = JT808MsgBodyEncoderRegistry_SiChuan
}
