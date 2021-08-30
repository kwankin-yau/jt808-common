package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.PACKET_RETRANSMIT_REQ_8003)
public class JT808Msg_8003_Retransmit extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.PACKET_RETRANSMIT_REQ_8003;

    public JT808Msg_8003_Retransmit() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8003_Retransmit(JT808FrameHeader header) {
        super(header);
    }

    private int origSeqNo;
    private int[] retransmitPacketIds;

    public int getOrigSeqNo() {
        return origSeqNo;
    }

    public void setOrigSeqNo(int origSeqNo) {
        this.origSeqNo = origSeqNo;
    }

    public int[] getRetransmitPacketIds() {
        return retransmitPacketIds;
    }

    public void setRetransmitPacketIds(int[] retransmitPacketIds) {
        this.retransmitPacketIds = retransmitPacketIds;
    }

    @Override
    public String toString() {
        return "JT808Msg_8003_Retransmit{" +
                "origSeqNo=" + origSeqNo +
                ", retransmitPacketIds=" + Arrays.toString(retransmitPacketIds) +
                "} " + super.toString();
    }
}
