package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.protocol.JT808Msg

trait JT808MsgBodyDecoderRegistry {

  def get(msgId: Int): JT808MsgBodyDecoder[_]

  protected def mapOf(decoders: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]]): Map[Int, JT808MsgBodyDecoder[_]] =
    decoders.map(d => d.msgId -> d).toMap
}

object DefaultMsgBodyDecoderRegistry extends JT808MsgBodyDecoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoders.ALL.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyDecoder[_] = Map.get(msgId).orNull
}

object SimplifiedMsgBodyDecoderRegistry extends JT808MsgBodyDecoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoders.ALL_SIMPLIFIED.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyDecoder[_] = Map.get(msgId).orNull
}
