package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.codec.encoder.impl._
import info.gratour.jt808common.protocol.{JT1078MsgConsts, JT808MsgConsts}

object JT808MsgBodyEncoderRegistry_Rev2013 extends JT808MsgBodyEncoderRegistry {

  private[encoder] val map: Map[Int, JT808MsgBodyEncoder] = Seq(
    // 808 - terminal
    MBEncoder808_0001_TerminalGeneralAck,
    MBEncoder808_0002_Heartbeat,
    MBEncoder808_0200_Location,
    MBEncoder808_0201_QryLocationAck,

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
    MBEncoder808_8700_VTDRDataCollectReq,
    MBEncoder808_8701_VTDRSetParams,
    JT808MsgBodyEncoderEmpty(JT808MsgConsts.DRIVER_IDENTITY_REQ_8702),
    MBEncoder808_8800_MMDataAck,
    MBEncoder808_8801_TakePhoto,
    MBEncoder808_8802_StoredMediaSearch,
    MBEncoder808_8803_StoredMediaReq,
    MBEncoder808_8804_AudioRecordCtrl,
    MBEncoder808_8805_SingleStoredMediaReq,
    MBEncoder808_8900_PassThroughDL,
    MBEncoder808_8A00_PlatformRSAKey,

    // 1078 - platform
    JT808MsgBodyEncoderEmpty(JT1078MsgConsts.QRY_AV_ATTRS_9003),
    MBEncoder1078_9101_LiveAVReq,
    MBEncoder1078_9102_LiveAVCtrl,
    MBEncoder1078_9105_LiveAVStatus,
    MBEncoder1078_9205_QryAVRes,
    MBEncoder1078_9201_ReplayAV,
    MBEncoder1078_9202_ReplayAVCtrl,
    MBEncoder1078_9206_AVUploadReq,
    MBEncoder1078_9207_AVUploadCtrl,
    MBEncoder1078_9301_PTZTurn,
    MBEncoder1078_9302_PTZFocusing,
    MBEncoder1078_9303_PTZIrisCtrl,
    MBEncoder1078_9304_PTZWiperCtrl,
    MBEncoder1078_9305_PTZFillLightCtrl,
    MBEncoder1078_9306_PTZZoomCtrl,

    // Si-Chuan - platform
    MBEncoderSiChuan_9208_AlarmAttUploadReq,
    MBEncoderSiChuan_9212_AlarmAttFileItemCompleted
  ).map(e => e.msgId -> e).toMap

  override def get(msgId: Int): JT808MsgBodyEncoder = map.get(msgId).orNull
}
