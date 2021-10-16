package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.codec.decoder.impl.{MBDecoder808_0004_QryServerTime, MBDecoder808_8004_QryServerTimeAck}

object JT808MsgBodyDecoderRegistry_Rev2019 extends JT808MsgBodyDecoderRegistry {

  private[decoder] val map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoderRegistry_Rev2013.map ++ (
    Seq(
      MBDecoder808_0004_QryServerTime,
      MBDecoder808_8004_QryServerTimeAck
    ).map(d => (d.msgId -> d)).toMap
  )


  override def get(msgId: Int): JT808MsgBodyDecoder[_] = map.get(msgId).orNull
}
