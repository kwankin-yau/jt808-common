/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.STORED_MEDIA_REQ_8803)
public class CP_8803_StoredMediaReq implements JT808CmdParams {

    public static final int MEDIA_TYPE__IMAGE = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__IMAGE;
    public static final int MEDIA_TYPE__AUDIO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__AUDIO;
    public static final int MEDIA_TYPE__VIDEO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__VIDEO;

    public static final int EVT_TYPE__PLATFORM_CMD = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PLATFORM_CMD;
    public static final int EVT_TYPE__PERIODICAL_ACT = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PERIODICAL_ACT;
    public static final int EVT_TYPE__ROB = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__ROB;
    public static final int EVT_TYPE__CRASH_ROLLOVER = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CRASH_ROLLOVER;

    private byte mediaType;
    private byte channelId;
    private byte event;
    private Long startTime;
    private Long endTime;
    private byte deleteFlag;

    public byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public byte getEvent() {
        return event;
    }

    public void setEvent(byte event) {
        this.event = event;
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

    public byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "CP_8803_StoredMediaReq{" +
                "mediaType=" + mediaType +
                ", channelId=" + channelId +
                ", event=" + event +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    @Override
    public CP_8803_StoredMediaReq clone() {
        try {
            return (CP_8803_StoredMediaReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
