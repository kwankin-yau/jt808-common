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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8604_SetPolygonRegion;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.SET_POLYGON_REGION_8604)
public class JT808Msg_8604_SetPolygonRegion extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_POLYGON_REGION_8604;

    public JT808Msg_8604_SetPolygonRegion() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8604_SetPolygonRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8604_SetPolygonRegion params;

    public CP_8604_SetPolygonRegion getParams() {
        return params;
    }

    public void setParams(CP_8604_SetPolygonRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8604_SetPolygonRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
