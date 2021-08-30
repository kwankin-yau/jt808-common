package info.gratour.jt808common.codec.decoder

object JT808MsgBodyDecoderRegistry_SiChuan extends JT808MsgBodyDecoderRegistry {

  override def get(msgId: Int): JT808MsgBodyDecoder[_] = JT808MsgBodyDecoderRegistry_Rev2013.map.get(msgId).orNull
}
