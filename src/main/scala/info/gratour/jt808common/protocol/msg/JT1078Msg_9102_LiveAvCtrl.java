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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9102_LiveAvCtrl;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.LIVE_AV_CTRL_9102)
public class JT1078Msg_9102_LiveAvCtrl extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_CTRL_9102;

    public JT1078Msg_9102_LiveAvCtrl() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9102_LiveAvCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9102_LiveAvCtrl params;

    public CP_9102_LiveAvCtrl getParams() {
        return params;
    }

    public void setParams(CP_9102_LiveAvCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9102_LiveAvCtrl.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
