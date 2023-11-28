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

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.QRY_AV_RES_9205)
public class CP_9205_QryAvRes implements JT808CmdParams {

    private byte chan;
    private Long startTm;
    private Long endTm;
    private Integer almFilter808;
    private Integer almFilter1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public Long getStartTm() {
        return startTm;
    }

    public void setStartTm(Long startTm) {
        this.startTm = startTm;
    }

    public Long getEndTm() {
        return endTm;
    }

    public void setEndTm(Long endTm) {
        this.endTm = endTm;
    }

    public Integer getAlmFilter808() {
        return almFilter808;
    }

    public void setAlmFilter808(Integer almFilter808) {
        this.almFilter808 = almFilter808;
    }

    public Integer getAlmFilter1078() {
        return almFilter1078;
    }

    public void setAlmFilter1078(Integer almFilter1078) {
        this.almFilter1078 = almFilter1078;
    }

    public void setAlarmState(long almState) {
        this.almFilter808 = (int) almState;
        almState >>>= 32;
        this.almFilter1078 = (int) almState;
    }

    public byte getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(byte mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public byte getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    public byte getStgTyp() {
        return stgTyp;
    }

    public void setStgTyp(byte stgTyp) {
        this.stgTyp = stgTyp;
    }

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public int almFilter808() {
        return almFilter808 != null ? almFilter808 : 0;
    }

    public void almFilter808(int value) {
        this.almFilter808 = value;
    }

    public int almFilter1078() {
        return almFilter1078 != null ? almFilter1078 : 0;
    }

    public void almFilter1078(int value) {
        this.almFilter1078 = value;
    }

    public long almFilterLong() {
        long r = almFilter1078;
        r <<= 32;
        r |= almFilter808;

        return r;
    }

    public void almFilterLong(long value) {
        long t = value >>> 32;
        this.almFilter1078 = (int) t;
        this.almFilter808 = (int) (value & 0xFFFF_FFFFL);
    }

    public int mediaTyp() {
        return mediaTyp;
    }

    public void mediaTyp(int value) {
        this.mediaTyp = (byte) value;
    }

    public int codeStrm() {
        return codeStrm;
    }

    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    public int stgTyp() {
        return stgTyp;
    }

    public void stgTyp(int value) {
        this.stgTyp = (byte) value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9205_QryAvRes.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almFilter808=" + almFilter808)
                .add("almFilter1078=" + almFilter1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .toString();
    }

    @Override
    public CP_9205_QryAvRes clone() {
        try {
            return (CP_9205_QryAvRes) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
