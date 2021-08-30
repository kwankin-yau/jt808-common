package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0100_TermRegister;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_REGISTER_0100)
public class JT808Msg_0100_TerminalRegister extends JT808Msg  {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_REGISTER_0100;

    public JT808Msg_0100_TerminalRegister() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0100_TerminalRegister(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0100_TermRegister info;

    public MQEventAddt_0100_TermRegister getInfo() {
        return info;
    }

    public void setInfo(MQEventAddt_0100_TermRegister info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JT808Msg_0100_TerminalRegister{" +
                "info=" + info +
                "} " + super.toString();
    }
}
