package info.gratour.jt808common.codec.decoder

trait JT808MsgBodyDecoderRegistry {

  def get(msgId: Int): JT808MsgBodyDecoder[_]

}
