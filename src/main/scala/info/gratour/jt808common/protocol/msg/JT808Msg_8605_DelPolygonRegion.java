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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8605_DelPolygonRegion;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.DEL_POLYGON_REGION_8605)
public class JT808Msg_8605_DelPolygonRegion extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.DEL_POLYGON_REGION_8605;

    public JT808Msg_8605_DelPolygonRegion() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8605_DelPolygonRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8605_DelPolygonRegion params;

    public CP_8605_DelPolygonRegion getParams() {
        return params;
    }

    public void setParams(CP_8605_DelPolygonRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8605_DelPolygonRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
