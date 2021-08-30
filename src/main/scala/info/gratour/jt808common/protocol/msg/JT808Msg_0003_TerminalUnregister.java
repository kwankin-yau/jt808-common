package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_UNREGISTER_0003)
public class JT808Msg_0003_TerminalUnregister extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_UNREGISTER_0003;

    public JT808Msg_0003_TerminalUnregister() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0003_TerminalUnregister(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_0003_TerminalUnregister{} " + super.toString();
    }
}
