package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jtcommon.{JTCodecHelper, JTUtils}
import io.netty.buffer.ByteBuf

import scala.reflect.ClassTag

trait JT808MsgBodyEncoder extends JTCodecHelper {
  def msgId: Int

  def encBody(protoVer: Byte, m: JT808Msg, out: ByteBuf): Unit
}

abstract class AbstractJT808MsgBodyEncoder[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JT808MsgBodyEncoder {

  def msgId: Int = JTUtils.jtMsgIdOf(classTag.runtimeClass.asSubclass(classOf[JT808Msg]))

  protected def encodeBody(m: T, out: ByteBuf): Unit

  override def encBody(protoVer: Byte, m: JT808Msg, out: ByteBuf): Unit = encodeBody(m.asInstanceOf[T], out)


  //  protected def intArrayToBits(arr: Array[Int]): Int = {
  //    var r = 0
  //    if (arr != null)
  //      arr.foreach(bitIndex => {
  //        r = BitUtils.set(r, bitIndex)
  //      })
  //
  //    r
  //  }
}

abstract class AbstractJT808MsgBodyEncoder2019Support[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JT808MsgBodyEncoder {

  def msgId: Int = JTUtils.jtMsgIdOf(classTag.runtimeClass.asSubclass(classOf[JT808Msg]))

  protected def encodeBody(protoVer: Byte, m: T, out: ByteBuf): Unit

  override def encBody(protoVer: Byte, m: JT808Msg, out: ByteBuf): Unit = encodeBody(protoVer, m.asInstanceOf[T], out)


  //  protected def intArrayToBits(arr: Array[Int]): Int = {
  //    var r = 0
  //    if (arr != null)
  //      arr.foreach(bitIndex => {
  //        r = BitUtils.set(r, bitIndex)
  //      })
  //
  //    r
  //  }
}


case class JT808MsgBodyEncoderEmpty(msgId: Int) extends JT808MsgBodyEncoder {
  override def encBody(protoVer: Byte, m: JT808Msg, out: ByteBuf): Unit = {
    // nop
  }
}
