package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.codec.decoder.impl.{MBDecoder1078_1003_QryAVAttrsAck, MBDecoder1078_1005_PassengerTraffic, MBDecoder1078_1205_QryAVResAck, MBDecoder1078_1206_AVUploadCompleted, MBDecoder1078_9101_LiveAVReq, MBDecoder1078_9102_LiveAVCtrl, MBDecoder1078_9201_ReplayAVReq, MBDecoder1078_9202_ReplayAVCtrl, MBDecoder1078_9205_QryAVRes, MBDecoder1078_9206_AVUploadReq, MBDecoder1078_9207_AVUploadCtrl, MBDecoder808_0001_TerminalGeneralAck, MBDecoder808_0002_Heartbeat, MBDecoder808_0003_TerminalUnregister, MBDecoder808_0100_TerminalRegister, MBDecoder808_0102_TerminalAuth, MBDecoder808_0104_QryParamsAck, MBDecoder808_0107_QryAttrsAck, MBDecoder808_0108_UpgradeResult, MBDecoder808_0200_Location, MBDecoder808_0201_QryLocationAck, MBDecoder808_0301_EventReport, MBDecoder808_0302_InquestAnswer, MBDecoder808_0303_InfoDemand, MBDecoder808_0500_VehCtrlAck, MBDecoder808_0700_VTDRData, MBDecoder808_0701_WayBill, MBDecoder808_0702_DriverIdentity, MBDecoder808_0704_BatchLocation, MBDecoder808_0705_CANData, MBDecoder808_0800_MultiMediaEvent, MBDecoder808_0801_MultiMediaData, MBDecoder808_0802_StoredMediaSearchAck, MBDecoder808_0805_TakePhotoAck, MBDecoder808_0900_PassThroughUL, MBDecoder808_0901_CompressedDataUL, MBDecoder808_8001_PlatformGeneralAck}

object JT808MsgBodyDecoderRegistry_Rev2013 extends JT808MsgBodyDecoderRegistry {

  private[decoder] val map: Map[Int, JT808MsgBodyDecoder[_]] = Seq(
    // 808 - terminal
    MBDecoder808_0001_TerminalGeneralAck,
    MBDecoder808_0002_Heartbeat,
    MBDecoder808_0003_TerminalUnregister,
    MBDecoder808_0100_TerminalRegister,
    MBDecoder808_0102_TerminalAuth,
    MBDecoder808_0104_QryParamsAck,
    MBDecoder808_0107_QryAttrsAck,
    MBDecoder808_0108_UpgradeResult,
    MBDecoder808_0200_Location,
    MBDecoder808_0201_QryLocationAck,
    MBDecoder808_0301_EventReport,
    MBDecoder808_0302_InquestAnswer,
    MBDecoder808_0303_InfoDemand,
    MBDecoder808_0500_VehCtrlAck,
    MBDecoder808_0700_VTDRData,
    MBDecoder808_0701_WayBill,
    MBDecoder808_0702_DriverIdentity,
    MBDecoder808_0704_BatchLocation,
    MBDecoder808_0705_CANData,
    MBDecoder808_0800_MultiMediaEvent,
    MBDecoder808_0801_MultiMediaData,
    MBDecoder808_0805_TakePhotoAck,
    MBDecoder808_0802_StoredMediaSearchAck,
    MBDecoder808_0900_PassThroughUL,
    MBDecoder808_0901_CompressedDataUL,

    // 808 - platform
    MBDecoder808_8001_PlatformGeneralAck,

    // 1078 - terminal

    MBDecoder1078_1003_QryAVAttrsAck,
    MBDecoder1078_1005_PassengerTraffic,
    MBDecoder1078_1205_QryAVResAck,
    MBDecoder1078_1206_AVUploadCompleted,

    // 1078 - platform
    MBDecoder1078_9101_LiveAVReq,
    MBDecoder1078_9102_LiveAVCtrl,
    MBDecoder1078_9201_ReplayAVReq,
    MBDecoder1078_9202_ReplayAVCtrl,
    MBDecoder1078_9205_QryAVRes,
    MBDecoder1078_9206_AVUploadReq,
    MBDecoder1078_9207_AVUploadCtrl
  ).map(d => (d.msgId -> d)).toMap

  override def get(msgId: Int): JT808MsgBodyDecoder[_] = map.get(msgId).orNull

}
