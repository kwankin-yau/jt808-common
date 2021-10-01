package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.JT808ProtocolVariant
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}

trait JT808MsgDecoder {

  def msgBodyDecoderRegistry: JT808MsgBodyDecoderRegistry
  def allocDecodeTempBuf: Array[Byte] = JT808FrameDecoder.allocTempBuf()

  /**
   *
   * @param frame
   * @return null if decode failed
   */
  def decode(frame: JT808Frame, tempBuf: Array[Byte]): JT808Msg = {
    val bodyDecoder = msgBodyDecoderRegistry.get(frame.getHeader.getMsgId)
    if (bodyDecoder != null)
      bodyDecoder.decodeMsgBody(frame.getHeader, frame.getBody, tempBuf).asInstanceOf[JT808Msg]
    else
      new JT808Msg(frame.getHeader)
  }
}

object JT808MsgDecoder_Rev2013 extends JT808MsgDecoder {
  override def msgBodyDecoderRegistry: JT808MsgBodyDecoderRegistry = JT808MsgBodyDecoderRegistry_Rev2013
}

object JT808MsgDecoder_Rev2019 extends JT808MsgDecoder {
  override def msgBodyDecoderRegistry: JT808MsgBodyDecoderRegistry = JT808MsgBodyDecoderRegistry_Rev2019
}

object JT808MsgDecoder_SiChuan extends JT808MsgDecoder {
  override def msgBodyDecoderRegistry: JT808MsgBodyDecoderRegistry = JT808MsgBodyDecoderRegistry_Adas
}

object JT808MsgDecoder_GDRTA2020 extends JT808MsgDecoder {
  override def msgBodyDecoderRegistry: JT808MsgBodyDecoderRegistry = JT808MsgBodyDecoderRegistry_GDRTA2020
}

object JT808MsgDecoder {
  def apply(protocolVariant: JT808ProtocolVariant): JT808MsgDecoder = protocolVariant match {
    case JT808ProtocolVariant.REV_2013 => JT808MsgDecoder_Rev2013
    case JT808ProtocolVariant.SI_CHUAN => JT808MsgDecoder_SiChuan
    case JT808ProtocolVariant.REV_2019 => JT808MsgDecoder_Rev2019
    case JT808ProtocolVariant.GDRTA_2020 => JT808MsgDecoder_GDRTA2020
  }
}
