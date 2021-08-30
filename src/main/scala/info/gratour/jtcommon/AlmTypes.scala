/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

import java.util.{Locale, ResourceBundle}


object AlmTypes {

  val TYP_0001_OVER_SPEED = "0001"
  val TYP_0002_FATIGUED = "0002"
  val TYP_0003_PANIC = "0003"
  val TYP_0004_ENTER_REGION = "0004"
  val TYP_0005_LEAVE_REGION = "0005"
  val TYP_0009_STEAL = "0009"
  val TYP_000B_STRAY_PATH = "000B"
  val TYP_000C_UNINTENDED_MOTION = "000C"
  val TYP_000D_DRIVE_OVERTIME = "000D"
  val TYP_0010_VIOLATED_2019 = "0010"
  val TYP_0013_ABNORMAL_TYRE_PRESS = "0013"
  val TYP_0101_VID_LOSS = "0101"
  val TYP_0102_VID_COVER = "0102"
  val TYP_0103_VID_STG_ALM = "0103"
  val TYP_0104_VID_OTHER_EQUIP_FAULT = "0104"
  val TYP_0105_PASSENGER_OVERLOAD = "0105"
  val TYP_0106_UNUSUAL_DRIVE_BEHAV = "0106"
  val TYP_0107_SPEICAL_REC_STG_RUN_OUT = "0107"

  val TYP_0201_ADAS_FRONT_CRASH = "0201"
  val TYP_0202_ADAS_STRAY_PATH = "0202"
  val TYP_0203_ADAS_VEH_TOO_CLOSE = "0203"
  val TYP_0204_ADAS_PEDESTRIAN_HIT = "0204"
  val TYP_0205_ADAS_CHANGE_LANE_FREQUENTLY = "0205"
  val TYP_0206_ADAS_ROAD_RECOG_OVERRUN = "0206"
  val TYP_0207_ADAS_OBSTACLE = "0207"
  val TYP_0208_ADAS_ASSIST_FUNC_FAILURE = "0208"

  val TYP_0211_ADAS_FATIGUED = "0211"
  val TYP_0212_ADAS_NO_LOOK_AHEAD = "0212"
  val TYP_0213_ADAS_SMOKE = "0213"
  val TYP_0214_ADAS_PHONE_CALL = "0214"
  val TYP_0215_ADAS_DRIVER_NOT_DETECTED = "0215"
  val TYP_0216_ADAS_STEERING_WHEEL_NOT_HOLDING = "0216"
  val TYP_0217_ADAS_DRIVER_BEHAV_ALM_FUNC_FAILURE = "0217"
  val TYP_0218_ADAS_INVALID_DRIVER_ID = "0218"
  val TYP_0219_ADAS_DRIVER_CHANGED_EVENT = "0219"

  val TYP_0221_ADAS_TYRE_PRESS_TOO_HIGH = "0221"
  val TYP_0222_ADAS_TYRE_PRESS_TOO_LOW = "0222"
  val TYP_0223_ADAS_TYRE_TEMP_TOO_HIGH = "0223"
  val TYP_0224_ADAS_TYRE_SENSOR_FAILURE = "0224"
  val TYP_0225_ADAS_TYRE_PRESS_DISBALANCE = "0225"
  val TYP_0226_ADAS_TYRE_AIR_LEAK_SLOWLY = "0226"
  val TYP_0227_ADAS_BATTERY_LOW = "0227"

  val TYP_0231_ADAS_REAR_TOO_CLOSE = "0231"
  val TYP_0232_ADAS_LEFT_REAR_TOO_CLOSE = "0232"
  val TYP_0233_ADAS_RIGHT_REAR_TOO_CLOSE = "0233"

  val TYP_0241_ADAS_RAPID_ACCELERATE = "0241"
  val TYP_0242_ADAS_RAPID_DECELERATE = "0242"
  val TYP_0243_ADAS_RAPID_TURN = "0243"
  val TYP_0244_ADAS_IDLING = "0244"
  val TYP_0245_ADAS_UNEXPECTED_FLAME_OUT = "0245"
  val TYP_0246_ADAS_SLIDING_ON_N = "0246"
  val TYP_0247_ADAS_ENGINE_RPM_TOO_HIGH = "0247"

