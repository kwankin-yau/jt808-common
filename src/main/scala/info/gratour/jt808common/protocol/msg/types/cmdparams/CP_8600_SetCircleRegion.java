/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808CircleRegion;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_CIRCLE_REGION_8600)
public class CP_8600_SetCircleRegion implements JT808CmdParams {

    private byte action;
    private JT808CircleRegion[] regions;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808CircleRegion[] getRegions() {
        return regions;
    }

    public void setRegions(JT808CircleRegion[] regions) {
        this.regions = regions;
    }

    public void assignFrom(CP_8600_SetCircleRegion source) {
        this.action = source.action;
        if (source.regions != null) {
            this.regions = new JT808CircleRegion[source.regions.length];
            for (int i = 0; i < this.regions.length; i++)
                this.regions[i] = source.regions[i].clone();
        } else
            this.regions = null;
    }

    @Override
    public String toString() {
        return "CP_8600_SetCircleRegion{" +
                "action=" + action +
                ", regions=" + Arrays.toString(regions) +
                '}';
    }

    @Override
    public CP_8600_SetCircleRegion clone() {
        CP_8600_SetCircleRegion r = new CP_8600_SetCircleRegion();
        r.assignFrom(this);
        return r;
    }
}
