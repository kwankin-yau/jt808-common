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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1003_QryAVAttrsAck;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003)
public class JT1078Msg_1003_QryAVAttrsAck extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003;

    public JT1078Msg_1003_QryAVAttrsAck() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_1003_QryAVAttrsAck(JT808FrameHeader header) {
        super(header);
    }

    private JT1078AckParams_1003_QryAVAttrsAck ackParams;

    public JT1078AckParams_1003_QryAVAttrsAck getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT1078AckParams_1003_QryAVAttrsAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return "JT1078Msg_1003_QryAVAttrsAck{" +
                "ackParams=" + ackParams +
                "} " + super.toString();
    }
}
