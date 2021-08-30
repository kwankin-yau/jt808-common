/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808RectRegion;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_RECT_REGION_8602)
public class CP_8602_SetRectRegion implements JT808CmdParams {

    private byte action;
    private JT808RectRegion[] regions;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808RectRegion[] getRegions() {
        return regions;
    }

    public void setRegions(JT808RectRegion[] regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "CP_8602_SetRectRegion{" +
                "action=" + action +
                ", regions=" + Arrays.toString(regions) +
                '}';
    }

    public void assignFrom(CP_8602_SetRectRegion source) {
        this.action = source.action;
        if (source.regions != null) {
            this.regions = new JT808RectRegion[source.regions.length];
            for (int i = 0; i < this.regions.length; i++) {
                this.regions[i] = source.regions[i].clone();
            }
        } else
            this.regions = null;
    }

    @Override
    public CP_8602_SetRectRegion clone() {
        CP_8602_SetRectRegion r = new CP_8602_SetRectRegion();
        r.assignFrom(this);
        return r;
    }
}
