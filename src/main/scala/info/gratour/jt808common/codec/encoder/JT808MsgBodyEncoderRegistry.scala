package info.gratour.jt808common.codec.encoder

trait JT808MsgBodyEncoderRegistry {

  def get(msgId: Int): JT808MsgBodyEncoder

  protected def mapOf(encoders: Seq[JT808MsgBodyEncoder]): Map[Int, JT808MsgBodyEncoder] =
    encoders.map(e => e.msgId -> e).toMap
}
