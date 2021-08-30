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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9202_ReplayAVCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.REPLAY_AV_CTRL_9202)
public class JT1078Msg_9202_ReplayAVCtrl extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.REPLAY_AV_CTRL_9202;

    public JT1078Msg_9202_ReplayAVCtrl() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9202_ReplayAVCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9202_ReplayAVCtrl params;

    public CP_9202_ReplayAVCtrl getParams() {
        return params;
    }

    public void setParams(CP_9202_ReplayAVCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT1078Msg_9202_ReplayAVCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
