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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8606_SetRoute;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.SET_ROUTE_8606)
public class JT808Msg_8606_SetRoute extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_ROUTE_8606;

    public JT808Msg_8606_SetRoute() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8606_SetRoute(JT808FrameHeader header) {
        super(header);
    }

    private CP_8606_SetRoute params;

    public CP_8606_SetRoute getParams() {
        return params;
    }

    public void setParams(CP_8606_SetRoute params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8606_SetRoute{" +
                "params=" + params +
                "} " + super.toString();
    }
}
