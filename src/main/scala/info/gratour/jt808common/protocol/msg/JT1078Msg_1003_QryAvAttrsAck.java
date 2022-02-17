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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1003_QryAvAttrsAck;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003)
public class JT1078Msg_1003_QryAvAttrsAck extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003;

    public JT1078Msg_1003_QryAvAttrsAck() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_1003_QryAvAttrsAck(JT808FrameHeader header) {
        super(header);
    }

    private JT1078AckParams_1003_QryAvAttrsAck ackParams;

    public JT1078AckParams_1003_QryAvAttrsAck getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT1078AckParams_1003_QryAvAttrsAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1003_QryAvAttrsAck.class.getSimpleName() + "[", "]")
                .add("ackParams=" + ackParams)
                .toString();
    }
}
