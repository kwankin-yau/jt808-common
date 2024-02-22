package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.impl.{MBEncoder1078_1003_QryAvAttrsAck, MBEncoder1078_1205_QryAvResAck, MBEncoder1078_1206_AvUploadCompleted, MBEncoder1078_9101_LiveAvReq, MBEncoder1078_9102_LiveAvCtrl, MBEncoder1078_9105_LiveAvStatus, MBEncoder1078_9201_ReplayAv, MBEncoder1078_9202_ReplayAvCtrl, MBEncoder1078_9205_QryAvRes, MBEncoder1078_9206_AvUploadReq, MBEncoder1078_9207_AvUploadCtrl, MBEncoder1078_9301_PtzTurn, MBEncoder1078_9302_PtzFocusing, MBEncoder1078_9303_PtzIrisCtrl, MBEncoder1078_9304_PtzWiperCtrl, MBEncoder1078_9305_PtzFillLightCtrl, MBEncoder1078_9306_PtzZoomCtrl, MBEncoder808_0001_TerminalGeneralAck, MBEncoder808_0002_Heartbeat, MBEncoder808_0100_TerminalRegister, MBEncoder808_0102_TerminalAuth, MBEncoder808_0107_QryAttrsAck, MBEncoder808_0200_Location, MBEncoder808_0201_QryLocationAck, MBEncoder808_0800_MultiMediaEvent, MBEncoder808_0801_MultiMediaData, MBEncoder808_8001_PlatformGeneralAck, MBEncoder808_8003_Retransmit, MBEncoder808_8004_QryServerTimeAck, MBEncoder808_8100_TerminalRegisterAck, MBEncoder808_8103_SetParam, MBEncoder808_8105_TerminalCtrl, MBEncoder808_8106_QrySpecialParams, MBEncoder808_8108_UpgradePacket, MBEncoder808_8202_LocationTraceCtrl, MBEncoder808_8203_ManualConfirmAlarm, MBEncoder808_8300_SendText, MBEncoder808_8301_SetUpEvent, MBEncoder808_8302_Inquest, MBEncoder808_8303_SetUpInfoMenu, MBEncoder808_8304_InfoService, MBEncoder808_8400_PhoneCallback, MBEncoder808_8401_SetUpPhoneBook, MBEncoder808_8500_VehCtrl, MBEncoder808_8600_SetCircleRegion, MBEncoder808_8601_DelCircleRegion, MBEncoder808_8602_SetRectRegion, MBEncoder808_8603_DelRectRegion, MBEncoder808_8604_SetPolygonRegion, MBEncoder808_8605_DelPolygonRegion, MBEncoder808_8606_SetRoute, MBEncoder808_8607_DelRoute, MBEncoder808_8700_VtdrDataCollectReq, MBEncoder808_8701_VtdrSetParams, MBEncoder808_8800_MmDataAck, MBEncoder808_8801_TakePhoto, MBEncoder808_8802_StoredMediaSearch, MBEncoder808_8803_StoredMediaReq, MBEncoder808_8804_AudioRecordCtrl, MBEncoder808_8805_SingleStoredMediaReq, MBEncoder808_8900_PassThroughDl, MBEncoder808_8A00_PlatformRsaKey, MBEncoderAdas_1210_FileList, MBEncoderAdas_1211_FileItem, MBEncoderAdas_1212_FileItemCompleted, MBEncoderAdas_9208_AlmAttUploadReq, MBEncoderAdas_9212_AlmAttFileItemCompleted}
import info.gratour.jt808common.protocol.{JT1078MsgConsts, JT808Msg, JT808MsgConsts}
import info.gratour.jtcommon.{JTCodecHelper, JTUtils}
import io.netty.buffer.ByteBuf

import scala.reflect.ClassTag

trait JT808MsgBodyEncoder extends JTCodecHelper {
  def msgId: Int

  def encBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg, out: ByteBuf): Unit
}

abstract class AbstractJT808MsgBodyEncoder[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JT808MsgBodyEncoder {

  def msgId: Int = JTUtils.jtMsgIdOf(classTag.runtimeClass.asSubclass(classOf[JT808Msg]))

  protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: T, out: ByteBuf): Unit

  override def encBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg, out: ByteBuf): Unit =
    encodeBody(protoVer, adasDialect, m.asInstanceOf[T], out)

}



case class JT808MsgBodyEncoderEmpty(msgId: Int) extends JT808MsgBodyEncoder {
  override def encBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg, out: ByteBuf): Unit = {
    // nop
  }
}