  val TYP_E002_ENTER_RGN_EVENT = "E002"

  val TYP_E101_VIOLATED_CHANGE_PATH = "E101"
  val TYP_E102_PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = "E102"
  val TYP_E103_CAMERA_COVERED = "E103"
  val TYP_E104_ONE_TIME_DRIVE_OVERTIME = "E104"
  val TYP_E105_ANTI_FACE_RECOG_DETECT_FUNC_FAILURE = "E105"
  val TYP_E106_PLAY_SMART_PHONE = "E106"
  val TYP_E107_NOT_BELTING = "E107"

  val SUB_TYP__EMPTY = ""
  val SUB_TYP__TERM_NORMAL_OVER_SPD = "1"
  val SUB_TYP__TERM_ROAD_OVER_SPD = "2"


  val JT809Rev2011AlmTypes: Seq[String] = Seq(
    "0001",
    "0002",
    "0003",
    "0004",
    "0005",
    "0008",
    "0009",
    "000A",
    "000B",
    "000C",
    "000D",
    "0010",
    "00FF",
  )

  val JT809Rev2019AlmTypes: Seq[String] = JT809Rev2011AlmTypes ++ Seq(
    "0011",
    "0012",
    "0013",
    "0014",
    "A001",
    "A002",
    "A003",
    "A004",
    "A005",
    "A006",
    "A007",
    "A008",
    "A009",
    "A00A",
    "A0FF",
  )

  val JT1078AlmTypes: Seq[String] = Seq(
    "0101",
    "0102",
    "0103",
    "0104",
    "0105",
    "0106",
    "0107",
  )

  val CustomAlmTypes: Seq[String] = Seq(
    "E001",
    "E002",
    "E003",
    "E004"
  )

  val AdasAlmTypes: Seq[String] = Seq(
    "0201",
    "0202",
    "0203",
    "0204",
    "0205",
    "0206",
    "0207",
    "0208",
    "0211",
    "0212",
    "0213",
    "0214",
    "0215",
    "0216",
    "0217",
    "0218",
    "0219",
    "0221",
    "0222",
    "0223",
    "0224",
    "0225",
    "0226",
    "0227",
    "0231",
    "0232",
    "0233",
    "0234",
    "0241",
    "0242",
    "0243",
    "0244",
    "0245",
    "0246",
    "0247",
    "0301",
    "0302",
    "0304",
    "0305",
    "0306",
    "0307",
    "0308",
    "0311",
    "0312",
    "0313",
    "0314",
    "E101",
    "E102",
    "E103",
    "E104",
    "E105",
    "E106"
  )

  val AdasAlmTypeSet: Set[String] = AdasAlmTypes.toSet

  val AllAlmTypes: Seq[String] = JT809Rev2019AlmTypes ++ JT1078AlmTypes ++ AdasAlmTypes ++ CustomAlmTypes

  def almTypToStr(typ: Int): String = JTUtils.intToHex(typ, 4).toUpperCase

  def strToAlmTyp(typ: String): Int = Integer.parseInt(typ, 16)

  def resourceBundle(locale: Locale): ResourceBundle =
    ResourceBundle.getBundle(
      "info.gratour.jt808common.protocol.platform-alm-typ-names",
      if (locale != null) locale else Locale.getDefault
    )

  def almTypeName(almTypId: String, locale: Locale): String = {
    val key = "ALARM_TYPE_" + almTypId

    val bundle = resourceBundle(locale)

    if (bundle.containsKey(key))
      bundle.getString(key)
    else
      almTypId
  }

  def almTypeName(typ: Int, locale: Locale): String = {
    val almTypId = JTUtils.intToHex(typ, 4).toUpperCase
    almTypeName(almTypId, locale)
  }

  def almSubTypName(subTyp: String, locale: Locale): String = {
    subTyp match {
      case null | SUB_TYP__EMPTY =>
        ""

      case _ =>
        val key = "ALM_SUB_TYP_" + subTyp

        val bundle = resourceBundle(locale)

        if (bundle.containsKey(key))
          bundle.getString(key)
        else
          subTyp
    }
  }

}
