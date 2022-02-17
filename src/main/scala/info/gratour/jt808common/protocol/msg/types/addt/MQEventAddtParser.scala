/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt

import info.gratour.jt808common.protocol.msg.types.trk.Trk
import info.gratour.jt808common.protocol.{JT1078MsgConsts, JT808MsgConsts}
import info.gratour.jtcommon.JTUtils

object MQEventAddtParser {

  private val map: Map[String, Class[_ <: MQEventAddt]] = Seq(
    JT808MsgConsts.TERMINAL_REGISTER_0100 -> classOf[MQEventAddt_0100_TermRegister],
    JT808MsgConsts.LOCATION_0200 -> classOf[Trk],
    JT808MsgConsts.BATCH_LOCATION_0704 -> classOf[Trk],
    JT808MsgConsts.EVENT_REPORT_0301 -> classOf[MQEventAddt_0301_EventReport],
    JT808MsgConsts.INFO_DEMAND_0303 -> classOf[MQEventAddt_0303_InfoDemand],
    JT808MsgConsts.WAYBILL_0701 -> classOf[MQEventAddt_0701_WayBill],
    JT808MsgConsts.DRIVER_IDENTITY_0702 -> classOf[MQEventAddt_0702_DriverIdentity],
    JT808MsgConsts.CAN_DATA_0705 -> classOf[MQEventAddt_0705_CanData],
    JT808MsgConsts.MULTI_MEDIA_EVENT_0800 -> classOf[MQEventAddt_0800_MultiMediaEvent],
    JT808MsgConsts.MULTI_MEDIA_DATA_0801 -> classOf[MQEventAddt_0801_MultiMediaData],
    JT808MsgConsts.PASS_THROUGH_DATA_UL_0900 -> classOf[MQEventAddt_0900_PassThroughUl],
    JT1078MsgConsts.PASSENGER_TRAFFIC_1005 -> classOf[MQEventAddt_1005_PassengerTraffic]
  ).map((t) => {
    JTUtils.msgIdToHex(t._1) -> t._2
  }).toMap

  def clazzOf(msgId: Int): Class[_] =
    map.get(JTUtils.msgIdToHex(msgId)).orNull

  def clazzOf(msgIdHex: String): Class[_] =
    map.get(msgIdHex).orNull

}

