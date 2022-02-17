package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

@JTMsgId(JT808MsgConsts.SERVER_GENERIC_ACK_8001)
public class JT808Msg_8001_PlatformGeneralAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SERVER_GENERIC_ACK_8001;

    public static final int RESULT__SUCCESS = 0;
    public static final int RESULT__FAILED = 1;
    public static final int RESULT__INVALID_MESSAGE = 2;
    public static final int RESULT__NOT_SUPPORT = 3;
    public static final int RESULT__ALARM_CONFIRM = 4;

    public static byte resultCodeOf(boolean success) {
        if (success)
            return RESULT__SUCCESS;
        else
            return RESULT__FAILED;
    }


    public JT808Msg_8001_PlatformGeneralAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8001_PlatformGeneralAck(JT808FrameHeader header) {
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
        return "JT808Msg_8001_PlatformGeneralAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackMsgId=" + ackMsgIdToHex() +
                ", result=" + result +
                "} " + super.toString();
    }
}
