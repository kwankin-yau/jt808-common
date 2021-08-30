/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.Coordinate;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_POLYGON_REGION_8604)
public class CP_8604_SetPolygonRegion implements JT808CmdParams {

    private int regionId;
    private short attrs;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;
    private Coordinate[] vectors;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public short getAttrs() {
        return attrs;
    }

    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    public Short getSpdUpperLimit() {
        return spdUpperLimit;
    }

    public void setSpdUpperLimit(Short spdUpperLimit) {
        this.spdUpperLimit = spdUpperLimit;
    }

    public Byte getTimeThreshold() {
        return timeThreshold;
    }

    public void setTimeThreshold(Byte timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    public Coordinate[] getVectors() {
        return vectors;
    }

    public void setVectors(Coordinate[] vectors) {
        this.vectors = vectors;
    }

    @Override
    public String toString() {
        return "CP_8604_SetPolygonRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                ", vectors=" + Arrays.toString(vectors) +
                '}';
    }

    public void assignFrom(CP_8604_SetPolygonRegion source) {
        this.regionId = source.regionId;
        this.attrs = source.attrs;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.spdUpperLimit = source.spdUpperLimit;
        this.timeThreshold = source.timeThreshold;
        if (source.vectors != null) {
            this.vectors = new Coordinate[source.vectors.length];
            for (int i = 0; i < this.vectors.length; i++) {
                this.vectors[i] = source.vectors[i].clone();
            }
        } else
            this.vectors = null;
    }


    @Override
    public CP_8604_SetPolygonRegion clone() {
        CP_8604_SetPolygonRegion r = new CP_8604_SetPolygonRegion();
        r.assignFrom(this);
        return r;
    }
}
