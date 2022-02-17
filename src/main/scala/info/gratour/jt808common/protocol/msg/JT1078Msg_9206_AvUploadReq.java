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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9206_AvUploadReq;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_REQ_9206)
public class JT1078Msg_9206_AvUploadReq extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.AV_UPLOAD_REQ_9206;

    public JT1078Msg_9206_AvUploadReq() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9206_AvUploadReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9206_AvUploadReq params;

    public CP_9206_AvUploadReq getParams() {
        return params;
    }

    public void setParams(CP_9206_AvUploadReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9206_AvUploadReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
