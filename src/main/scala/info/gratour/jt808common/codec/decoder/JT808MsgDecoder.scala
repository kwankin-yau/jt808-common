package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}

class JT808MsgDecoder(adasDialect: AdasDialect, simplified: Boolean) {

  private val registry: JT808MsgBodyDecoderRegistry =
    if (simplified)
      SimplifiedMsgBodyDecoderRegistry
    else
      DefaultMsgBodyDecoderRegistry

  /**
   *
   * @param frame   frame to decode
   * @param tempBuf temp buffer used for decoding, should allocated by [[JT808MsgDecoder.allocDecodeTempBuf]]
   * @return null if decode failed
   */
  def decode(frame: JT808Frame, tempBuf: Array[Byte]): JT808Msg = {
    val bodyDecoder = registry.get(frame.getHeader.getMsgId)
    if (bodyDecoder != null)
      bodyDecoder.decodeMsgBody(adasDialect, frame.getHeader, frame.getBody, tempBuf).asInstanceOf[JT808Msg]
    else
      new JT808Msg(frame.getHeader)
  }
}

object JT808MsgDecoder {
  def allocDecodeTempBuf: Array[Byte] = JT808FrameDecoder.allocTempBuf()
}
