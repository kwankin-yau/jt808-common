package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_CTRL_8105)
public class JT808Msg_8105_TerminalCtrl extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_CTRL_8105;

    public JT808Msg_8105_TerminalCtrl() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8105_TerminalCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8105_TerminalCtrl params;

    public CP_8105_TerminalCtrl getParams() {
        return params;
    }

    public void setParams(CP_8105_TerminalCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8105_TerminalCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