object JT808MsgBodyEncoders {
  val REV_2013: Seq[JT808MsgBodyEncoder] = Seq(
    // 808 - terminal
    MBEncoder808_0001_TerminalGeneralAck,
    MBEncoder808_0002_Heartbeat,
    MBEncoder808_0100_TerminalRegister,
    MBEncoder808_0102_TerminalAuth,
    MBEncoder808_0107_QryAttrsAck,
    MBEncoder808_0200_Location,
    MBEncoder808_0201_QryLocationAck,
    MBEncoder808_0800_MultiMediaEvent,
    MBEncoder808_0801_MultiMediaData,

    // 808 - platform
    MBEncoder808_8001_PlatformGeneralAck,
    MBEncoder808_8003_Retransmit,
    MBEncoder808_8100_TerminalRegisterAck,
    MBEncoder808_8103_SetParam,
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.QRY_ALL_PARAMS_8104),
    MBEncoder808_8106_QrySpecialParams,
    MBEncoder808_8105_TerminalCtrl,
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.QRY_TERMINAL_ATTRS_8107),
    MBEncoder808_8108_UpgradePacket,
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.QRY_LOCATION_8201),
    MBEncoder808_8202_LocationTraceCtrl,
    MBEncoder808_8203_ManualConfirmAlarm,
    MBEncoder808_8300_SendText,
    MBEncoder808_8301_SetUpEvent,
    MBEncoder808_8302_Inquest,
    MBEncoder808_8303_SetUpInfoMenu,
    MBEncoder808_8304_InfoService,
    MBEncoder808_8400_PhoneCallback,
    MBEncoder808_8401_SetUpPhoneBook,
    MBEncoder808_8500_VehCtrl,
    MBEncoder808_8600_SetCircleRegion,
    MBEncoder808_8601_DelCircleRegion,
    MBEncoder808_8602_SetRectRegion,
    MBEncoder808_8603_DelRectRegion,
    MBEncoder808_8604_SetPolygonRegion,
    MBEncoder808_8605_DelPolygonRegion,
    MBEncoder808_8606_SetRoute,
    MBEncoder808_8607_DelRoute,
    MBEncoder808_8700_VtdrDataCollectReq,
    MBEncoder808_8701_VtdrSetParams,
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.DRIVER_IDENTITY_REQ_8702),
    MBEncoder808_8800_MmDataAck,
    MBEncoder808_8801_TakePhoto,
    MBEncoder808_8802_StoredMediaSearch,
    MBEncoder808_8803_StoredMediaReq,
    MBEncoder808_8804_AudioRecordCtrl,
    MBEncoder808_8805_SingleStoredMediaReq,
    MBEncoder808_8900_PassThroughDl,
    MBEncoder808_8A00_PlatformRsaKey,

    // 1078 - platform
    JT808MsgBodyEncoderEmpty(JT1078MsgConsts.QRY_AV_ATTRS_9003),
    MBEncoder1078_9101_LiveAvReq,
    MBEncoder1078_9102_LiveAvCtrl,
    MBEncoder1078_9105_LiveAvStatus,
    MBEncoder1078_9205_QryAvRes,
    MBEncoder1078_9201_ReplayAv,
    MBEncoder1078_9202_ReplayAvCtrl,
    MBEncoder1078_9206_AvUploadReq,
    MBEncoder1078_9207_AvUploadCtrl,
    MBEncoder1078_9301_PtzTurn,
    MBEncoder1078_9302_PtzFocusing,
    MBEncoder1078_9303_PtzIrisCtrl,
    MBEncoder1078_9304_PtzWiperCtrl,
    MBEncoder1078_9305_PtzFillLightCtrl,
    MBEncoder1078_9306_PtzZoomCtrl,

    // 1078 - terminal
    MBEncoder1078_1003_QryAvAttrsAck,
    MBEncoder1078_1205_QryAvResAck,
    MBEncoder1078_1206_AvUploadCompleted
  )

  val REV_2019: Seq[JT808MsgBodyEncoder] = Seq(
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.QRY_SERVER_TIME_0004),
    MBEncoder808_8004_QryServerTimeAck
  )

  val ADAS: Seq[JT808MsgBodyEncoder] = Seq(
    // Adas - terminal
    MBEncoderAdas_1210_FileList,
    MBEncoderAdas_1211_FileItem,
    MBEncoderAdas_1212_FileItemCompleted,

    // Adas - platform
    MBEncoderAdas_9208_AlmAttUploadReq,
    MBEncoderAdas_9212_AlmAttFileItemCompleted
  )


  val ALL: Seq[JT808MsgBodyEncoder] = REV_2013 ++ REV_2019 ++ ADAS
}
