package info.gratour.jt808common.codec.encoder

trait JT808MsgBodyEncoderRegistry {

  def get(msgId: Int): JT808MsgBodyEncoder
}
