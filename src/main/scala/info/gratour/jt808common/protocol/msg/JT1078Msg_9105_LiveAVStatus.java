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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9105_LiveAVStatus;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.LIVE_AV_STATUS_9105)
public class JT1078Msg_9105_LiveAVStatus extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_STATUS_9105;

    public JT1078Msg_9105_LiveAVStatus() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9105_LiveAVStatus(JT808FrameHeader header) {
        super(header);
    }

    private CP_9105_LiveAVStatus params;

    public CP_9105_LiveAVStatus getParams() {
        return params;
    }

    public void setParams(CP_9105_LiveAVStatus params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9105_LiveAVStatus{" +
                "params=" + params +
                "} " + super.toString();
    }
}
