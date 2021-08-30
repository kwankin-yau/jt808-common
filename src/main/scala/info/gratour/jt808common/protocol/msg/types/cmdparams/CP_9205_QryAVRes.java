/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.QRY_AV_RES_9205)
public class CP_9205_QryAVRes implements JT808CmdParams {

    private byte channel;
    private Long startTime;
    private Long endTime;
    private Integer alarmStateFilter808;
    private Integer alarmStateFilter1078;
    private byte mediaType;
    private byte codeStream;
    private byte storageType;

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getAlarmStateFilter808() {
        return alarmStateFilter808;
    }

    public void setAlarmStateFilter808(Integer alarmStateFilter808) {
        this.alarmStateFilter808 = alarmStateFilter808;
    }

    public Integer getAlarmStateFilter1078() {
        return alarmStateFilter1078;
    }

    public void setAlarmStateFilter1078(Integer alarmStateFilter1078) {
        this.alarmStateFilter1078 = alarmStateFilter1078;
    }

    public void setAlarmState(long almState) {
        this.alarmStateFilter808 = (int) almState;
        almState >>>= 32;
        this.alarmStateFilter1078 = (int) almState;
    }

    public byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    public byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(byte codeStream) {
        this.codeStream = codeStream;
    }

    public byte getStorageType() {
        return storageType;
    }

    public void setStorageType(byte storageType) {
        this.storageType = storageType;
    }

    @Override
    public String toString() {
        return "CP_9205_QryAVRes{" +
                "channel=" + channel +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", alarmStateFilter808=" + alarmStateFilter808 +
                ", alarmStateFilter1078=" + alarmStateFilter1078 +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                '}';
    }

    @Override
    public CP_9205_QryAVRes clone() {
        try {
            return (CP_9205_QryAVRes) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
