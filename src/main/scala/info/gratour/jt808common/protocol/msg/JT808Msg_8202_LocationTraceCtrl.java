/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8202_LocationTraceCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.LOCATION_TRACE_CTRL_8202)
public class JT808Msg_8202_LocationTraceCtrl extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.LOCATION_TRACE_CTRL_8202;

    public JT808Msg_8202_LocationTraceCtrl() {
    }

    public JT808Msg_8202_LocationTraceCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8202_LocationTraceCtrl params;

    public CP_8202_LocationTraceCtrl getParams() {
        return params;
    }

    public void setParams(CP_8202_LocationTraceCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8202_LocationTraceCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
