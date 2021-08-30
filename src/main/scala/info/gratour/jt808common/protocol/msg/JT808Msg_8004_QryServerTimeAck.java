/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
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

@JTMsgId(JT808MsgConsts.QRY_SERVER_TIME_ACK_8004)
public class JT808Msg_8004_QryServerTimeAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.QRY_SERVER_TIME_ACK_8004;

    private long serverTime;

    public JT808Msg_8004_QryServerTimeAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8004_QryServerTimeAck(JT808FrameHeader header) {
        super(header);
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return "JT808Msg_8004_QryServerTimeAck{" +
                "serverTime=" + serverTime +
                '}';
    }
}
