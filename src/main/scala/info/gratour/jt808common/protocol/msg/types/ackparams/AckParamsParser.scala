/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.protocol.msg.types.ackparams

import com.google.gson.Gson
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0702_DriverIdentity
import info.gratour.jt808common.protocol.msg.{JT1078Msg_1003_QryAvAttrsAck, JT1078Msg_1205_QryAvResAck, JT1078Msg_9003_QryAvAttrs, JT1078Msg_9205_QryAvRes, JT808Msg_0104_QryParamsAck, JT808Msg_0107_QryAttrsAck, JT808Msg_0201_QryLocationAck, JT808Msg_0302_InquestAnswer, JT808Msg_0500_VehCtrlAck, JT808Msg_0700_VtdrData, JT808Msg_0702_DriverIdentity, JT808Msg_0802_StoredMediaSearchAck, JT808Msg_0805_TakePhotoAck, JT808Msg_8104_QryAllParams, JT808Msg_8106_QrySpecialParams, JT808Msg_8107_QryAttrs, JT808Msg_8201_QryLocation, JT808Msg_8302_Inquest, JT808Msg_8500_VehCtrl, JT808Msg_8700_VtdrDataCollectReq, JT808Msg_8702_DriverIdentityReq, JT808Msg_8801_TakePhoto, JT808Msg_8802_StoredMediaSearch}
import info.gratour.jtcommon.JTUtils

object AckParamsParser extends JT808AckParamsParser {

  private val map: Map[Int, Class[_ <: JT808AckParams]] = Seq(

    classOf[JT808AckParams_0104_QryParamsAck],
    classOf[JT808AckParams_0107_QryAttrsAck],
    classOf[JT808AckParams_0201_QryLocationAck],
    classOf[JT808AckParams_0302_InquestAnswer],
    classOf[JT808AckParams_0500_VehCtrlAck],
    classOf[JT808AckParams_0700_VtdrData],
    classOf[JT808AckParams_0802_StoredMediaSearchAck],
    classOf[JT808AckParams_0805_TakePhotoAck],
    classOf[JT1078AckParams_1003_QryAvAttrsAck],
    classOf[JT1078AckParams_1205_QryAvResAck],
    classOf[MQEventAddt_0702_DriverIdentity]

  ).map(c => {
    JTUtils.jtMsgIdOf(c) -> c
  }).toMap

  def clazzOf(msgId: Int): Class[_] =
    map.get(msgId).orNull

  @Override
  def fromJsonBySrcMsgId(srcMsgId: Int, json: String, gson: Gson): JT808AckParams = {
    if (json == null)
      return null

    val ackMsgId =
      srcMsgId match {
        case JT808Msg_8104_QryAllParams.MSG_ID | JT808Msg_8106_QrySpecialParams.MSG_ID =>
          JT808Msg_0104_QryParamsAck.MSG_ID

        case JT808Msg_8107_QryAttrs.MSG_ID =>
          JT808Msg_0107_QryAttrsAck.MSG_ID

        case JT808Msg_8201_QryLocation.MSG_ID =>
          JT808Msg_0201_QryLocationAck.MSG_ID

        case JT808Msg_8302_Inquest.MSG_ID =>
          JT808Msg_0302_InquestAnswer.MSG_ID

        case JT808Msg_8500_VehCtrl.MSG_ID =>
          JT808Msg_0500_VehCtrlAck.MSG_ID

        case JT808Msg_8700_VtdrDataCollectReq.MSG_ID =>
          JT808Msg_0700_VtdrData.MSG_ID

        case JT808Msg_8702_DriverIdentityReq.MSG_ID =>
          JT808Msg_0702_DriverIdentity.MSG_ID

        case JT808Msg_8802_StoredMediaSearch.MSG_ID =>
          JT808Msg_0802_StoredMediaSearchAck.MSG_ID

        case JT808Msg_8801_TakePhoto.MSG_ID =>
          JT808Msg_0805_TakePhotoAck.MSG_ID

        case JT1078Msg_9003_QryAvAttrs.MSG_ID =>
          JT1078Msg_1003_QryAvAttrsAck.MSG_ID

        case JT1078Msg_9205_QryAvRes.MSG_ID =>
          JT1078Msg_1205_QryAvResAck.MSG_ID

        case _ =>
          0
      }

    if (ackMsgId == 0)
      return null

    val clzz = map.get(ackMsgId).orNull
    if (clzz == null)
      throw new RuntimeException(s"Ack params for `${JTUtils.msgIdToHex(ackMsgId)}` was not found.")

    gson.fromJson(json, clzz)
  }


  @Override
  def fromJson(ackMsgId: Int, json: String, gson: Gson): JT808AckParams = {
    if (json == null)
      return null

    val clzz = map.get(ackMsgId).orNull
    if (clzz == null)
      throw new RuntimeException(s"Ack params for `${JTUtils.msgIdToHex(ackMsgId)}` was not found.")

    gson.fromJson(json, clzz)
  }



}
