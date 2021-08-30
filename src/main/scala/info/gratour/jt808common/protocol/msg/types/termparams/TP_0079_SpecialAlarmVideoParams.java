/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_0079_SpecialAlarmVideoParams {
    private byte videoStoreQuota;
    private short recordDuration;
    private byte tagTime;

    public byte getVideoStoreQuota() {
        return videoStoreQuota;
    }

    public void setVideoStoreQuota(byte videoStoreQuota) {
        this.videoStoreQuota = videoStoreQuota;
    }

    public short getRecordDuration() {
        return recordDuration;
    }

    public void setRecordDuration(short recordDuration) {
        this.recordDuration = recordDuration;
    }

    public byte getTagTime() {
        return tagTime;
    }

    public void setTagTime(byte tagTime) {
        this.tagTime = tagTime;
    }

    @Override
    public String toString() {
        return "TP_0079_SpecialAlarmVideoParams{" +
                "videoStoreQuota=" + videoStoreQuota +
                ", recordDuration=" + recordDuration +
                ", tagTime=" + tagTime +
                '}';
    }
}
