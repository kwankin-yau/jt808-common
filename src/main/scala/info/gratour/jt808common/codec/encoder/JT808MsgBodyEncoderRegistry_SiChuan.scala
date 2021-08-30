package info.gratour.jt808common.codec.encoder

object JT808MsgBodyEncoderRegistry_SiChuan extends JT808MsgBodyEncoderRegistry {

  override def get(msgId: Int): JT808MsgBodyEncoder =
    JT808MsgBodyEncoderRegistry_Rev2013.get(msgId)

}
