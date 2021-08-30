package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.TERMINAL_REGISTER_ACK_8100)
public class JT808Msg_8100_TerminalRegisterAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_REGISTER_ACK_8100;

    public JT808Msg_8100_TerminalRegisterAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8100_TerminalRegisterAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private byte result;
    private String authCode;

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "JT808Msg_8100_DeviceRegisterAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", result=" + result +
                ", authCode='" + authCode + '\'' +
                "} " + super.toString();
    }
}
