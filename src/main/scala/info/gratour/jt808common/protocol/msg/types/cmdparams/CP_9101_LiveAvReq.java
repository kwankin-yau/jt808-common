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

@JTMsgId(JT1078MsgConsts.LIVE_AV_REQ_9101)
public class CP_9101_LiveAvReq implements JT808CmdParams {

    public static final byte DATA_TYPE__AV = 0;
    public static final byte DATA_TYPE__VIDEO = 1;
    public static final byte DATA_TYPE__TALK = 2;
    public static final byte DATA_TYPE__LISTEN = 3;
    public static final byte DATA_TYPE__BROADCAST = 4;
    public static final byte DATA_TYPE__PASS_THOUGH = 5;

    public static final byte CODE_STREAM__PRIMARY = 0;
    public static final byte CODE_STREAM__SUB = 1;

    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private int tcpPort2019;
    private int udpPort2019;
    private byte chan;
    private Byte dataTyp;
    private Byte codeStrm;
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

    public Byte getDataTyp() {
        return dataTyp;
    }

    public void setDataTyp(Byte dataTyp) {
        this.dataTyp = dataTyp;
    }

    public Byte getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(Byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    public byte getDataTypeDef() {
        if (dataTyp != null)
            return dataTyp;
        else
            return DATA_TYPE__AV;
    }

    public byte getCodeStreamDef() {
        if (codeStrm != null)
            return codeStrm;
        else
            return CODE_STREAM__PRIMARY;
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

    public int dataTypDef() {
        if (dataTyp != null)
            return dataTyp;
        else
            return DATA_TYPE__AV;
    }

    public void dataTyp(int value) {
        this.dataTyp = (byte) value;
    }

    public int codeStrmDef() {
        if (codeStrm != null)
            return codeStrm;
        else
            return CODE_STREAM__PRIMARY;
    }

    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    public int debug() {
        return debug;
    }

    public void debug(int value) {
        this.debug = debug;
    }

    public String serverId() {
        return serverId;
    }

    public void serverId(String value) {
        this.serverId = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9101_LiveAvReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("tcpPort2019=" + tcpPort2019)
                .add("udpPort2019=" + udpPort2019)
                .add("chan=" + chan)
                .add("dataTyp=" + dataTyp)
                .add("codeStrm=" + codeStrm)
                .add("debug=" + debug)
                .add("serverId='" + serverId + "'")
                .toString();
    }

    @Override
    public CP_9101_LiveAvReq clone() {
        try {
            return (CP_9101_LiveAvReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
