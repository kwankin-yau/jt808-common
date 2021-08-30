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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9207_AVUploadCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_CTRL_9207)
public class JT1078Msg_9207_AVUploadCtrl extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.AV_UPLOAD_CTRL_9207;

    public JT1078Msg_9207_AVUploadCtrl() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9207_AVUploadCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9207_AVUploadCtrl params;

    public CP_9207_AVUploadCtrl getParams() {
        return params;
    }

    public void setParams(CP_9207_AVUploadCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9207_AVUploadCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
