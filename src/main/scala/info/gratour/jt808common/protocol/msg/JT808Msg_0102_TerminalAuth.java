/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_AUTH_0102)
public class JT808Msg_0102_TerminalAuth extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_AUTH_0102;

    public JT808Msg_0102_TerminalAuth() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0102_TerminalAuth(JT808FrameHeader header) {
        super(header);
    }

    private String authCode;
    private String imei;
    private String softwareVer;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     *
     * @return imei
     * @since REV_2019
     */
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     *
     * @return software version
     * @since REV_2019
     */
    public String getSoftwareVer() {
        return softwareVer;
    }

    public void setSoftwareVer(String softwareVer) {
        this.softwareVer = softwareVer;
    }

    @Override
    public String toString() {
        return "JT808Msg_0102_TerminalAuth{" +
                "authCode='" + authCode + '\'' +
                ", imei='" + imei + '\'' +
                ", softwareVer='" + softwareVer + '\'' +
                '}';
    }
}
