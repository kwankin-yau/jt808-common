package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.protocol.{JT808FrameHeader, JT808Msg}
import info.gratour.jtcommon.{JTCodecHelper, JTUtils}
import io.netty.buffer.ByteBuf

import scala.reflect.ClassTag

abstract class JT808MsgBodyDecoder[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JTCodecHelper {

  def msgId: Int = JTUtils.jtMsgIdOf(classTag.runtimeClass.asSubclass(classOf[JT808Msg]))

  def decodeMsgBody(m: T, body: ByteBuf, tempBuf: Array[Byte]): Unit

  /**
   *
   * @param header
   * @param body
   * @return null if decode failed
   */
  def decodeMsgBody(header: JT808FrameHeader, body: ByteBuf, tempBuf: Array[Byte]): T = {
    val m = classTag.runtimeClass.getDeclaredConstructor().newInstance().asInstanceOf[T]
    m.setMsgId(header.getMsgId)
    m.setSeqNo(header.getSeqNo)
    m.setSimNo(header.getSimNo)

    decodeMsgBody(m, body, tempBuf)

    m
  }

}

abstract class JT808MsgBodyDecoder2019Support[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JT808MsgBodyDecoder[T] {

  @Deprecated
  override final def decodeMsgBody(m: T, body: ByteBuf, tempBuf: Array[Byte]): Unit = {}
  def decodeMsgBodyNew(protoVer: Byte, m: T, body: ByteBuf, tempBuf: Array[Byte]): Unit

  /**
   *
   * @param header
   * @param body
   * @return null if decode failed
   */
  override def decodeMsgBody(header: JT808FrameHeader, body: ByteBuf, tempBuf: Array[Byte]): T = {
    val m = classTag.runtimeClass.getDeclaredConstructor().newInstance().asInstanceOf[T]
    m.setMsgId(header.getMsgId)
    m.setSeqNo(header.getSeqNo)
    m.setSimNo(header.getSimNo)

    decodeMsgBodyNew(header.getProtoVer, m, body, tempBuf)

    m
  }

}
