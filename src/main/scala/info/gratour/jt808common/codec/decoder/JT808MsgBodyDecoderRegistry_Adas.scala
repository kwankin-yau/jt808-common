package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.codec.decoder.impl.{MBDecoderAdas_9208_AlmAttUploadReq, MBDecoderAdas_9212_AlmAttFileItemCompleted}

object JT808MsgBodyDecoderRegistry_Adas extends JT808MsgBodyDecoderRegistry {

  private[decoder] val AdasDecoderMap: Map[Int, JT808MsgBodyDecoder[_]] = mapOf(
    Seq(
      MBDecoderAdas_9208_AlmAttUploadReq,
      MBDecoderAdas_9212_AlmAttFileItemCompleted
    )
  )

  private[decoder] val map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoderRegistry_Rev2013.map ++ AdasDecoderMap

  override def get(msgId: Int): JT808MsgBodyDecoder[_] = map.get(msgId).orNull
}
