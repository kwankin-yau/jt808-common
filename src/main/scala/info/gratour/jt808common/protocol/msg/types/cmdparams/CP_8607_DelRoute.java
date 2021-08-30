/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.DEL_ROUTE_8607)
public class CP_8607_DelRoute implements JT808CmdParams {

    private int[] routeIds;

    public int[] getRouteIds() {
        return routeIds;
    }

    public void setRouteIds(int[] routeIds) {
        this.routeIds = routeIds;
    }

    @Override
    public CP_8607_DelRoute clone() {
        try {
            return (CP_8607_DelRoute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "CP_8607_DelRoute{" +
                "routeIds=" + Arrays.toString(routeIds) +
                '}';
    }
}
