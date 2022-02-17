package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

@JTMsgId(JT808MsgConsts.TERMINAL_GENERIC_ACK_0001)
public class JT808Msg_0001_TerminalGeneralAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.TERMINAL_GENERIC_ACK_0001;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__BAD_FORMAT = 2;
    public static final byte RESULT__NOT_SUPPORTED = 3;

    public static byte resultCodeOf(boolean success) {
        if (success)
            return RESULT__SUCCESS;
        else
            return RESULT__FAILED;
    }

    public JT808Msg_0001_TerminalGeneralAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0001_TerminalGeneralAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private int ackMsgId;
    private byte result;

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public int getAckMsgId() {
        return ackMsgId;
    }

    public void setAckMsgId(int ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    public String ackMsgIdToHex() {
        return JTUtils.msgIdToHex(ackMsgId);
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "JT808Msg_0001_TerminalGeneralAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackMsgId=" + ackMsgIdToHex() +
                ", result=" + result +
                "} " + super.toString();
    }
}
