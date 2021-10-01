package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.protocol.JT808Msg

trait JT808MsgBodyDecoderRegistry {

  def get(msgId: Int): JT808MsgBodyDecoder[_]

  protected def mapOf(decoders: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]]): Map[Int, JT808MsgBodyDecoder[_]] =
    decoders.map(d => d.msgId -> d).toMap
}
