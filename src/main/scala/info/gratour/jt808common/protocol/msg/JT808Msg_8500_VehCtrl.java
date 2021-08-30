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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8500_VehCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.VEH_CTRL_8500)
public class JT808Msg_8500_VehCtrl extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.VEH_CTRL_8500;

    public JT808Msg_8500_VehCtrl() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8500_VehCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8500_VehCtrl params;

    public CP_8500_VehCtrl getParams() {
        return params;
    }

    public void setParams(CP_8500_VehCtrl params) {
        this.params = params;
    }


    @Override
    public String toString() {
        return "JT808Msg_8500_VehCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
