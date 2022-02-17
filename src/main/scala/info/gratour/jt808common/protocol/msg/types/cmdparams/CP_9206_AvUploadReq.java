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

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_REQ_9206)
public class CP_9206_AvUploadReq implements JT808CmdParams {

    public static final int MEDIA_TYPE__AV = 0;
    public static final int MEDIA_TYPE__A = 1;
    public static final int MEDIA_TYPE__V = 2;
    public static final int MEDIA_TYPE__A_OR_V = 3;

    public static final int CODE_STREAM__ALL = 0;
    public static final int CODE_STREAM__PRIMARY = 1;
    public static final int CODE_STREAM__SUB = 2;

    public static final int STORAGE_TYPE__ALL = 0;
    public static final int STORAGE_TYPE__PRIMARY = 1;
    public static final int STORAGE_TYPE__BACKUP = 2;

    private String ftpHost;
    private int ftpPort;
    private String ftpUser;
    private String ftpPwd;
    private String uploadPath;


    private byte chan;
    private long startTm;
    private long endTm;
    private Integer almFilter808;
    private Integer almFilter1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private byte when;

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPwd() {
        return ftpPwd;
    }

    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
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

    public Integer getAlmFilter808() {
        return almFilter808;
    }

    public void setAlmFilter808(Integer almFilter808) {
        this.almFilter808 = almFilter808;
    }

    public int almSt808() {
        if (almFilter808 != null)
            return almFilter808;
        else
            return 0;
    }

    public Integer getAlmFilter1078() {
        return almFilter1078;
    }

    public void setAlmFilter1078(Integer almFilter1078) {
        this.almFilter1078 = almFilter1078;
    }

    public int almSt1078() {
        if (almFilter1078 != null)
            return almFilter1078;
        else
            return 0;
    }

    public long almState() {
        int st808 = almSt808();

        long r = almSt1078();
        r <<= 32;
        r |= st808;

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

    public byte getWhen() {
        return when;
    }

    public void setWhen(byte when) {
        this.when = when;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9206_AvUploadReq.class.getSimpleName() + "[", "]")
                .add("ftpHost='" + ftpHost + "'")
                .add("ftpPort=" + ftpPort)
                .add("ftpUser='" + ftpUser + "'")
                .add("ftpPwd='" + ftpPwd + "'")
                .add("uploadPath='" + uploadPath + "'")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almFilter808=" + almFilter808)
                .add("almFilter1078=" + almFilter1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("when=" + when)
                .toString();
    }

    @Override
    public CP_9206_AvUploadReq clone() {
        try {
            return (CP_9206_AvUploadReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
