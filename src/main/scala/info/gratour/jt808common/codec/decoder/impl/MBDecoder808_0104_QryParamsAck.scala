/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import java.util
import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0104_QryParamsAck
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0104_QryParamsAck
import info.gratour.jt808common.protocol.msg.types.termparams._
import info.gratour.jtcommon.{ByteBufHelper, JTUtils}
import io.netty.buffer.ByteBuf

object MBDecoder808_0104_QryParamsAck extends JT808MsgBodyDecoder[JT808Msg_0104_QryParamsAck] {

  private val logger = Logger(MBDecoder808_0104_QryParamsAck.getClass.getName)

  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0104_QryParamsAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val count = body.readUnsignedByte()
    val map = new util.HashMap[String, Object]()
    val params = new JT808AckParams_0104_QryParamsAck
    params.setParams(map)
    m.setAckParams(params)

    (1 to count).foreach(_ => {
      val id = body.readInt()
      val idHex = JTUtils.intToHex(id, 4).toUpperCase
      val len = body.readUnsignedByte()
      val readerIndex = body.readerIndex()

      def byte(): Unit = {
        map.put(idHex, java.lang.Long.valueOf(body.readUnsignedByte()))
      }

      def word(): Unit = {
        map.put(idHex, java.lang.Long.valueOf(body.readUnsignedShort()))
      }

      def dword(): Unit = {
        map.put(idHex, java.lang.Long.valueOf(body.readUnsignedInt()))
      }

      def str(): Unit = {
        map.put(idHex, body.readStr(len))
      }


      id match {
        case x if (0x0001 to 0x0007) contains x => dword()

        case x if (0x0010 to 0x0017) contains x => str()

        case x if (0x0018 to 0x0019) contains x => dword()

        case 0x001A => str()

        case x if (0x0020 to 0x0022) contains x => dword()

        case x if (0x0027 to 0x0029) contains x => dword()

        case x if (0x002C to 0x0030) contains x => dword()

        case 0x0031 => word()

        case x if (0x0040 to 0x0044) contains x => str()

        case x if (0x0045 to 0x0047) contains x => dword()

        case x if (0x0048 to 0x0049) contains x => str()

        case x if (0x0050 to 0x005A) contains x => dword()

        case x if (0x005B to 0x005E) contains x => word()

        case x if (0x0070 to 0x0074) contains x => dword()

        case 0x0080 => dword()

        case x if (0x0081 to 0x0082) contains x => word()

        case 0x0083 => str()

        case 0x0084 => byte()

        case x if (0x0090 to 0x0092) contains x => byte()

        case 0x0093 => dword()

        case 0x0094 => byte()

        case 0x0095 => dword()

        case 0x0100 | 0x0102 => dword()
        case 0x0101 | 0x0103 => word()
        case 0x0064 =>
          val bits = body.readInt()
          val p = new TP_0064_TimedCaptureCtrlParams
          val enabledFlags: Array[Boolean] = new Array[Boolean](5)
          val storedFlags: Array[Boolean] = new Array[Boolean](5)
          for (i <- 1 to 5) {
            enabledFlags(i-1) = JTUtils.test(bits, 0 + i - 1)
            storedFlags(i-1) = JTUtils.test(bits, 8 + i - 1)
          }
          p.setChanEnabledFlags(enabledFlags)
          p.setChanStoredFlags(storedFlags)
          p.setTimeUnit(
            if (JTUtils.test(bits, 16))
              1
            else
              0
          )
          var interval = bits & 0xFFFE000
          interval >>>= 17
          p.setInterval(interval.toShort)

          map.put(idHex, p)

        case 0x0065 =>
          val bits = body.readInt()
          val p = new TP_0065_DistancedCaptureCtrlParams
          val enabledFlags: Array[Boolean] = new Array[Boolean](5)
          val storedFlags: Array[Boolean] = new Array[Boolean](5)
          for (i <- 1 to 5) {
            enabledFlags(i-1) = JTUtils.test(bits, 0 + i - 1)
            storedFlags(i-1) = JTUtils.test(bits, 8 + i - 1)
          }
          p.setChanEnabledFlags(enabledFlags)
          p.setChanStoredFlags(storedFlags)
          p.setDistanceUnit(
            if (JTUtils.test(bits, 16))
              1
            else
              0
          )
          var distance = bits & 0xFFFE000
          distance >>>= 17
          p.setDistance(distance.toShort)

          map.put(idHex, p)


        case x if (0x0110 to 0x01FF) contains x =>
          val l = body.readLong()
          val bit0_28Mask = 0x1FFFFFFF
          val settings = new TP_0110_CanIdSettings
          settings.setCanId((l & bit0_28Mask).toInt)
          settings.setCalculated(JTUtils.test(l, 29))
          settings.setExtFrame(JTUtils.test(l, 30))
          settings.setCan2(JTUtils.test(l, 31))
          settings.setSamplingInterval((l >>> 32).toInt)

          map.put(idHex, settings)

        // 1078
        case 0x0075 =>
          val params = new TP_0075_AvParams
          params.setLiveStreamMode(body.readByte())
          params.setLiveStreamResolution(body.readByte())
          params.setLiveStreamKFrameInterval(body.readUnsignedShort())
          params.setLiveStreamFrameRate(body.readByte())
          params.setLiveStreamBitRate(body.readInt())

          params.setVodStreamMode(body.readByte())
          params.setVodStreamResolution(body.readByte())
          params.setVodStreamKFrameInterval(body.readUnsignedShort())
          params.setVodStreamFrameRate(body.readByte())
          params.setVodStreamBitRate(body.readInt())

          params.setOsdSettings(body.readShort())
          params.setAudioOutEnabled(body.readByte() != 0)

          map.put(idHex, params)

        case 0x0076 =>
          val settings = new TP_0076_AvChannelSettings
          settings.setAvChannelCnt(body.readByte())
          settings.setAudioChannelCnt(body.readByte())
          settings.setVideoChannelCnt(body.readByte())

          val count = settings.getAvChannelCnt + settings.getAudioChannelCnt + settings.getVideoChannelCnt
          val settingArr = new Array[TP_0076_AvChannelSettings.ChannelSetting](count)
          for (i <- 0 until count) {
            val setting = new TP_0076_AvChannelSettings.ChannelSetting
            setting.setPhyChannelId(body.readByte())
            setting.setLogChannelId(body.readByte())
            setting.setTyp(body.readByte())
            setting.setPtz(body.readByte())

            settingArr(i) = setting
          }

          settings.setChannelSettings(settingArr)

          map.put(idHex, settings)

        case 0x0077 =>
          val count = body.readByte()
          val settingArr = new Array[TP_0077_SpecialChannelVideoParams.SpecialChannelVideoSetting](count)
          for (i <- 0 until count) {
            val setting = new TP_0077_SpecialChannelVideoParams.SpecialChannelVideoSetting
            setting.setLogChannelId(body.readByte())

            setting.setLiveStreamMode(body.readByte())
            setting.setLiveStreamResolution(body.readByte())
            setting.setLiveStreamKFrameInterval(body.readUnsignedShort())
            setting.setLiveStreamFrameRate(body.readByte())
            setting.setLiveStreamBitRate(body.readInt())

            setting.setVodStreamMode(body.readByte())
            setting.setVodStreamResolution(body.readByte())
            setting.setVodStreamKFrameInterval(body.readUnsignedShort())
            setting.setVodStreamFrameRate(body.readByte())
            setting.setVodStreamBitRate(body.readInt())

            setting.setOsdSettings(body.readShort())

            settingArr(i) = setting
          }

          val settings = new TP_0077_SpecialChannelVideoParams
          settings.setSettings(settingArr)

          map.put(idHex, settings)

        case 0x0079 =>
          val params = new TP_0079_SpecialAlarmVideoParams
          params.setVideoStoreQuota(body.readByte())
          params.setRecordDuration(body.readUnsignedByte())
          params.setTagTime(body.readByte())

          map.put(idHex, params)

        case 0x007A =>
          dword()

        case 0x007B =>
          val params = new TP_007B_VideoAnalysisParams
          params.setMaxBoarding(body.readByte())
          params.setFatigueThreshold(body.readByte())

          map.put(idHex, params)

        case 0x007C =>
          val settings = new TP_007C_SleepWakeupSettings
          settings.setWakeupMode(body.readByte())
          settings.setWakeupConditions(body.readByte())
          settings.setWeeklyWakeupSetting(body.readByte())

          val setting = new TP_007C_SleepWakeupSettings.DailyWakeupSetting
          setting.setPeriodEnableFlags(body.readByte())
          setting.setPeriod1WakeupTime(body.readBcd(2))
          setting.setPeriod1SleepTime(body.readBcd(2))
          setting.setPeriod2WakeupTime(body.readBcd(2))
          setting.setPeriod2SleepTime(body.readBcd(2))
          setting.setPeriod3WakeupTime(body.readBcd(2))
          setting.setPeriod3SleepTime(body.readBcd(2))
          setting.setPeriod4WakeupTime(body.readBcd(2))
          setting.setPeriod4SleepTime(body.readBcd(2))

          settings.setDailyWakeupSetting(setting)

          map.put(idHex, settings)

        // si-chuan
        case 0xF364 =>
          val params = new TP_F364_DrivingAssistParams
          params.setOverSpdAlarmThreshold(body.readByte())
          params.setAlarmVoiceVolume(body.readByte())
          params.setActiveCapturePolicy(body.readByte())
          params.setActiveTimedCaptureInterval(body.readShort())
          params.setActiveDistancedCaptureDistance(body.readUnsignedShort())
          params.setActiveCaptureCount(body.readByte())
          params.setActiveCaptureInterval(body.readByte())
          params.setCaptureResolution(body.readByte())
          params.setVideoResolution(body.readByte())
          params.setAlarmEnabledFlags(body.readInt())
          params.setEventEnabledFlags(body.readInt())
          params.setObstacleDistance(body.readByte())
          params.setObstacleAlarmSpdThreshold(body.readByte())
          params.setObstacleAlarmRecordExt(body.readByte())
          params.setObstacleCaptureCount(body.readByte())
          params.setObstacleCaptureInterval(body.readByte())

          params.setChangeLaneFreqAlarmTimeWindow(body.readByte())
          params.setChangeLaneFreqAlarmTimes(body.readByte())
          params.setChangeLaneFreqSpdThreshold(body.readByte())
          params.setChangeLaneFreqRecordExt(body.readByte())
          params.setChangeLaneFreqCaptureCount(body.readByte())
          params.setChangeLaneFreqCaptureInterval(body.readByte())

          params.setStrayPathAlarmSpdThreshold(body.readByte())
          params.setStrayPathAlarmRecordExt(body.readByte())
          params.setStrayPathAlarmCaptureCount(body.readByte())
          params.setStrayPathAlarmCaptureInterval(body.readByte())

          params.setCrashAlarmTimeThreshold(body.readByte())
          params.setCrashAlarmSpdThreshold(body.readByte())
          params.setCrashAlarmRecordExt(body.readByte())
          params.setCrashAlarmCaptureCount(body.readByte())
          params.setCrashAlarmCaptureInterval(body.readByte())

          params.setHitAlarmTimeThreshold(body.readByte())
          params.setHitAlarmSpdThreshold(body.readByte())
          params.setHitAlarmRecordExt(body.readByte())
          params.setHitAlarmCaptureCount(body.readByte())
          params.setHitAlarmCaptureInterval(body.readByte())

          params.setSafeDistanceAlarmDistanceThreshold(body.readByte())
          params.setSafeDistanceAlarmSpdThreshold(body.readByte())
          params.setSafeDistanceAlarmRecordExt(body.readByte())
          params.setSafeDistanceAlarmCaptureCount(body.readByte())
          params.setSafeDistanceAlarmCaptureInterval(body.readByte())

          params.setRoadSignCaptureCount(body.readByte())
          params.setRoadSignCaptureInterval(body.readByte())

          map.put(idHex, params)

        case 0xF365 =>
          val params = new TP_F365_DriverBehaviorMonitorParams
          params.setSpdAlarmThreshold(body.readByte())
          params.setAlarmVoiceVolume(body.readByte())
          params.setActiveCapturePolicy(body.readByte())
          params.setActiveTimedCaptureIntv(body.readShort())
          params.setActiveDistancedCaptureDistance(body.readUnsignedShort())
          params.setActiveCaptureCount(body.readByte())
          params.setActiveCaptureInterval(body.readByte())
          params.setCaptureResolution(body.readByte())
          params.setVideoResolution(body.readByte())
          params.setAlarmEnabledFlags(body.readInt())
          params.setEventEnabledFlags(body.readInt())
          params.setSmokeAlarmTimeThreshold(body.readShort())
          params.setPhoneCallAlarmTimeThreshold(body.readShort())

          body.skipBytes(3)
          //
          params.setFatigueDrivingSpdThreshold(body.readByte())
          params.setFatigueDrivingRecordExt(body.readByte())
          params.setFatigueDrivingCaptureCnt(body.readByte())
          params.setFatigueDrivingCaptureIntv(body.readByte())

          params.setPhoneCallAlarmSpdThreshold(body.readByte())
          params.setPhoneCallAlarmRecordExt(body.readByte())
          params.setPhoneCallAlarmFaceCaptureCnt(body.readByte())
          params.setPhoneCallAlarmFaceCaptureIntv(body.readByte())

          params.setSmokeAlarmSpdThreshold(body.readByte())
          params.setSmokeAlarmRecordExt(body.readByte())
          params.setSmokeAlarmFaceCaptureCnt(body.readByte())
          params.setSmokeAlarmFaceCaptureIntv(body.readByte())

          params.setInattentionSpdThreshold(body.readByte())
          params.setInattentionRecordExt(body.readByte())
          params.setInattentionCaptureCnt(body.readByte())
          params.setInattentionCaptureIntv(body.readByte())

          params.setDriverDetectUnableSpdThreshold(body.readByte())
          params.setDriverDetectUnableRecordExt(body.readByte())
          params.setDriverDetectUnableCaptureCnt(body.readByte())
          params.setDriverDetectUnableCaptureIntv(body.readByte())

          params.setDriverIdentityTrigger(body.readByte())

          map.put(idHex, params)

        case 0xF366 =>
          val params = new TP_F366_TyrePressureMonitorParams
          params.setTyreModel(body.readStr(12))
          params.setPressureUnit(body.readShort())
          params.setNormalPressureValue(body.readShort())
          params.setImbalanceThreshold(body.readShort())
          params.setAirLeakSlowlyThreshold(body.readShort())
          params.setLowPressureThreshold(body.readShort())
          params.setHighPressureThreshold(body.readShort())
          params.setHighTemperatureThreshold(body.readShort())
          params.setVoltageThreshold(body.readShort())
          params.setReportInterval(body.readShort())

          map.put(idHex, params)

        case 0xF367 =>
          val params = new TP_F367_BlindMonitorParams
          params.setRearDistanceAlarmTimeThreshold(body.readByte())
          params.setSideDistanceAlarmTimeThreshold(body.readByte())

          map.put(idHex, params)

        case 0xF370 =>
          val params = new TP_F370_IntenseDrivingMonitorParams
          params.setEnableFlags(body.readInt())
          params.setAccelerateTimeThreshold(body.readShort())
          params.setAccelerateSpeedThreshold(body.readShort())

          body.skipBytes(2)

          params.setBrakeTimeThreshold(body.readShort())
          params.setBrakeSpeedThreshold(body.readShort())

          body.skipBytes(2)

          params.setTurnTimeThreshold(body.readShort())
          params.setTurnSpeedThreshold(body.readShort())

          body.skipBytes(2)

          params.setIdlingTimeThreshold(body.readShort())
          params.setIdlingSpeedThreshold(body.readShort())
          params.setIdlingRotationalSpeedThreshold(body.readShort())

          params.setFlameOutTimeThreshold(body.readShort())
          params.setFlameOutSpeedThreshold(body.readShort())
          params.setFlameOutRotationalSpeedThreshold(body.readShort())

          params.setNeutralTimeThreshold(body.readShort())
          params.setNeutralSpeedThreshold(body.readShort())
          params.setNeutralRotationalSpeedThreshold(body.readShort())

          params.setRotationalSpeedTimeThreshold(body.readShort())
          params.setRotationalSpeedSpeedThreshold(body.readShort())
          params.setRotationalSpeedRpmThreshold(body.readShort())


        case _ =>
          // un-supported parameters
          logger.whenDebugEnabled {
            logger.debug(s"Un-supported param: ${idHex}, len: ${len}.")
          }
          val bytes =
            if (tempBuf.length >= len) tempBuf
            else new Array[Byte](len)
          body.readBytes(bytes, 0, len)

          map.put(idHex, JTUtils.hex(bytes, 0, len))
      }

      val delta = len - (body.readerIndex() - readerIndex)
      if (delta > 0)
        body.skipBytes(delta)
    })


  }
}
