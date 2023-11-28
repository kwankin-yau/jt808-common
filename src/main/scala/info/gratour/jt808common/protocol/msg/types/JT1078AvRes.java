/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.StringJoiner;

public class JT1078AvRes {

    public static final int MEDIA_TYPE__AV = 0;
    public static final int MEDIA_TYPE__A = 1;
    public static final int MEDIA_TYPE__V = 2;
    public static final int MEDIA_TYPE__A_OR_V = 3;

    public static final int CODE_STREAM__ALL = 0;
    public static final int CODE_STREAM__PRIMARY = 1;
    public static final int CODE_STREAM__SUB = 2;

    public static final int STORAGE__ALL = 0;
    public static final int STORAGE__PRIMARY = 1;
    public static final int STORAGE__BACKUP = 2;

    private byte chan;
    private long startTm;
    private long endTm;
    private int almSt808;
    private int almSt1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private long fileSz;
    private String path;
    private String fileName;

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public long startTm() {
        return startTm;
    }

    public void startTm(long value) {
        this.startTm = value;
    }

    public long endTm() {
        return this.endTm;
    }

    public void endTm(long value) {
        this.endTm = value;
    }

    public int almStat808() {
        return almSt808;
    }

    public void almState808(int value) {
        this.almSt808 = value;
    }

    public int almState1078() {
        return almSt1078;
    }

    public void almState1078(int value) {
        this.almSt1078 = value;
    }

    public int mediaTyp() {
        return mediaTyp;
    }

    public void mediaTyp(int value) {
        this.mediaTyp = (byte) value;
    }

    public int codeStrm() {
        return this.codeStrm;
    }

    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    public int stgTyp() {
        return this.stgTyp;
    }

    public void stgTyp(int value) {
        this.stgTyp = (byte) value;
    }

    public long fileSz() {
        return fileSz;
    }

    public void fileSz(long value) {
        this.fileSz = value;
    }

    public String path() {
        return path;
    }

    public void path(String path) {
        this.path = path;
    }

    public String fileName() {
        return fileName;
    }

    public void fileName(String value) {
        this.fileName = value;
    }


    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public long getStartTm() {
        return startTm;
    }

    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    public long getEndTm() {
        return endTm;
    }

    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    public int getAlmSt808() {
        return almSt808;
    }

    public void setAlmSt808(int almSt808) {
        this.almSt808 = almSt808;
    }

    public int getAlmSt1078() {
        return almSt1078;
    }

    public void setAlmSt1078(int almSt1078) {
        this.almSt1078 = almSt1078;
    }

    public long almSt() {
        long r = almSt1078;
        r <<= 32;
        r |= almSt808;
        return r;
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

    public long getFileSz() {
        return fileSz;
    }

    public void setFileSz(long fileSz) {
        this.fileSz = fileSz;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void assignFrom(JT1078AvRes source) {
        this.chan = source.chan;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.almSt808 = source.almSt808;
        this.almSt1078 = source.almSt1078;
        this.mediaTyp = source.mediaTyp;
        this.codeStrm = source.codeStrm;
        this.stgTyp = source.stgTyp;
        this.fileSz = source.fileSz;
        this.path = source.path;
        this.fileName = source.fileName;
    }

    @Override
    public JT1078AvRes clone() {
        JT1078AvRes r = new JT1078AvRes();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AvRes.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almSt808=" + almSt808)
                .add("almSt1078=" + almSt1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("fileSz=" + fileSz)
                .add("path='" + path + "'")
                .add("fileName='" + fileName + "'")
                .toString();
    }
}
