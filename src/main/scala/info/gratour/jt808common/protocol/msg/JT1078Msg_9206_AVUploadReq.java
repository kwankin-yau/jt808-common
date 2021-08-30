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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9206_AVUploadReq;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_REQ_9206)
public class JT1078Msg_9206_AVUploadReq extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.AV_UPLOAD_REQ_9206;

    public JT1078Msg_9206_AVUploadReq() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9206_AVUploadReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9206_AVUploadReq params;

    public CP_9206_AVUploadReq getParams() {
        return params;
    }

    public void setParams(CP_9206_AVUploadReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9206_AVUploadReq{" +
                "params=" + params +
                "} " + super.toString();
    }
}
