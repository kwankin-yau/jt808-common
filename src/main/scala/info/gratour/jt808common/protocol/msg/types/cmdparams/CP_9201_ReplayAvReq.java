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

@JTMsgId(JT1078MsgConsts.REPLAY_AV_REQ_9201)
public class CP_9201_ReplayAvReq implements JT808CmdParams {

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
    private byte chan;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private byte mode;
    private Byte factor;
    private long startTm;
    private Long endTm;
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

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
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

    public long getStartTm() {
        return startTm;
    }

    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    public Long getEndTm() {
        return endTm;
    }

    public void setEndTm(Long endTm) {
        this.endTm = endTm;
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

    public String serverIp() {
        return serverIp;
    }

    public void serverIp(String value) {
        this.serverIp = value;
    }

    public int tcpPort() {
        return tcpPort;
    }

    public void tcpPort(int value) {
        this.tcpPort = value;
    }

    public int tcpPort2019() {
        return tcpPort2019;
    }

    public void tcpPort2019(int value) {
        this.tcpPort2019 = value;
    }

    public int udpPort() {
        return udpPort;
    }

    public void udpPort(int value) {
        this.udpPort = value;
    }

    public int udpPort2019() {
        return udpPort2019;
    }

    public void udpPort2019(int value) {
        this.udpPort2019 = value;
    }

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
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

    public int mode() {
        return mode;
    }

    public void mode(int value) {
        this.mode = (byte) value;
    }

    public int factorDef(){
        if (factor != null)
            return factor;
        else
            return 0;
    }

    public void factor(int value) {
        this.factor = (byte) value;
    }

    public long startTm() {
        return startTm;
    }

    public void startTm(long value) {
        this.startTm = value;
    }

    public long endTimeDef() {
        if (endTm != null)
            return endTm;
        else
            return 0L;
    }

    public void endTime(long value) {
        this.endTm = value;
    }

    public int debug() {
        return debug;
    }

    public void debug(int value) {
        this.debug = value;
    }

    public String serverId() {
        return serverId;
    }

    public void serverId(String value) {
        this.serverId = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9201_ReplayAvReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("tcpPort2019=" + tcpPort2019)
                .add("udpPort2019=" + udpPort2019)
                .add("chan=" + chan)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("mode=" + mode)
                .add("factor=" + factor)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("debug=" + debug)
                .add("serverId='" + serverId + "'")
                .toString();
    }

    @Override
    public CP_9201_ReplayAvReq clone() {
        try {
            return (CP_9201_ReplayAvReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
