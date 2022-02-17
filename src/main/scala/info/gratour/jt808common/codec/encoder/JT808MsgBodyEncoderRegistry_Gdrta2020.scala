package info.gratour.jt808common.codec.encoder

object JT808MsgBodyEncoderRegistry_Gdrta2020 extends JT808MsgBodyEncoderRegistry {

  private[encoder] val map: Map[Int, JT808MsgBodyEncoder] = JT808MsgBodyEncoderRegistry_Rev2019.map

  override def get(msgId: Int): JT808MsgBodyEncoder = map.get(msgId).orNull

}
