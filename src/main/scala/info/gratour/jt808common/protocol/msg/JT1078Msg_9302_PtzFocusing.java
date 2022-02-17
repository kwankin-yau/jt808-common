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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9302_PtzFocusing;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.PTZ_FOCUSING_9302)
public class JT1078Msg_9302_PtzFocusing extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.PTZ_FOCUSING_9302;

    public JT1078Msg_9302_PtzFocusing() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9302_PtzFocusing(JT808FrameHeader header) {
        super(header);
    }

    private CP_9302_PtzFocusing params;

    public CP_9302_PtzFocusing getParams() {
        return params;
    }

    public void setParams(CP_9302_PtzFocusing params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9302_PtzFocusing.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
