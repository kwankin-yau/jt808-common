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

    @Override
    public String toString() {
        return "CP_9208_AlmAddtUploadReq{" +
                "serverIp='" + serverIp + '\'' +
                ", tcpPort=" + tcpPort +
                ", udpPort=" + udpPort +
                ", almNo='" + almNo + '\'' +
                ", almId=" + almId +
                ", almTm1=" + almTm1 +
                '}';
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
