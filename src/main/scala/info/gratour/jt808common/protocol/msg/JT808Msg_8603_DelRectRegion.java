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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8603_DelRectRegion;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.DEL_RECT_REGION_8603)
public class JT808Msg_8603_DelRectRegion extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.DEL_RECT_REGION_8603;

    public JT808Msg_8603_DelRectRegion() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8603_DelRectRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8603_DelRectRegion params;

    public CP_8603_DelRectRegion getParams() {
        return params;
    }

    public void setParams(CP_8603_DelRectRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8603_DelRectRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
