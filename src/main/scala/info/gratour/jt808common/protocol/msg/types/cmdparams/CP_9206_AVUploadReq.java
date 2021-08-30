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

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_REQ_9206)
public class CP_9206_AVUploadReq implements JT808CmdParams {

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


    private byte channel;
    private long startTime;
    private long endTime;
    private Integer alarmStateFilter808;
    private Integer alarmStateFilter1078;
    private byte mediaType;
    private byte codeStream;
    private byte storageType;
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

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Integer getAlarmStateFilter808() {
        return alarmStateFilter808;
    }

    public void setAlarmStateFilter808(Integer alarmStateFilter808) {
        this.alarmStateFilter808 = alarmStateFilter808;
    }

    public int almSt808() {
        if (alarmStateFilter808 != null)
            return alarmStateFilter808;
        else
            return 0;
    }

    public Integer getAlarmStateFilter1078() {
        return alarmStateFilter1078;
    }

    public void setAlarmStateFilter1078(Integer alarmStateFilter1078) {
        this.alarmStateFilter1078 = alarmStateFilter1078;
    }

    public int almSt1078() {
        if (alarmStateFilter1078 != null)
            return alarmStateFilter1078;
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

    public byte getWhen() {
        return when;
    }

    public void setWhen(byte when) {
        this.when = when;
    }

    @Override
    public String toString() {
        return "CP_9206_AVUploadReq{" +
                "ftpHost='" + ftpHost + '\'' +
                ", ftpPort=" + ftpPort +
                ", ftpUser='" + ftpUser + '\'' +
                ", ftpPwd='" + ftpPwd + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", channel=" + channel +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", alarmStateFilter808=" + alarmStateFilter808 +
                ", alarmStateFilter1078=" + alarmStateFilter1078 +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                ", when=" + when +
                '}';
    }

    @Override
    public CP_9206_AVUploadReq clone() {
        try {
            return (CP_9206_AVUploadReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
