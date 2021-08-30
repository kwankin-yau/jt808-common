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

@JTMsgId(JT808MsgConsts.DEL_CIRCLE_REGION_8601)
public class CP_8601_DelCircleRegion implements JT808CmdParams {

    private int[] regionIds;

    public int[] getRegionIds() {
        return regionIds;
    }

    public void setRegionIds(int[] regionIds) {
        this.regionIds = regionIds;
    }

    @Override
    public String toString() {
        return "CP_8601_DelCircleRegion{" +
                "regionIds=" + Arrays.toString(regionIds) +
                '}';
    }

    @Override
    public CP_8601_DelCircleRegion clone() {
        try {
            return (CP_8601_DelCircleRegion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
