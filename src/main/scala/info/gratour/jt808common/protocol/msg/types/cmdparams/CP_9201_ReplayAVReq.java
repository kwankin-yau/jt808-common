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

@JTMsgId(JT1078MsgConsts.REPLAY_AV_REQ_9201)
public class CP_9201_ReplayAVReq implements JT808CmdParams {

    public static final int MEDIA_TYPE__AV = 0;
    public static final int MEDIA_TYPE__AUDIO = 1;
    public static final int MEDIA_TYPE__VIDEO = 2;
    public static final int MEDIA_TYPE__A_OR_V = 3;

    public static final byte CODE_STREAM__ALL = 0;
    public static final byte CODE_STREAM__PRIMARY = 1;
    public static final byte CODE_STREAM__SUB = 2;

    public static final byte STORAGE_TYPE__ALL = 0;
    public static final byte STORAGE_TYPE__PRIMARY = 1;
    public static final byte STORAGE_TYPE__SECONDARY = 2;

    public static final byte MODE__NORMAL = 0;
    public static final byte MODE__FAST_FORWARD = 1;
    public static final byte MODE__KEY_FRAME_BACKWARD = 2;
    public static final byte MODE__KEY_FRAME_PLAY = 3;
    public static final byte MODE__UPLOAD_SINGLE_FRAME = 4;



    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private int tcpPort2019;
    private int udpPort2019;
    private byte channel;
    private byte mediaType;
    private byte codeStream;
    private byte storageType;
    private byte mode;
    private Byte factor;
    private long startTime;
    private Long endTime;
    private int debug;
    private String serverId;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public int getTcpPort2019() {
        return tcpPort2019;
    }

    public void setTcpPort2019(int tcpPort2019) {
        this.tcpPort2019 = tcpPort2019;
    }

    public int getUdpPort2019() {
        return udpPort2019;
    }

    public void setUdpPort2019(int udpPort2019) {
        this.udpPort2019 = udpPort2019;
    }

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
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

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public Byte getFactor() {
        return factor;
    }

    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    public byte factorDef(){
        if (factor != null)
            return factor;
        else
            return 0;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public long endTimeDef() {
        if (endTime != null)
            return endTime;
        else
            return 0;
    }

    public int getDebug() {
        return debug;
    }

    public void setDebug(int debug) {
        this.debug = debug;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "CP_9201_ReplayAVReq{" +
                "serverIp='" + serverIp + '\'' +
                ", tcpPort=" + tcpPort +
                ", udpPort=" + udpPort +
                ", tcpPort2019=" + tcpPort2019 +
                ", udpPort2019=" + udpPort2019 +
                ", channel=" + channel +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                ", mode=" + mode +
                ", factor=" + factor +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", debug=" + debug +
                ", serverId='" + serverId + '\'' +
                '}';
    }

    @Override
    public CP_9201_ReplayAVReq clone() {
        try {
            return (CP_9201_ReplayAVReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
