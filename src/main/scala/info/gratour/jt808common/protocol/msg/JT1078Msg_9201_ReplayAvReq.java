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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9201_ReplayAvReq;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.REPLAY_AV_REQ_9201)
public class JT1078Msg_9201_ReplayAvReq extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.REPLAY_AV_REQ_9201;

    public JT1078Msg_9201_ReplayAvReq() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9201_ReplayAvReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9201_ReplayAvReq params;

    public CP_9201_ReplayAvReq getParams() {
        return params;
    }

    public void setParams(CP_9201_ReplayAvReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9201_ReplayAvReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
