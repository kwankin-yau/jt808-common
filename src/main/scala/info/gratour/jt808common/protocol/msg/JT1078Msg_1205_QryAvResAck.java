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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1205_QryAvResAck;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.QRY_AV_RES_ACK_1205)
public class JT1078Msg_1205_QryAvResAck extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_RES_ACK_1205;

    public JT1078Msg_1205_QryAvResAck() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_1205_QryAvResAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT1078AckParams_1205_QryAvResAck ackParams;

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public JT1078AckParams_1205_QryAvResAck getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT1078AckParams_1205_QryAvResAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1205_QryAvResAck.class.getSimpleName() + "[", "]")
                .add("ackSeqNo=" + ackSeqNo)
                .add("ackParams=" + ackParams)
                .toString();
    }
}
