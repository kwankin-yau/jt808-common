/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public class MQEventAddt_0800_MultiMediaEvent implements MQEventAddt {

    public static final int MEDIA_TYPE__IMAGE = 0;
    public static final int MEDIA_TYPE__AUDIO = 1;
    public static final int MEDIA_TYPE__VIDEO = 2;

    public static final int MEDIA_FMT__JPEG = 0;
    public static final int MEDIA_FMT__TIF = 1;
    public static final int MEDIA_FMT__MP3 = 2;
    public static final int MEDIA_FMT__WAV = 3;
    public static final int MEDIA_FMT__WMV = 4;

    public static final int EVT_TYPE__PLATFORM_CMD = 0;
    public static final int EVT_TYPE__PERIODICAL_ACT = 1;
    public static final int EVT_TYPE__ROB = 2;
    public static final int EVT_TYPE__CRASH_ROLLOVER = 3;
    public static final int EVT_TYPE__OPEN_DOOR = 4;
    public static final int EVT_TYPE__CLOSE_DOOR = 5;
    public static final int EVT_TYPE__CLOSE_DOOR_AND_OVERSPD = 6;
    public static final int EVT_TYPE__FIXED_DISTANCE = 7;

    private long mediaId;
    private byte typ;
    private byte fmt;
    private byte evtCode;
    private byte chan;


    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public byte getFmt() {
        return fmt;
    }

    public void setFmt(byte fmt) {
        this.fmt = fmt;
    }

    public byte getEvtCode() {
        return evtCode;
    }

    public void setEvtCode(byte evtCode) {
        this.evtCode = evtCode;
    }

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0800_MultiMediaEvent{" +
                "mediaId=" + mediaId +
                ", typ=" + typ +
                ", fmt=" + fmt +
                ", evtCode=" + evtCode +
                ", chan=" + chan +
                '}';
    }
}
