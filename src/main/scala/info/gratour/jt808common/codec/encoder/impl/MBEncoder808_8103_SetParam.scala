/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8103_SetParam
import info.gratour.jt808common.protocol.msg.types.termparams.{TP_0064_TimedCaptureCtrlParams, TP_0065_DistancedCaptureCtrlParams, TP_0075_AvParams, TP_0076_AvChannelSettings, TP_0077_SpecialChannelVideoParams, TP_0079_SpecialAlarmVideoParams, TP_007B_VideoAnalysisParams, TP_007C_SleepWakeupSettings, TP_0110_CanIdSettings, TP_F364_DrivingAssistParams, TP_F365_DriverBehaviorMonitorParams, TP_F366_TyrePressureMonitorParams, TP_F367_BlindMonitorParams, TP_F370_IntenseDrivingMonitorParams}
import info.gratour.jtcommon.{ByteBufHelper, JTUtils}
import io.netty.buffer.ByteBuf

import scala.collection.mutable
import scala.reflect.ClassTag

object MBEncoder808_8103_SetParam extends AbstractJT808MsgBodyEncoder[JT808Msg_8103_SetParam] {

  private sealed trait DataType

  private case object BYTE extends DataType

  private case object WORD extends DataType

  private case object DWORD extends DataType

  private case object STRING extends DataType


