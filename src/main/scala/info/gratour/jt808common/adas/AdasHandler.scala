package info.gratour.jt808common.adas

import info.gratour.jt808common.protocol.msg.types.trk.{AdasDriverBehavAlmAddt, AdasDrivingAssistAlmAddt}
import info.gratour.jt808common.{AdasDialect, JT808Consts}
import info.gratour.jtcommon.JTUtils
import io.netty.buffer.ByteBuf

trait AdasHandler {

  def dialect: AdasDialect


  def mapDrivingAssistAlmTyp(typ: Short): Short

  def mapDriverBehavAlmTyp(typ: Short): Short

  def adasAlmIdLen(protoVer: Byte): Int

  def readAdasAlmIdAsHex(
                          protoVer: Byte,
                          buf     : ByteBuf,
                          tempBuf : Array[Byte]
                        ): String = {
    val sz = adasAlmIdLen(protoVer)
    buf.readBytes(tempBuf, 0, sz)
    JTUtils.hex(tempBuf, 0, sz)
  }
}

object AdasHandler_SiChuan extends AdasHandler {
  override def dialect: AdasDialect = AdasDialect.SI_CHUAN

  override def mapDrivingAssistAlmTyp(typ: Short): Short = {
    if (typ >= 0x09 && typ <= 0x0F || typ >= 0x12)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ
  }


  override def adasAlmIdLen(protoVer: Byte): Int =
    if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019)
      39
    else
      16

  override def mapDriverBehavAlmTyp(typ: Short): Short = {
    if (typ >= 0x09 && typ <= 0x0D || typ >= 0x13)
      AdasDriverBehavAlmAddt.TYP__CUSTOM
    else
      typ
  }
}

object AdasHandler_Gdrta_2020 extends AdasHandler {
  override def dialect: AdasDialect = AdasDialect.GDRTA_2020

  override def mapDrivingAssistAlmTyp(typ: Short): Short = {
    if (typ >= 0x08 && typ <= 0x0F || typ >= 0x14)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ
  }

  override def adasAlmIdLen(protoVer: Byte): Int = 40

  override def mapDriverBehavAlmTyp(typ: Short): Short =
    if (typ == 0x07 || typ == 0x09 || (typ >= 0x0E && typ <= 0x0F) || typ >= 0x12)
      AdasDriverBehavAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x06 => AdasDriverBehavAlmAddt.TYP__CAMERA_COVERED
        case 0x08 => AdasDriverBehavAlmAddt.TYP__DRIVE_OVERTIME
        case 0x0A => AdasDriverBehavAlmAddt.TYP__NOT_BELTING
        case 0x0B => AdasDriverBehavAlmAddt.TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE
        case 0x0C => AdasDriverBehavAlmAddt.TYP__STEERING_WHEEL_NOT_HOLDING
        case 0x0D => AdasDriverBehavAlmAddt.TYP__PLAY_SMART_PHONE
        case 0x11 => AdasDriverBehavAlmAddt.TYP__AUTO_CAPTURE
        case 0x12 => AdasDriverBehavAlmAddt.TYP__DRIVER_CHANGED_EVENT

        case _ =>
          typ
      }

}


object AdasHandler_JiangSu extends AdasHandler {
  override def dialect: AdasDialect = AdasDialect.JIANG_SU

  override def mapDrivingAssistAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDrivingAssistAlmTyp(typ)

  override def adasAlmIdLen(protoVer: Byte): Int = 16

  override def mapDriverBehavAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDriverBehavAlmTyp(typ)
}

object AdasHandler_HuNan extends AdasHandler {
  override def dialect: AdasDialect = AdasDialect.HU_NAN

  override def mapDrivingAssistAlmTyp(typ: Short): Short =
    if (typ >= 0x05 && typ <= 0x0F || typ >= 0x13)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x12 => AdasDrivingAssistAlmAddt.TYP__DEVICE_FAILURE
        case _ => typ
      }

  override def mapDriverBehavAlmTyp(typ: Short): Short =
    if (typ >= 0x0B && typ <= 0x0F || typ >= 0x15 && typ <= 0x1F)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x09 => AdasDriverBehavAlmAddt.TYP__PLAY_SMART_PHONE
        case 0x12 => AdasDriverBehavAlmAddt.TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE
        case 0x13 => AdasDriverBehavAlmAddt.TYP__CAMERA_COVERED
        case 0x14 => AdasDriverBehavAlmAddt.TYP__IGNITED_CAPTURE
        case _ => typ
      }

  override def adasAlmIdLen(protoVer: Byte): Int = 16
}

object AdasHandler_ChongQing extends AdasHandler {
  override def dialect: AdasDialect = AdasDialect.CHONG_QING

  override def mapDrivingAssistAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDrivingAssistAlmTyp(typ)

  override def mapDriverBehavAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDriverBehavAlmTyp(typ)

  override def adasAlmIdLen(protoVer: Byte): Int = 16
}

object AdasHandlers {
  def get(adasDialect: AdasDialect): AdasHandler = {
    if (adasDialect == null)
      throw new IllegalArgumentException("adasDialect")

    adasDialect match {
      case AdasDialect.SI_CHUAN => AdasHandler_SiChuan
      case AdasDialect.GDRTA_2020 => AdasHandler_Gdrta_2020
      case AdasDialect.HU_NAN => AdasHandler_HuNan
      case AdasDialect.JIANG_SU => AdasHandler_JiangSu
      case AdasDialect.CHONG_QING => AdasHandler_ChongQing

      case _ =>
        throw new RuntimeException(s"Unhandled ADAS dialect: $adasDialect")
    }
  }
}
