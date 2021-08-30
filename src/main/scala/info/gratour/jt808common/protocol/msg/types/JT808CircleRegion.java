/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

public class JT808CircleRegion implements Cloneable {

    private int regionId;
    private short attrs;
    private Coordinate center;
    private int radius;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;

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

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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

    public void assignFrom(JT808CircleRegion source) {
        this.regionId = source.regionId;
        this.attrs = source.attrs;
        this.center = source.center != null ? source.center.clone() : null;
        this.radius = source.radius;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.spdUpperLimit = source.spdUpperLimit;
        this.timeThreshold = source.timeThreshold;
    }

    @Override
    public JT808CircleRegion clone() {
        JT808CircleRegion r = new JT808CircleRegion();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808CircleRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", center=" + center +
                ", radius=" + radius +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                '}';
    }
}