  private val paramDataTypeMap: Map[Int, DataType] = {
    val m = mutable.Map[Int, DataType]()

    def range(dataType: DataType, r: Range*): Unit = {
      r.foreach(r => {
        r.foreach(id => {
          m.put(id, dataType)
        })
      })
    }

    def ids(dataType: DataType, id: Int*): Unit = {
      id.foreach(id => m.put(id, dataType))
    }

    range(BYTE,
      0x0090 to 0x0092,
    )

    range(WORD,
      0x005B to 0x005E,
      0x0081 to 0x0082,
    )

    range(DWORD,
      0x0001 to 0x0007,
      0x0018 to 0x0019,
      0x001B to 0x001C,
      0x0020 to 0x0022,
      0x0027 to 0x0029,
      0x002C to 0x0030,
      0x0045 to 0x0047,
      0x0050 to 0x005A,
      0x0070 to 0x0074,
    )

    range(STRING,
      0x0010 to 0x0017,
      0x0040 to 0x0044,
      0x0048 to 0x0049,
    )

    ids(BYTE, 0x0084, 0x0094)
    ids(WORD, 0x0031, 0x0101, 0x0103)
    ids(DWORD, 0x0080, 0x0093, 0x0095, 0x0100, 0x0102, 0x007A)
    ids(STRING, 0x001A, 0x001D, 0x0083)

    m.toMap
  }

  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8103_SetParam, out: ByteBuf): Unit = {
    if (m.getParams == null || m.getParams.getParams == null || m.getParams.getParams.isEmpty)
      throw new CodecError("params or params.params is null/empty.")

    val params = m.getParams.getParams

    var ignore0013 = false
    var paramCount = params.size()

    val p0013 = params.get("0013")
    if (p0013 != null) {
      if (protoVer == 0) {
        // if old protocol
        val s0013 = p0013.toString
        val idxOfColon = s0013.indexOf(':')
        if (idxOfColon > 0) {
          // if contains ':', split and add
          val idx = s0013.indexOf(';')
          val sHostAndPort =
            if (idx >= 0) {
              s0013.substring(0, idx)
            } else
              s0013

          val host = sHostAndPort.substring(0, idxOfColon)
          val port = sHostAndPort.substring(idxOfColon + 1).toInt

          out.writeInt(0x0013)
          out.writeByteLenPrefixedStr(host)


          ignore0013 = true
          if (!params.containsKey("0018")) {
            out.writeInt(0x0018)
            out.writeByte(2)
            out.writeShort(port)
            paramCount += 1
          }
        }
      }
    }

    out.writeByte(paramCount)

    params.forEach((id, value) => {
      if (!ignore0013 || id != "0013") {
        val pid = Integer.parseInt(id, 16)


        def checkInt: Int = {
          if (value == null || (!value.isInstanceOf[Number] && !value.isInstanceOf[String]))
            throw new CodecError(id)
          value match {
            case n: Number =>
              n.intValue()

            case s: String =>
              s.toInt
          }
        }

        def checkStr: String = {
          if (value == null)
            throw new CodecError(id)

          value.toString
        }

        def checkObject[T](implicit classTag: ClassTag[T]): T = {
          if (value == null || !classTag.runtimeClass.isAssignableFrom(value.getClass))
            throw new CodecError(classTag.runtimeClass.getName)

          value.asInstanceOf[T]
        }

        out.writeInt(pid)
        val sizeOffset = out.writerIndex()
        out.writeByte(0)

        val dataType = paramDataTypeMap.get(pid).orNull
        if (dataType != null) {
          dataType match {
            case BYTE => out.writeByte(checkInt)
            case WORD => out.writeShort(checkInt)
            case DWORD => out.writeInt(checkInt)
            case STRING => out.writeStr(checkStr)
          }
        } else {
          pid match {
            case 0x0064 =>
              val p = checkObject[TP_0064_TimedCaptureCtrlParams]
              var bits: Int = 0
              for (i <- 1 to 5) {
                if (p.chanEnabled(i))
                  bits = JTUtils.set(bits, 0 + i - 1)
                if (p.chanStored(i))
                  bits = JTUtils.set(bits, 8 + i - 1)
              }
              if (p.getTimeUnit != 0)
                bits = JTUtils.set(bits, 16)
              var interval: Int = p.getInterval
              interval <<= 17
              bits = bits | interval
              out.writeInt(bits)

            case 0x0065 =>
              val p = checkObject[TP_0065_DistancedCaptureCtrlParams]
              var bits: Int = 0
              for (i <- 1 to 5) {
                if (p.chanEnabled(i))
                  bits = JTUtils.set(bits, 0 + i - 1)
                if (p.chanStored(i))
                  bits = JTUtils.set(bits, 8 + i - 1)
              }
              if (p.getDistanceUnit != 0)
                bits = JTUtils.set(bits, 16)
              var distance: Int = p.getDistance
              distance <<= 17
              bits = bits | distance
              out.writeInt(bits)

            case x if 0x0110 to 0x01FF contains x =>
              val p = checkObject[TP_0110_CanIdSettings]
              var l: Long = p.getSamplingInterval
              l <<= 32
              var i: Int = p.getCanId
              if (p.isCalculated)
                i = JTUtils.set(i, 29)
              if (p.isExtFrame)
                i = JTUtils.set(i, 30)
              if (p.isCan2)
                i = JTUtils.set(i, 31)
              l = l | i;
              out.writeLong(l)

            // 1078
            case 0x0075 =>
              val p = checkObject[TP_0075_AvParams]
              out.writeByte(p.getLiveStreamMode)
              out.writeByte(p.getLiveStreamResolution)
              out.writeShort(p.getLiveStreamKFrameInterval)
              out.writeByte(p.getLiveStreamFrameRate)
              out.writeInt(p.getLiveStreamBitRate)

              out.writeByte(p.getVodStreamMode)
              out.writeByte(p.getVodStreamResolution)
              out.writeShort(p.getVodStreamKFrameInterval)
              out.writeByte(p.getVodStreamFrameRate)
              out.writeInt(p.getVodStreamBitRate)

              out.writeShort(p.getOsdSettings)
              out.writeByte(if (p.getAudioOutEnabled) 1 else 0)

            case 0x0076 =>
              val p = checkObject[TP_0076_AvChannelSettings]
              if (p.getChannelSettings == null)
                throw new CodecError("channelSettings == null")

              out.writeByte(p.getAvChannelCnt())
              out.writeByte(p.getAudioChannelCnt)
              out.writeByte(p.getVideoChannelCnt)

              p.getChannelSettings.foreach(setting => {
                out.writeByte(setting.getPhyChannelId)
                out.writeByte(setting.getLogChannelId)
                out.writeByte(setting.getTyp)
                out.writeByte(setting.getPtz)
              })

            case 0x0077 =>
              val p = checkObject[TP_0077_SpecialChannelVideoParams]
              if (p.getSettings == null)
                throw new CodecError("settings == null")

              out.writeByte(p.getSettings.length)
              p.getSettings.foreach(setting => {
                out.writeByte(setting.getLogChannelId)

                out.writeByte(setting.getLiveStreamMode)
                out.writeByte(setting.getLiveStreamResolution)
                out.writeShort(setting.getLiveStreamKFrameInterval)
                out.writeByte(setting.getLiveStreamFrameRate)
                out.writeInt(setting.getLiveStreamBitRate)

                out.writeByte(setting.getVodStreamMode)
                out.writeByte(setting.getVodStreamResolution)
                out.writeShort(setting.getVodStreamKFrameInterval)
                out.writeByte(setting.getVodStreamFrameRate)
                out.writeInt(setting.getVodStreamBitRate)

                out.writeShort(setting.getOsdSettings)
              })

            case 0x0079 =>
              val p = checkObject[TP_0079_SpecialAlarmVideoParams]
              out.writeByte(p.getVideoStoreQuota)
              out.writeByte(p.getRecordDuration)
              out.writeByte(p.getTagTime)

            case 0x007B =>
              val p = checkObject[TP_007B_VideoAnalysisParams]
              out.writeByte(p.getMaxBoarding)
              out.writeByte(p.getFatigueThreshold)

            case 0x007C =>
              val p = checkObject[TP_007C_SleepWakeupSettings]
              out.writeByte(p.getWakeupMode)
              out.writeByte(p.getWakeupConditions)
              out.writeByte(p.getWeeklyWakeupSetting)

              val setting = p.getDailyWakeupSetting
              out.writeBcd(setting.getPeriod1WakeupTime)
              out.writeBcd(setting.getPeriod1SleepTime)
              out.writeBcd(setting.getPeriod2WakeupTime)
              out.writeBcd(setting.getPeriod2SleepTime)
              out.writeBcd(setting.getPeriod3WakeupTime)
              out.writeBcd(setting.getPeriod3SleepTime)
              out.writeBcd(setting.getPeriod4WakeupTime)
              out.writeBcd(setting.getPeriod4SleepTime)

            // si-chuan
            case 0xF364 =>
              val p = checkObject[TP_F364_DrivingAssistParams]
              out.writeByte(p.getOverSpdAlarmThreshold)
              out.writeByte(p.getAlarmVoiceVolume)
              out.writeByte(p.getActiveCapturePolicy)
              out.writeShort(p.getActiveTimedCaptureInterval)
              out.writeShort(p.getActiveDistancedCaptureDistance)
              out.writeByte(p.getActiveCaptureCount)
              out.writeByte(p.getActiveCaptureInterval)
              out.writeByte(p.getCaptureResolution)
              out.writeByte(p.getVideoResolution)
              out.writeInt(p.getAlarmEnabledFlags)
              out.writeInt(p.getEventEnabledFlags)

              out.writeByte(p.getObstacleDistance)
              out.writeByte(p.getObstacleAlarmSpdThreshold)
              out.writeByte(p.getObstacleAlarmRecordExt)
              out.writeByte(p.getObstacleCaptureCount)
              out.writeByte(p.getObstacleCaptureInterval)

              out.writeByte(p.getChangeLaneFreqAlarmTimeWindow)
              out.writeByte(p.getChangeLaneFreqAlarmTimes)
              out.writeByte(p.getChangeLaneFreqSpdThreshold)
              out.writeByte(p.getChangeLaneFreqRecordExt)
              out.writeByte(p.getChangeLaneFreqCaptureCount)
              out.writeByte(p.getChangeLaneFreqCaptureInterval)

              out.writeByte(p.getStrayPathAlarmSpdThreshold)
              out.writeByte(p.getStrayPathAlarmRecordExt)
              out.writeByte(p.getStrayPathAlarmCaptureCount)
              out.writeByte(p.getStrayPathAlarmCaptureInterval)

              out.writeByte(p.getCrashAlarmTimeThreshold)
              out.writeByte(p.getCrashAlarmSpdThreshold)
              out.writeByte(p.getCrashAlarmRecordExt)
              out.writeByte(p.getCrashAlarmCaptureCount)
              out.writeByte(p.getCrashAlarmCaptureInterval)

              out.writeByte(p.getHitAlarmTimeThreshold)
              out.writeByte(p.getHitAlarmSpdThreshold)
              out.writeByte(p.getHitAlarmRecordExt)
              out.writeByte(p.getHitAlarmCaptureCount)
              out.writeByte(p.getHitAlarmCaptureInterval)

              out.writeByte(p.getSafeDistanceAlarmDistanceThreshold)
              out.writeByte(p.getSafeDistanceAlarmSpdThreshold)
              out.writeByte(p.getSafeDistanceAlarmRecordExt)
              out.writeByte(p.getSafeDistanceAlarmCaptureCount)
              out.writeByte(p.getSafeDistanceAlarmCaptureInterval)

              out.writeByte(p.getRoadSignCaptureCount)
              out.writeByte(p.getRoadSignCaptureInterval)

              out.writeInt(0)

            case 0xF365 =>
              val p = checkObject[TP_F365_DriverBehaviorMonitorParams]
              out.writeByte(p.getSpdAlarmThreshold)
              out.writeByte(p.getAlarmVoiceVolume)

              out.writeByte(p.getActiveCapturePolicy)
              out.writeShort(p.getActiveTimedCaptureIntv)
              out.writeShort(p.getActiveDistancedCaptureDistance)
              out.writeByte(p.getActiveCaptureCount)
              out.writeByte(p.getActiveCaptureInterval)

              out.writeByte(p.getCaptureResolution)
              out.writeByte(p.getVideoResolution)

              out.writeInt(p.getAlarmEnabledFlags)
              out.writeInt(p.getEventEnabledFlags)

              out.writeShort(p.getSmokeAlarmTimeThreshold)
              out.writeShort(p.getPhoneCallAlarmTimeThreshold)

              out.writeMedium(0)

              out.writeByte(p.getFatigueDrivingSpdThreshold)
              out.writeByte(p.getFatigueDrivingRecordExt)
              out.writeByte(p.getFatigueDrivingCaptureCnt)
              out.writeByte(p.getFatigueDrivingCaptureIntv)

              out.writeByte(p.getPhoneCallAlarmSpdThreshold)
              out.writeByte(p.getPhoneCallAlarmRecordExt)
              out.writeByte(p.getPhoneCallAlarmFaceCaptureCnt)
              out.writeByte(p.getPhoneCallAlarmFaceCaptureIntv)

              out.writeByte(p.getSmokeAlarmSpdThreshold)
              out.writeByte(p.getSmokeAlarmRecordExt)
              out.writeByte(p.getSmokeAlarmFaceCaptureCnt)
              out.writeByte(p.getSmokeAlarmFaceCaptureIntv)

              out.writeByte(p.getInattentionSpdThreshold)
              out.writeByte(p.getInattentionRecordExt)
              out.writeByte(p.getInattentionCaptureCnt)
              out.writeByte(p.getInattentionCaptureIntv)

              out.writeByte(p.getDriverDetectUnableSpdThreshold)
              out.writeByte(p.getDriverDetectUnableRecordExt)
              out.writeByte(p.getDriverDetectUnableCaptureCnt)
              out.writeByte(p.getDriverDetectUnableCaptureIntv)

              out.writeByte(p.getDriverIdentityTrigger)

              out.writeShort(0)

            case 0xF366 =>
              val p = checkObject[TP_F366_TyrePressureMonitorParams]

              out.writeFixedLenStr(p.getTyreModel, 12)
              out.writeShort(p.getPressureUnit)
              out.writeShort(p.getNormalPressureValue)
              out.writeShort(p.getImbalanceThreshold)
              out.writeShort(p.getAirLeakSlowlyThreshold)
              out.writeShort(p.getLowPressureThreshold)
              out.writeShort(p.getHighPressureThreshold)
              out.writeShort(p.getHighTemperatureThreshold)
              out.writeShort(p.getVoltageThreshold)
              out.writeShort(p.getReportInterval)

              out.writeInt(0)
              out.writeShort(0)

            case 0xF367 =>
              val p = checkObject[TP_F367_BlindMonitorParams]
              out.writeByte(p.getRearDistanceAlarmTimeThreshold)
              out.writeByte(p.getSideDistanceAlarmTimeThreshold)

            case 0xF370 =>
              val p = checkObject[TP_F370_IntenseDrivingMonitorParams]
              out.writeInt(p.getEnableFlags)
              out.writeShort(p.getAccelerateTimeThreshold)
              out.writeShort(p.getAccelerateSpeedThreshold)

              out.writeShort(0)

              out.writeShort(p.getBrakeTimeThreshold)
              out.writeShort(p.getBrakeSpeedThreshold)

              out.writeShort(0)

              out.writeShort(p.getTurnTimeThreshold)
              out.writeShort(p.getTurnSpeedThreshold)

              out.writeShort(0)

              out.writeShort(p.getIdlingTimeThreshold)
              out.writeShort(p.getIdlingSpeedThreshold)
              out.writeShort(p.getIdlingRotationalSpeedThreshold)

              out.writeShort(p.getFlameOutTimeThreshold)
              out.writeShort(p.getFlameOutSpeedThreshold)
              out.writeShort(p.getFlameOutRotationalSpeedThreshold)

              out.writeShort(p.getNeutralTimeThreshold)
              out.writeShort(p.getNeutralSpeedThreshold)
              out.writeShort(p.getNeutralRotationalSpeedThreshold)

              out.writeShort(p.getRotationalSpeedTimeThreshold)
              out.writeShort(p.getRotationalSpeedSpeedThreshold)
              out.writeShort(p.getRotationalSpeedRpmThreshold)

              out.writeLong(0)

            case _ =>
              throw new CodecError(s"Not supported parameter(id=`$id`).")
          }
        }

        val sz = out.writerIndex() - sizeOffset - 1
        out.setByte(sizeOffset, sz)
      }
    })
  }
}
