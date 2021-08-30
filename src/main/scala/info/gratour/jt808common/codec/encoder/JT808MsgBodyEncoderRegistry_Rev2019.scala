package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.codec.encoder.impl.MBEncoder808_8004_QryServerTimeAck

object JT808MsgBodyEncoderRegistry_Rev2019 extends JT808MsgBodyEncoderRegistry {
  private[encoder] val map: Map[Int, JT808MsgBodyEncoder] = JT808MsgBodyEncoderRegistry_Rev2013.map ++ (
    Seq(
      MBEncoder808_8004_QryServerTimeAck
    ).map(e => e.msgId -> e).toMap
  )
  override def get(msgId: Int): JT808MsgBodyEncoder = map.get(msgId).orNull

}
