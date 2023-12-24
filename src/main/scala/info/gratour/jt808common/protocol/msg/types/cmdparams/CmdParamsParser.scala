/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams

import com.google.gson.Gson
import info.gratour.jtcommon.{JTConsts, JTUtils}

object CmdParamsParser extends JT808CmdParamsParser {

  private val map: Map[Int, Class[_ <: JT808CmdParams]] = Seq(
    classOf[CP_8103_SetParams],
    classOf[CP_8105_TerminalCtrl],
    classOf[CP_8106_QrySpecialParams],
    classOf[CP_8202_LocationTraceCtrl],
    classOf[CP_8203_ManualConfirmAlarm],

    classOf[CP_8300_SendText],
    classOf[CP_8301_SetUpEvent],
    classOf[CP_8302_Inquest],
    classOf[CP_8303_SetUpInfoMenu],
    classOf[CP_8304_InfoService],

    classOf[CP_8400_PhoneCallback],
    classOf[CP_8401_SetUpPhoneBook],

    classOf[CP_8500_VehCtrl],

    classOf[CP_8600_SetCircleRegion],
    classOf[CP_8601_DelCircleRegion],
    classOf[CP_8602_SetRectRegion],
    classOf[CP_8603_DelRectRegion],
    classOf[CP_8604_SetPolygonRegion],
    classOf[CP_8605_DelPolygonRegion],
    classOf[CP_8606_SetRoute],
    classOf[CP_8607_DelRoute],

    classOf[CP_8700_VtdrDataCollectReq],
    classOf[CP_8701_VtdrSetParams],

    classOf[CP_8801_TakePhoto],
    classOf[CP_8802_StoredMediaSearch],
    classOf[CP_8803_StoredMediaReq],
    classOf[CP_8804_AudioRecordCtrl],
    classOf[CP_8805_SingleStoredMediaReq],

    classOf[CP_9101_LiveAvReq],
    classOf[CP_9102_LiveAvCtrl],
    classOf[CP_9105_LiveAvStatus],

    classOf[CP_9201_ReplayAvReq],
    classOf[CP_9202_ReplayAvCtrl],
    classOf[CP_9205_QryAvRes],
    classOf[CP_9206_AvUploadReq],
    classOf[CP_9207_AvUploadCtrl],
    classOf[CP_9208_AlmAddtUploadReq], // ADAS
    classOf[CP_9212_AlmAttFileItemCompleted], // ADAS

    classOf[CP_9301_PtzTurn],
    classOf[CP_9302_PtzFocusing],
    classOf[CP_9303_PtzIrisCtrl],
    classOf[CP_9304_PtzWiperCtrl],
    classOf[CP_9305_PtzFillLightCtrl],
    classOf[CP_9306_PtzZoomCtrl],
  ).map(clzz => {
    JTUtils.jtMsgIdOf(clzz) -> clzz
  }).toMap

  def clazzOf(msgId: Int): Class[_] =
    map.get(msgId).orNull

  @Override
  def fromJson(msgId: Int, json: String, gson: Gson): JT808CmdParams = {
    if (json == null)
      return null

    val clazz = clazzOf(msgId)
    if (clazz == null)
      throw new RuntimeException(s"Command params for `${JTUtils.msgIdToHex(msgId)}` was not found.")

    gson.fromJson(json, clazz)
  }

}
