/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;


import info.gratour.jt808common.protocol.msg.types.trk.Trk;

public class JT808MediaInfo implements Cloneable {

    private long mediaId;
    private byte typ;
    private byte channel;
    private byte evtCode;
    private Trk trk;

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

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public byte getEvtCode() {
        return evtCode;
    }

    public void setEvtCode(byte evtCode) {
        this.evtCode = evtCode;
    }

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    public void assignFrom(JT808MediaInfo source) {
        this.mediaId = source.mediaId;
        this.typ = source.typ;
        this.channel = source.channel;
        this.evtCode = source.evtCode;
        this.trk = source.trk != null ? source.trk.clone() : null;
    }

    @Override
    public JT808MediaInfo clone() {
        try {
            return (JT808MediaInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808MediaInfo{" +
                "mediaId=" + mediaId +
                ", typ=" + typ +
                ", channel=" + channel +
                ", evtCode=" + evtCode +
                ", trk=" + trk +
                '}';
    }
}
