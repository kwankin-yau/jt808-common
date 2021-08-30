/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_CTRL_8105)
public class CP_8105_TerminalCtrl implements JT808CmdParams {

    public static final int CMD__WIRELESS_UPGRADE = 1;
    public static final int CMD__CONNECT_TO_SPECIFIED_SERVER = 2;
    public static final int CMD__SHUTDOWN = 3;
    public static final int CMD__RESET = 4;
    public static final int CMD__RECOVERY = 5;
    public static final int CMD__CLOSE_COMM = 6;
    public static final int CMD__CLOSE_WIRELESS_COMM = 7;

    public void assignFrom(CP_8105_TerminalCtrl source) {
        this.cmd = source.cmd;
        this.params = source.params != null ? source.params.clone() : null;
    }

    @Override
    public CP_8105_TerminalCtrl clone() {
        CP_8105_TerminalCtrl r = new CP_8105_TerminalCtrl();
        r.assignFrom(this);
        return r;
    }


    public static interface CP_8105_Params extends Cloneable {
        CP_8105_Params clone();
    }


    private int cmd;
    private CP_8105_Params params;

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public CP_8105_Params getParams() {
        return params;
    }

    public void setParams(CP_8105_Params params) {
        this.params = params;
    }

    public static class Cmd1_WirelessUpgrade implements CP_8105_Params {

        private String url;
        private String apName;
        private String apUser;
        private String apPwd;
        private String host;
        private int tcpPort;
        private int udpPort;
        private String factoryId;
        private String hardwareVer;
        private String firmwareVer;
        private int connTimeout;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApName() {
            return apName;
        }

        public void setApName(String apName) {
            this.apName = apName;
        }

        public String getApUser() {
            return apUser;
        }

        public void setApUser(String apUser) {
            this.apUser = apUser;
        }

        public String getApPwd() {
            return apPwd;
        }

        public void setApPwd(String apPwd) {
            this.apPwd = apPwd;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
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

        public String getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(String factoryId) {
            this.factoryId = factoryId;
        }

        public String getHardwareVer() {
            return hardwareVer;
        }

        public void setHardwareVer(String hardwareVer) {
            this.hardwareVer = hardwareVer;
        }

        public String getFirmwareVer() {
            return firmwareVer;
        }

        public void setFirmwareVer(String firmwareVer) {
            this.firmwareVer = firmwareVer;
        }

        public int getConnTimeout() {
            return connTimeout;
        }

        public void setConnTimeout(int connTimeout) {
            this.connTimeout = connTimeout;
        }

        public String toCmdParams() {
            return url + ";" + apName + ";" + apUser + ";" + apPwd + ";" + host + ";"
                    + tcpPort + ";" + udpPort + ";" + factoryId + ";" + hardwareVer + ";"
                    + firmwareVer + ";" + connTimeout;
        }

        @Override
        public String toString() {
            return "Cmd1_WirelessUpgrade{" +
                    "url='" + url + '\'' +
                    ", apName='" + apName + '\'' +
                    ", apUser='" + apUser + '\'' +
                    ", apPwd='" + apPwd + '\'' +
                    ", host='" + host + '\'' +
                    ", tcpPort=" + tcpPort +
                    ", udpPort=" + udpPort +
                    ", factoryId='" + factoryId + '\'' +
                    ", hardwareVer='" + hardwareVer + '\'' +
                    ", firmwareVer='" + firmwareVer + '\'' +
                    ", connTimeout=" + connTimeout +
                    '}';
        }

        @Override
        public Cmd1_WirelessUpgrade clone() {
            try {
                return (Cmd1_WirelessUpgrade) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Cmd2_ConnSpecialServer implements CP_8105_Params {

        private int connectCtrl;
        private String authCode;
        private String apName;
        private String apUser;
        private String apPwd;
        private String host;
        private int tcpPort;
        private int udpPort;
        private int connTime;

        public int getConnectCtrl() {
            return connectCtrl;
        }

        public void setConnectCtrl(int connectCtrl) {
            this.connectCtrl = connectCtrl;
        }

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        public String getApName() {
            return apName;
        }

        public void setApName(String apName) {
            this.apName = apName;
        }

        public String getApUser() {
            return apUser;
        }

        public void setApUser(String apUser) {
            this.apUser = apUser;
        }

        public String getApPwd() {
            return apPwd;
        }

        public void setApPwd(String apPwd) {
            this.apPwd = apPwd;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
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

        public int getConnTime() {
            return connTime;
        }

        public void setConnTime(int connTime) {
            this.connTime = connTime;
        }

        public String toCmdParams() {
            return connectCtrl + ";" + authCode + ";" + apName + ";" + apUser + ";" + apPwd + ";"
                    + host + ";" + tcpPort + ";" + udpPort + ";" + connTime
                    ;
        }

        @Override
        public String toString() {
            return "Cmd2_ConnSpecialServer{" +
                    "connectCtrl=" + connectCtrl +
                    ", authCode='" + authCode + '\'' +
                    ", apName='" + apName + '\'' +
                    ", apUser='" + apUser + '\'' +
                    ", apPwd='" + apPwd + '\'' +
                    ", host='" + host + '\'' +
                    ", tcpPort=" + tcpPort +
                    ", udpPort=" + udpPort +
                    ", connTime=" + connTime +
                    '}';
        }

        @Override
        public Cmd2_ConnSpecialServer clone() {
            try {
                return (Cmd2_ConnSpecialServer) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
