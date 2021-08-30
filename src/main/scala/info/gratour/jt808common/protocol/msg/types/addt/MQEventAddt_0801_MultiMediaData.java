/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.protocol.msg.types.trk.Trk;

public class MQEventAddt_0801_MultiMediaData implements MQEventAddt {

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

    @Override
    public String toString() {
        return "MQEventAddt_0801_MultiMediaData{" +
                "mediaId=" + mediaId +
                ", typ=" + typ +
                ", fmt=" + fmt +
                ", evtCode=" + evtCode +
                ", chan=" + chan +
                ", trk=" + trk +
                ", data.size=" + String.valueOf(dataLength()) +
                '}';
    }
}
