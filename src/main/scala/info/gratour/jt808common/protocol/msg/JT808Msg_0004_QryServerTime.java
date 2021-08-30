package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.QRY_SERVER_TIME_0004)
public class JT808Msg_0004_QryServerTime extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.QRY_SERVER_TIME_0004;

    public JT808Msg_0004_QryServerTime() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0004_QryServerTime(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_0004_QryServerTime{}";
    }
}
