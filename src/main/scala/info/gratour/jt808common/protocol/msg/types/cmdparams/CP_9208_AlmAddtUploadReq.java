/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208)
public class CP_9208_AlmAddtUploadReq implements JT808CmdParams {

    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private String almNo;
    private String almId;
    private long almTm1;

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

    public String getAlmNo() {
        return almNo;
    }

    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    public String getAlmId() {
        return almId;
    }

    public void setAlmId(String almId) {
        this.almId = almId;
    }

    public long getAlmTm1() {
        return almTm1;
    }

    public void setAlmTm1(long almTm1) {
        this.almTm1 = almTm1;
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

    public int udpPort() {
        return udpPort;
    }

    public void udpPort(int value) {
        this.udpPort = value;
    }

    public String almNo() {
        return almNo;
    }

    public void almNo(String value) {
        this.almNo = value;
    }

    public String almId() {
        return almId;
    }

    public void almId(String value) {
        this.almId = value;
    }

    public long almTm1() {
        return almTm1;
    }

    public void almTm1(long value) {
        this.almTm1 = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9208_AlmAddtUploadReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("almNo='" + almNo + "'")
                .add("almId='" + almId + "'")
                .add("almTm1=" + almTm1)
                .toString();
    }

    @Override
    public CP_9208_AlmAddtUploadReq clone() {
        try {
            return (CP_9208_AlmAddtUploadReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
