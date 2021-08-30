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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0303_InfoDemand;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.INFO_DEMAND_0303)
public class JT808Msg_0303_InfoDemand extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.INFO_DEMAND_0303;

    public JT808Msg_0303_InfoDemand() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0303_InfoDemand(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0303_InfoDemand params;

    public MQEventAddt_0303_InfoDemand getParams() {
        return params;
    }

    public void setParams(MQEventAddt_0303_InfoDemand params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_0303_InfoDemand{" +
                "params=" + params +
                "} " + super.toString();
    }
}
