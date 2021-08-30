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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9302_PTZFocusing;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.PTZ_FOCUSING_9302)
public class JT1078Msg_9302_PTZFocusing extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.PTZ_FOCUSING_9302;

    public JT1078Msg_9302_PTZFocusing() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9302_PTZFocusing(JT808FrameHeader header) {
        super(header);
    }

    private CP_9302_PTZFocusing params;

    public CP_9302_PTZFocusing getParams() {
        return params;
    }

    public void setParams(CP_9302_PTZFocusing params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9302_PTZFocusing{" +
                "params=" + params +
                "} " + super.toString();
    }
}
