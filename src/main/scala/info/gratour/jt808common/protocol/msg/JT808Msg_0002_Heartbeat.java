package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.HEARTBEAT_0002)
public class JT808Msg_0002_Heartbeat extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.HEARTBEAT_0002;

    public JT808Msg_0002_Heartbeat() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0002_Heartbeat(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_0002_Heartbeat{} " + super.toString();
    }
}
