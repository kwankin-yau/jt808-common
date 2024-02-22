/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.protocol.msg.types.trk.Trk;

import java.util.Arrays;
import java.util.StringJoiner;

public class MQEventAddt_0801_MultiMediaData implements MQEventAddt {

    public static final int MEDIA_TYPE__IMAGE = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__IMAGE;
    public static final int MEDIA_TYPE__AUDIO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__AUDIO;
    public static final int MEDIA_TYPE__VIDEO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__VIDEO;

    public static final int MEDIA_FMT__JPEG = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__JPEG;
    public static final int MEDIA_FMT__TIF = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__TIF;
    public static final int MEDIA_FMT__MP3 = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__MP3;
    public static final int MEDIA_FMT__WAV = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__WAV;
    public static final int MEDIA_FMT__WMV = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__WMV;

    public static final int EVT_TYPE__PLATFORM_CMD = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PLATFORM_CMD;
    public static final int EVT_TYPE__PERIODICAL_ACT = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PERIODICAL_ACT;
    public static final int EVT_TYPE__ROB = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__ROB;
    public static final int EVT_TYPE__CRASH_ROLLOVER = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CRASH_ROLLOVER;
    public static final int EVT_TYPE__OPEN_DOOR = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__OPEN_DOOR;
    public static final int EVT_TYPE__CLOSE_DOOR = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CLOSE_DOOR;


    private long mediaId;
    private byte typ;
    private byte fmt;
    private byte evtCode;
    private byte chan;
    private Trk trk;
    private byte[] data;

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

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int dataLength() {
        if (data != null)
            return data.length;
        else
            return 0;
    }

    public long mediaId() {
        return mediaId;
    }

    public void mediaId(long value) {
        this.mediaId = value;
    }

    public int typ() {
        return typ;
    }

    public void typ(int value) {
        this.typ = (byte) value;
    }

    public int fmt() {
        return fmt;
    }

    public void fmt(int value) {
        this.fmt = (byte) value;
    }

    public int evtCode() {
        return evtCode;
    }

    public void evtCode(int value) {
        this.evtCode = (byte) value;
    }

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public Trk trk() {
        return trk;
    }

    public void trk(Trk value) {
        this.trk = value;
    }

    public byte[] data() {
        return data;
    }
    public void data(byte[] value) {
        this.data = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MQEventAddt_0801_MultiMediaData.class.getSimpleName() + "[", "]")
                .add("mediaId=" + mediaId)
                .add("typ=" + typ)
                .add("fmt=" + fmt)
                .add("evtCode=" + evtCode)
                .add("chan=" + chan)
                .add("trk=" + trk)
                .add("data.sz=" + (data != null ? data.length : 0))
                .toString();
    }
}
