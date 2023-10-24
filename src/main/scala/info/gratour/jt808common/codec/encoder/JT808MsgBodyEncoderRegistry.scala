package info.gratour.jt808common.codec.encoder

trait JT808MsgBodyEncoderRegistry {

  def get(msgId: Int): JT808MsgBodyEncoder

  protected def mapOf(encoders: Seq[JT808MsgBodyEncoder]): Map[Int, JT808MsgBodyEncoder] =
    encoders.map(e => e.msgId -> e).toMap
}

object DefaultJT808MsgBodyEncoderRegistry extends JT808MsgBodyEncoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyEncoder] = JT808MsgBodyEncoders.ALL.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyEncoder = Map.get(msgId).orNull
}
