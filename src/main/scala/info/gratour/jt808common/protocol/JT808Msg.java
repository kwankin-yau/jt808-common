package info.gratour.jt808common.protocol;

import info.gratour.jtcommon.JTMsg;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

public class JT808Msg implements JTMsg {

    private int msgId;
    private String simNo;
    private int seqNo;

    public JT808Msg() {
        msgId = jtMsgId();
    }

    public JT808Msg(JT808FrameHeader header) {
        this.msgId = header.getMsgId();
        this.simNo = header.getSimNo();
        this.seqNo = header.getSeqNo();
    }

    @Override
    public int jtMsgId() {
        return getClass().getAnnotation(JTMsgId.class).value();
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String msgIdToHex() {
        return JTUtils.msgIdToHex(msgId);
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public String toString() {
        return "JT808Msg{" +
                "msgId=" + JTUtils.msgIdToHex(msgId) +
                ", simNo='" + simNo + '\'' +
                ", seqNo=" + seqNo +
                '}';
    }
}
