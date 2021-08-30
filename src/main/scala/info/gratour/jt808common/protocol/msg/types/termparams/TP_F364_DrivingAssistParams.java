/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_F364_DrivingAssistParams {

    private byte overSpdAlarmThreshold;
    private byte alarmVoiceVolume;
    private byte activeCapturePolicy;
    private short activeTimedCaptureInterval;
    private int activeDistancedCaptureDistance;
    private byte activeCaptureCount;
    private byte activeCaptureInterval;
    private byte captureResolution;
    private byte videoResolution;
    private int alarmEnabledFlags;
    private int eventEnabledFlags;
    private byte obstacleDistance;
    private byte obstacleAlarmSpdThreshold;
    private byte obstacleAlarmRecordExt;
    private byte obstacleCaptureCount;
    private byte obstacleCaptureInterval;
    private byte changeLaneFreqAlarmTimeWindow;
    private byte changeLaneFreqAlarmTimes;
    private byte changeLaneFreqSpdThreshold;
    private byte changeLaneFreqRecordExt;
    private byte changeLaneFreqCaptureCount;
    private byte changeLaneFreqCaptureInterval;

    private byte strayPathAlarmSpdThreshold;
    private byte strayPathAlarmRecordExt;
    private byte strayPathAlarmCaptureCount;
    private byte strayPathAlarmCaptureInterval;

    private byte crashAlarmTimeThreshold;
    private byte crashAlarmSpdThreshold;
    private byte crashAlarmRecordExt;
    private byte crashAlarmCaptureCount;
    private byte crashAlarmCaptureInterval;
    private byte hitAlarmTimeThreshold;
    private byte hitAlarmSpdThreshold;
    private byte hitAlarmRecordExt;
    private byte hitAlarmCaptureCount;
    private byte hitAlarmCaptureInterval;
    private byte safeDistanceAlarmDistanceThreshold;
    private byte safeDistanceAlarmSpdThreshold;
    private byte safeDistanceAlarmRecordExt;
    private byte safeDistanceAlarmCaptureCount;
    private byte safeDistanceAlarmCaptureInterval;
    private byte roadSignCaptureCount;
    private byte roadSignCaptureInterval;

    public byte getOverSpdAlarmThreshold() {
        return overSpdAlarmThreshold;
    }

    public void setOverSpdAlarmThreshold(byte overSpdAlarmThreshold) {
        this.overSpdAlarmThreshold = overSpdAlarmThreshold;
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

    public short getActiveTimedCaptureInterval() {
        return activeTimedCaptureInterval;
    }

    public void setActiveTimedCaptureInterval(short activeTimedCaptureInterval) {
        this.activeTimedCaptureInterval = activeTimedCaptureInterval;
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

    public byte getObstacleDistance() {
        return obstacleDistance;
    }

    public void setObstacleDistance(byte obstacleDistance) {
        this.obstacleDistance = obstacleDistance;
    }

    public byte getObstacleAlarmSpdThreshold() {
        return obstacleAlarmSpdThreshold;
    }

    public void setObstacleAlarmSpdThreshold(byte obstacleAlarmSpdThreshold) {
        this.obstacleAlarmSpdThreshold = obstacleAlarmSpdThreshold;
    }

    public byte getObstacleAlarmRecordExt() {
        return obstacleAlarmRecordExt;
    }

    public void setObstacleAlarmRecordExt(byte obstacleAlarmRecordExt) {
        this.obstacleAlarmRecordExt = obstacleAlarmRecordExt;
    }

    public byte getObstacleCaptureCount() {
        return obstacleCaptureCount;
    }

    public void setObstacleCaptureCount(byte obstacleCaptureCount) {
        this.obstacleCaptureCount = obstacleCaptureCount;
    }

    public byte getObstacleCaptureInterval() {
        return obstacleCaptureInterval;
    }

    public void setObstacleCaptureInterval(byte obstacleCaptureInterval) {
        this.obstacleCaptureInterval = obstacleCaptureInterval;
    }

    public byte getChangeLaneFreqAlarmTimeWindow() {
        return changeLaneFreqAlarmTimeWindow;
    }

    public void setChangeLaneFreqAlarmTimeWindow(byte changeLaneFreqAlarmTimeWindow) {
        this.changeLaneFreqAlarmTimeWindow = changeLaneFreqAlarmTimeWindow;
    }

    public byte getChangeLaneFreqAlarmTimes() {
        return changeLaneFreqAlarmTimes;
    }

    public void setChangeLaneFreqAlarmTimes(byte changeLaneFreqAlarmTimes) {
        this.changeLaneFreqAlarmTimes = changeLaneFreqAlarmTimes;
    }

    public byte getChangeLaneFreqSpdThreshold() {
        return changeLaneFreqSpdThreshold;
    }

    public void setChangeLaneFreqSpdThreshold(byte changeLaneFreqSpdThreshold) {
        this.changeLaneFreqSpdThreshold = changeLaneFreqSpdThreshold;
    }

    public byte getChangeLaneFreqRecordExt() {
        return changeLaneFreqRecordExt;
    }

    public void setChangeLaneFreqRecordExt(byte changeLaneFreqRecordExt) {
        this.changeLaneFreqRecordExt = changeLaneFreqRecordExt;
    }

    public byte getChangeLaneFreqCaptureCount() {
        return changeLaneFreqCaptureCount;
    }

    public void setChangeLaneFreqCaptureCount(byte changeLaneFreqCaptureCount) {
        this.changeLaneFreqCaptureCount = changeLaneFreqCaptureCount;
    }

    public byte getChangeLaneFreqCaptureInterval() {
        return changeLaneFreqCaptureInterval;
    }

    public void setChangeLaneFreqCaptureInterval(byte changeLaneFreqCaptureInterval) {
        this.changeLaneFreqCaptureInterval = changeLaneFreqCaptureInterval;
    }

    public byte getStrayPathAlarmSpdThreshold() {
        return strayPathAlarmSpdThreshold;
    }

    public void setStrayPathAlarmSpdThreshold(byte strayPathAlarmSpdThreshold) {
        this.strayPathAlarmSpdThreshold = strayPathAlarmSpdThreshold;
    }

    public byte getStrayPathAlarmRecordExt() {
        return strayPathAlarmRecordExt;
    }

    public void setStrayPathAlarmRecordExt(byte strayPathAlarmRecordExt) {
        this.strayPathAlarmRecordExt = strayPathAlarmRecordExt;
    }

    public byte getStrayPathAlarmCaptureCount() {
        return strayPathAlarmCaptureCount;
    }

    public void setStrayPathAlarmCaptureCount(byte strayPathAlarmCaptureCount) {
        this.strayPathAlarmCaptureCount = strayPathAlarmCaptureCount;
    }

    public byte getStrayPathAlarmCaptureInterval() {
        return strayPathAlarmCaptureInterval;
    }

    public void setStrayPathAlarmCaptureInterval(byte strayPathAlarmCaptureInterval) {
        this.strayPathAlarmCaptureInterval = strayPathAlarmCaptureInterval;
    }

    public byte getCrashAlarmTimeThreshold() {
        return crashAlarmTimeThreshold;
    }

    public void setCrashAlarmTimeThreshold(byte crashAlarmTimeThreshold) {
        this.crashAlarmTimeThreshold = crashAlarmTimeThreshold;
    }

    public byte getCrashAlarmSpdThreshold() {
        return crashAlarmSpdThreshold;
    }

    public void setCrashAlarmSpdThreshold(byte crashAlarmSpdThreshold) {
        this.crashAlarmSpdThreshold = crashAlarmSpdThreshold;
    }

    public byte getCrashAlarmRecordExt() {
        return crashAlarmRecordExt;
    }

    public void setCrashAlarmRecordExt(byte crashAlarmRecordExt) {
        this.crashAlarmRecordExt = crashAlarmRecordExt;
    }

    public byte getCrashAlarmCaptureCount() {
        return crashAlarmCaptureCount;
    }

    public void setCrashAlarmCaptureCount(byte crashAlarmCaptureCount) {
        this.crashAlarmCaptureCount = crashAlarmCaptureCount;
    }

    public byte getCrashAlarmCaptureInterval() {
        return crashAlarmCaptureInterval;
    }

    public void setCrashAlarmCaptureInterval(byte crashAlarmCaptureInterval) {
        this.crashAlarmCaptureInterval = crashAlarmCaptureInterval;
    }

    public byte getHitAlarmTimeThreshold() {
        return hitAlarmTimeThreshold;
    }

    public void setHitAlarmTimeThreshold(byte hitAlarmTimeThreshold) {
        this.hitAlarmTimeThreshold = hitAlarmTimeThreshold;
    }

    public byte getHitAlarmSpdThreshold() {
        return hitAlarmSpdThreshold;
    }

    public void setHitAlarmSpdThreshold(byte hitAlarmSpdThreshold) {
        this.hitAlarmSpdThreshold = hitAlarmSpdThreshold;
    }

    public byte getHitAlarmRecordExt() {
        return hitAlarmRecordExt;
    }

    public void setHitAlarmRecordExt(byte hitAlarmRecordExt) {
        this.hitAlarmRecordExt = hitAlarmRecordExt;
    }

    public byte getHitAlarmCaptureCount() {
        return hitAlarmCaptureCount;
    }

    public void setHitAlarmCaptureCount(byte hitAlarmCaptureCount) {
        this.hitAlarmCaptureCount = hitAlarmCaptureCount;
    }

    public byte getHitAlarmCaptureInterval() {
        return hitAlarmCaptureInterval;
    }

    public void setHitAlarmCaptureInterval(byte hitAlarmCaptureInterval) {
        this.hitAlarmCaptureInterval = hitAlarmCaptureInterval;
    }

    public byte getSafeDistanceAlarmDistanceThreshold() {
        return safeDistanceAlarmDistanceThreshold;
    }

    public void setSafeDistanceAlarmDistanceThreshold(byte safeDistanceAlarmDistanceThreshold) {
        this.safeDistanceAlarmDistanceThreshold = safeDistanceAlarmDistanceThreshold;
    }

    public byte getSafeDistanceAlarmSpdThreshold() {
        return safeDistanceAlarmSpdThreshold;
    }

    public void setSafeDistanceAlarmSpdThreshold(byte safeDistanceAlarmSpdThreshold) {
        this.safeDistanceAlarmSpdThreshold = safeDistanceAlarmSpdThreshold;
    }

    public byte getSafeDistanceAlarmRecordExt() {
        return safeDistanceAlarmRecordExt;
    }

    public void setSafeDistanceAlarmRecordExt(byte safeDistanceAlarmRecordExt) {
        this.safeDistanceAlarmRecordExt = safeDistanceAlarmRecordExt;
    }

    public byte getSafeDistanceAlarmCaptureCount() {
        return safeDistanceAlarmCaptureCount;
    }

    public void setSafeDistanceAlarmCaptureCount(byte safeDistanceAlarmCaptureCount) {
        this.safeDistanceAlarmCaptureCount = safeDistanceAlarmCaptureCount;
    }

    public byte getSafeDistanceAlarmCaptureInterval() {
        return safeDistanceAlarmCaptureInterval;
    }

    public void setSafeDistanceAlarmCaptureInterval(byte safeDistanceAlarmCaptureInterval) {
        this.safeDistanceAlarmCaptureInterval = safeDistanceAlarmCaptureInterval;
    }

    public byte getRoadSignCaptureCount() {
        return roadSignCaptureCount;
    }

    public void setRoadSignCaptureCount(byte roadSignCaptureCount) {
        this.roadSignCaptureCount = roadSignCaptureCount;
    }

    public byte getRoadSignCaptureInterval() {
        return roadSignCaptureInterval;
    }

    public void setRoadSignCaptureInterval(byte roadSignCaptureInterval) {
        this.roadSignCaptureInterval = roadSignCaptureInterval;
    }

    @Override
    public String toString() {
        return "TP_F364_DrivingAssistParams{" +
                "overSpdAlarmThreshold=" + overSpdAlarmThreshold +
                ", alarmVoiceVolume=" + alarmVoiceVolume +
                ", activeCapturePolicy=" + activeCapturePolicy +
                ", activeTimedCaptureInterval=" + activeTimedCaptureInterval +
                ", activeDistancedCaptureDistance=" + activeDistancedCaptureDistance +
                ", activeCaptureCount=" + activeCaptureCount +
                ", activeCaptureInterval=" + activeCaptureInterval +
                ", captureResolution=" + captureResolution +
                ", videoResolution=" + videoResolution +
                ", alarmEnabledFlags=" + alarmEnabledFlags +
                ", eventEnabledFlags=" + eventEnabledFlags +
                ", obstacleDistance=" + obstacleDistance +
                ", obstacleAlarmSpdThreshold=" + obstacleAlarmSpdThreshold +
                ", obstacleAlarmRecordExt=" + obstacleAlarmRecordExt +
                ", obstacleCaptureCount=" + obstacleCaptureCount +
                ", obstacleCaptureInterval=" + obstacleCaptureInterval +
                ", changeLaneFreqAlarmTimeWindow=" + changeLaneFreqAlarmTimeWindow +
                ", changeLaneFreqAlarmTimes=" + changeLaneFreqAlarmTimes +
                ", changeLaneFreqSpdThreshold=" + changeLaneFreqSpdThreshold +
                ", changeLaneFreqRecordExt=" + changeLaneFreqRecordExt +
                ", changeLaneFreqCaptureCount=" + changeLaneFreqCaptureCount +
                ", changeLaneFreqCaptureInterval=" + changeLaneFreqCaptureInterval +
                ", strayPathAlarmSpdThreshold=" + strayPathAlarmSpdThreshold +
                ", strayPathAlarmRecordExt=" + strayPathAlarmRecordExt +
                ", strayPathAlarmCaptureCount=" + strayPathAlarmCaptureCount +
                ", strayPathAlarmCaptureInterval=" + strayPathAlarmCaptureInterval +
                ", crashAlarmTimeThreshold=" + crashAlarmTimeThreshold +
                ", crashAlarmSpdThreshold=" + crashAlarmSpdThreshold +
                ", crashAlarmRecordExt=" + crashAlarmRecordExt +
                ", crashAlarmCaptureCount=" + crashAlarmCaptureCount +
                ", crashAlarmCaptureInterval=" + crashAlarmCaptureInterval +
                ", hitAlarmTimeThreshold=" + hitAlarmTimeThreshold +
                ", hitAlarmSpdThreshold=" + hitAlarmSpdThreshold +
                ", hitAlarmRecordExt=" + hitAlarmRecordExt +
                ", hitAlarmCaptureCount=" + hitAlarmCaptureCount +
                ", hitAlarmCaptureInterval=" + hitAlarmCaptureInterval +
                ", safeDistanceAlarmDistanceThreshold=" + safeDistanceAlarmDistanceThreshold +
                ", safeDistanceAlarmSpdThreshold=" + safeDistanceAlarmSpdThreshold +
                ", safeDistanceAlarmRecordExt=" + safeDistanceAlarmRecordExt +
                ", safeDistanceAlarmCaptureCount=" + safeDistanceAlarmCaptureCount +
                ", safeDistanceAlarmCaptureInterval=" + safeDistanceAlarmCaptureInterval +
                ", roadSignCaptureCount=" + roadSignCaptureCount +
                ", roadSignCaptureInterval=" + roadSignCaptureInterval +
                '}';
    }
}
