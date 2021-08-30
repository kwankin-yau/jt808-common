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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9101_LiveAVReq;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.LIVE_AV_REQ_9101)
public class JT1078Msg_9101_LiveAVReq extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_REQ_9101;

    public JT1078Msg_9101_LiveAVReq() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9101_LiveAVReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9101_LiveAVReq params;

    public CP_9101_LiveAVReq getParams() {
        return params;
    }

    public void setParams(CP_9101_LiveAVReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9101_LiveAVReq{" +
                "params=" + params +
                "} " + super.toString();
    }
}
