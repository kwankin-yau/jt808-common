/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_F365_DriverBehaviorMonitorParams {

    private byte spdAlarmThreshold;
    private byte alarmVoiceVolume;
    private byte activeCapturePolicy;
    private short activeTimedCaptureIntv;
    private int activeDistancedCaptureDistance;
    private byte activeCaptureCount;
    private byte activeCaptureInterval;
    private byte captureResolution;
    private byte videoResolution;
    private int alarmEnabledFlags;
    private int eventEnabledFlags;
    private short smokeAlarmTimeThreshold;
    private short phoneCallAlarmTimeThreshold;

    private byte fatigueDrivingSpdThreshold;
    private byte fatigueDrivingRecordExt;
    private byte fatigueDrivingCaptureCnt;
    private byte fatigueDrivingCaptureIntv;

    private byte phoneCallAlarmSpdThreshold;
    private byte phoneCallAlarmRecordExt;
    private byte phoneCallAlarmFaceCaptureCnt;
    private byte phoneCallAlarmFaceCaptureIntv;

    private byte smokeAlarmSpdThreshold;
    private byte smokeAlarmRecordExt;
    private byte smokeAlarmFaceCaptureCnt;
    private byte smokeAlarmFaceCaptureIntv;

    private byte inattentionSpdThreshold;
    private byte inattentionRecordExt;
    private byte inattentionCaptureCnt;
    private byte inattentionCaptureIntv;

    private byte driverDetectUnableSpdThreshold;
    private byte driverDetectUnableRecordExt;
    private byte driverDetectUnableCaptureCnt;
    private byte driverDetectUnableCaptureIntv;

    private byte driverIdentityTrigger;

    public byte getSpdAlarmThreshold() {
        return spdAlarmThreshold;
    }

    public void setSpdAlarmThreshold(byte spdAlarmThreshold) {
        this.spdAlarmThreshold = spdAlarmThreshold;
    }

    public byte getAlarmVoiceVolume() {
        return alarmVoiceVolume;
    }

    public void setAlarmVoiceVolume(byte alarmVoiceVolume) {
        this.alarmVoiceVolume = alarmVoiceVolume;
    }

    public byte getActiveCapturePolicy() {
        return activeCapturePolicy;
    }

    public void setActiveCapturePolicy(byte activeCapturePolicy) {
        this.activeCapturePolicy = activeCapturePolicy;
    }

    public short getActiveTimedCaptureIntv() {
        return activeTimedCaptureIntv;
    }

    public void setActiveTimedCaptureIntv(short activeTimedCaptureIntv) {
        this.activeTimedCaptureIntv = activeTimedCaptureIntv;
    }

    public int getActiveDistancedCaptureDistance() {
        return activeDistancedCaptureDistance;
    }

    public void setActiveDistancedCaptureDistance(int activeDistancedCaptureDistance) {
        this.activeDistancedCaptureDistance = activeDistancedCaptureDistance;
    }

    public byte getActiveCaptureCount() {
        return activeCaptureCount;
    }

    public void setActiveCaptureCount(byte activeCaptureCount) {
        this.activeCaptureCount = activeCaptureCount;
    }

    public byte getActiveCaptureInterval() {
        return activeCaptureInterval;
    }

    public void setActiveCaptureInterval(byte activeCaptureInterval) {
        this.activeCaptureInterval = activeCaptureInterval;
    }

    public byte getCaptureResolution() {
        return captureResolution;
    }

    public void setCaptureResolution(byte captureResolution) {
        this.captureResolution = captureResolution;
    }

    public byte getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(byte videoResolution) {
        this.videoResolution = videoResolution;
    }

    public int getAlarmEnabledFlags() {
        return alarmEnabledFlags;
    }

    public void setAlarmEnabledFlags(int alarmEnabledFlags) {
        this.alarmEnabledFlags = alarmEnabledFlags;
    }

    public int getEventEnabledFlags() {
        return eventEnabledFlags;
    }

    public void setEventEnabledFlags(int eventEnabledFlags) {
        this.eventEnabledFlags = eventEnabledFlags;
    }

    public short getSmokeAlarmTimeThreshold() {
        return smokeAlarmTimeThreshold;
    }

    public void setSmokeAlarmTimeThreshold(short smokeAlarmTimeThreshold) {
        this.smokeAlarmTimeThreshold = smokeAlarmTimeThreshold;
    }

    public short getPhoneCallAlarmTimeThreshold() {
        return phoneCallAlarmTimeThreshold;
    }

    public void setPhoneCallAlarmTimeThreshold(short phoneCallAlarmTimeThreshold) {
        this.phoneCallAlarmTimeThreshold = phoneCallAlarmTimeThreshold;
    }

    public byte getFatigueDrivingSpdThreshold() {
        return fatigueDrivingSpdThreshold;
    }

    public void setFatigueDrivingSpdThreshold(byte fatigueDrivingSpdThreshold) {
        this.fatigueDrivingSpdThreshold = fatigueDrivingSpdThreshold;
    }

    public byte getFatigueDrivingRecordExt() {
        return fatigueDrivingRecordExt;
    }

    public void setFatigueDrivingRecordExt(byte fatigueDrivingRecordExt) {
        this.fatigueDrivingRecordExt = fatigueDrivingRecordExt;
    }

    public byte getFatigueDrivingCaptureCnt() {
        return fatigueDrivingCaptureCnt;
    }

    public void setFatigueDrivingCaptureCnt(byte fatigueDrivingCaptureCnt) {
        this.fatigueDrivingCaptureCnt = fatigueDrivingCaptureCnt;
    }

    public byte getFatigueDrivingCaptureIntv() {
        return fatigueDrivingCaptureIntv;
    }

    public void setFatigueDrivingCaptureIntv(byte fatigueDrivingCaptureIntv) {
        this.fatigueDrivingCaptureIntv = fatigueDrivingCaptureIntv;
    }

    public byte getPhoneCallAlarmSpdThreshold() {
        return phoneCallAlarmSpdThreshold;
    }

    public void setPhoneCallAlarmSpdThreshold(byte phoneCallAlarmSpdThreshold) {
        this.phoneCallAlarmSpdThreshold = phoneCallAlarmSpdThreshold;
    }

    public byte getPhoneCallAlarmRecordExt() {
        return phoneCallAlarmRecordExt;
    }

    public void setPhoneCallAlarmRecordExt(byte phoneCallAlarmRecordExt) {
        this.phoneCallAlarmRecordExt = phoneCallAlarmRecordExt;
    }

    public byte getPhoneCallAlarmFaceCaptureCnt() {
        return phoneCallAlarmFaceCaptureCnt;
    }

    public void setPhoneCallAlarmFaceCaptureCnt(byte phoneCallAlarmFaceCaptureCnt) {
        this.phoneCallAlarmFaceCaptureCnt = phoneCallAlarmFaceCaptureCnt;
    }

    public byte getPhoneCallAlarmFaceCaptureIntv() {
        return phoneCallAlarmFaceCaptureIntv;
    }

    public void setPhoneCallAlarmFaceCaptureIntv(byte phoneCallAlarmFaceCaptureIntv) {
        this.phoneCallAlarmFaceCaptureIntv = phoneCallAlarmFaceCaptureIntv;
    }

    public byte getSmokeAlarmSpdThreshold() {
        return smokeAlarmSpdThreshold;
    }

    public void setSmokeAlarmSpdThreshold(byte smokeAlarmSpdThreshold) {
        this.smokeAlarmSpdThreshold = smokeAlarmSpdThreshold;
    }

    public byte getSmokeAlarmRecordExt() {
        return smokeAlarmRecordExt;
    }

    public void setSmokeAlarmRecordExt(byte smokeAlarmRecordExt) {
        this.smokeAlarmRecordExt = smokeAlarmRecordExt;
    }

    public byte getSmokeAlarmFaceCaptureCnt() {
        return smokeAlarmFaceCaptureCnt;
    }

    public void setSmokeAlarmFaceCaptureCnt(byte smokeAlarmFaceCaptureCnt) {
        this.smokeAlarmFaceCaptureCnt = smokeAlarmFaceCaptureCnt;
    }

    public byte getSmokeAlarmFaceCaptureIntv() {
        return smokeAlarmFaceCaptureIntv;
    }

    public void setSmokeAlarmFaceCaptureIntv(byte smokeAlarmFaceCaptureIntv) {
        this.smokeAlarmFaceCaptureIntv = smokeAlarmFaceCaptureIntv;
    }

    public byte getInattentionSpdThreshold() {
        return inattentionSpdThreshold;
    }

    public void setInattentionSpdThreshold(byte inattentionSpdThreshold) {
        this.inattentionSpdThreshold = inattentionSpdThreshold;
    }

    public byte getInattentionRecordExt() {
        return inattentionRecordExt;
    }

    public void setInattentionRecordExt(byte inattentionRecordExt) {
        this.inattentionRecordExt = inattentionRecordExt;
    }

    public byte getInattentionCaptureCnt() {
        return inattentionCaptureCnt;
    }

    public void setInattentionCaptureCnt(byte inattentionCaptureCnt) {
        this.inattentionCaptureCnt = inattentionCaptureCnt;
    }

    public byte getInattentionCaptureIntv() {
        return inattentionCaptureIntv;
    }

    public void setInattentionCaptureIntv(byte inattentionCaptureIntv) {
        this.inattentionCaptureIntv = inattentionCaptureIntv;
    }

    public byte getDriverDetectUnableSpdThreshold() {
        return driverDetectUnableSpdThreshold;
    }

    public void setDriverDetectUnableSpdThreshold(byte driverDetectUnableSpdThreshold) {
        this.driverDetectUnableSpdThreshold = driverDetectUnableSpdThreshold;
    }

    public byte getDriverDetectUnableRecordExt() {
        return driverDetectUnableRecordExt;
    }

    public void setDriverDetectUnableRecordExt(byte driverDetectUnableRecordExt) {
        this.driverDetectUnableRecordExt = driverDetectUnableRecordExt;
    }

    public byte getDriverDetectUnableCaptureCnt() {
        return driverDetectUnableCaptureCnt;
    }

    public void setDriverDetectUnableCaptureCnt(byte driverDetectUnableCaptureCnt) {
        this.driverDetectUnableCaptureCnt = driverDetectUnableCaptureCnt;
    }

    public byte getDriverDetectUnableCaptureIntv() {
        return driverDetectUnableCaptureIntv;
    }

    public void setDriverDetectUnableCaptureIntv(byte driverDetectUnableCaptureIntv) {
        this.driverDetectUnableCaptureIntv = driverDetectUnableCaptureIntv;
    }

    public byte getDriverIdentityTrigger() {
        return driverIdentityTrigger;
    }

    public void setDriverIdentityTrigger(byte driverIdentityTrigger) {
        this.driverIdentityTrigger = driverIdentityTrigger;
    }

    @Override
    public String toString() {
        return "TP_F365_DriverBehaviorMonitorParams{" +
                "spdAlarmThreshold=" + spdAlarmThreshold +
                ", alarmVoiceVolume=" + alarmVoiceVolume +
                ", activeCapturePolicy=" + activeCapturePolicy +
                ", activeTimedCaptureIntv=" + activeTimedCaptureIntv +
                ", activeDistancedCaptureDistance=" + activeDistancedCaptureDistance +
                ", activeCaptureCount=" + activeCaptureCount +
                ", activeCaptureInterval=" + activeCaptureInterval +
                ", captureResolution=" + captureResolution +
                ", videoResolution=" + videoResolution +
                ", alarmEnabledFlags=" + alarmEnabledFlags +
                ", eventEnabledFlags=" + eventEnabledFlags +
                ", smokeAlarmTimeThreshold=" + smokeAlarmTimeThreshold +
                ", phoneCallAlarmTimeThreshold=" + phoneCallAlarmTimeThreshold +
                ", fatigueDrivingSpdThreshold=" + fatigueDrivingSpdThreshold +
                ", fatigueDrivingRecordExt=" + fatigueDrivingRecordExt +
                ", fatigueDrivingCaptureCnt=" + fatigueDrivingCaptureCnt +
                ", fatigueDrivingCaptureIntv=" + fatigueDrivingCaptureIntv +
                ", phoneCallAlarmSpdThreshold=" + phoneCallAlarmSpdThreshold +
                ", phoneCallAlarmRecordExt=" + phoneCallAlarmRecordExt +
                ", phoneCallAlarmFaceCaptureCnt=" + phoneCallAlarmFaceCaptureCnt +
                ", phoneCallAlarmFaceCaptureIntv=" + phoneCallAlarmFaceCaptureIntv +
                ", smokeAlarmSpdThreshold=" + smokeAlarmSpdThreshold +
                ", smokeAlarmRecordExt=" + smokeAlarmRecordExt +
                ", smokeAlarmFaceCaptureCnt=" + smokeAlarmFaceCaptureCnt +
                ", smokeAlarmFaceCaptureIntv=" + smokeAlarmFaceCaptureIntv +
                ", inattentionSpdThreshold=" + inattentionSpdThreshold +
                ", inattentionRecordExt=" + inattentionRecordExt +
                ", inattentionCaptureCnt=" + inattentionCaptureCnt +
                ", inattentionCaptureIntv=" + inattentionCaptureIntv +
                ", driverDetectUnableSpdThreshold=" + driverDetectUnableSpdThreshold +
                ", driverDetectUnableRecordExt=" + driverDetectUnableRecordExt +
                ", driverDetectUnableCaptureCnt=" + driverDetectUnableCaptureCnt +
                ", driverDetectUnableCaptureIntv=" + driverDetectUnableCaptureIntv +
                ", driverIdentityTrigger=" + driverIdentityTrigger +
                '}';
    }
}
