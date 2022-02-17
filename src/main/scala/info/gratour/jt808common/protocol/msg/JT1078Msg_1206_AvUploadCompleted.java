/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_COMPLETED_1206)
public class JT1078Msg_1206_AvUploadCompleted extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.AV_UPLOAD_COMPLETED_1206;

    public JT1078Msg_1206_AvUploadCompleted() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_1206_AvUploadCompleted(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private byte result;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1206_AvUploadCompleted.class.getSimpleName() + "[", "]")
                .add("ackSeqNo=" + ackSeqNo)
                .add("result=" + result)
                .toString();
    }
}
