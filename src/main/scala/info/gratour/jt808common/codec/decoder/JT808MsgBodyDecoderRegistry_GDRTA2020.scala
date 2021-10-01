package info.gratour.jt808common.codec.decoder

object JT808MsgBodyDecoderRegistry_GDRTA2020 extends JT808MsgBodyDecoderRegistry {

  private[decoder] val map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoderRegistry_Rev2019.map ++
    JT808MsgBodyDecoderRegistry_Adas.AdasDecoderMap

  override def get(msgId: Int): JT808MsgBodyDecoder[_] = map.get(msgId).orNull
}
