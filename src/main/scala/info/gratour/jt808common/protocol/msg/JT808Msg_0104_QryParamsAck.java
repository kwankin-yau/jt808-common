package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0104_QryParamsAck;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.QRY_PARAMS_ACK_0104)
public class JT808Msg_0104_QryParamsAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.QRY_PARAMS_ACK_0104;

    public JT808Msg_0104_QryParamsAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0104_QryParamsAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT808AckParams_0104_QryParamsAck ackParams;

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public JT808AckParams_0104_QryParamsAck getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams_0104_QryParamsAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return "JT808Msg_0104_QryParamsAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackParams=" + ackParams +
                "} " + super.toString();
    }
}
