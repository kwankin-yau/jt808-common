package info.gratour.jt808common.codec.encoder

import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jtcommon.{JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

/**
 *
 * @param protoVer JT/T 808 protocol version, 0 for REV_2013, 1 for REV_2019, see also `PROTO_VER` serial constant defined in [[JTConsts]]
 * @param adasDialect ADAS dialect
 */
class JT808MsgEncoder(protoVer: Byte, adasDialect: AdasDialect) {

  import JT808MsgEncoder.LOGGER

  final val MsgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = DefaultJT808MsgBodyEncoderRegistry

  /**
   * Encode message to `out` buffer. The method call JT808FrameEncoder to do frame level encoding.
   *
   * @param seqNumAllocator message sequence number allocator
   * @param msg message to encode
   * @param tempBuf temporary buffer used for encoding
   * @param out output buffer
   *
   * @return fragment/packet count
   */
  def encode(seqNumAllocator: SeqNumAllocator, msg: JT808Msg, tempBuf: ByteBuf, out: ByteBuf): Int = {
    val msgId = msg.getMsgId
    val encoder = MsgBodyEncoderRegistry.get(msgId)
    if (encoder == null) {
      LOGGER.warn("No message body encoder registered for : `{}`.", JTUtils.msgIdToHex(msgId))
      return 0
    }

    JT808FrameEncoder.encode(protoVer, adasDialect, seqNumAllocator, msg, encoder, tempBuf, out)
  }
}

object JT808MsgEncoder {
  final val LOGGER: Logger = Logger[JT808MsgEncoder]
}
