/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class VTDR_Location implements Cloneable {
    private double lng;
    private double lat;
    private short alt;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public short getAlt() {
        return alt;
    }

    public void setAlt(short alt) {
        this.alt = alt;
    }

    @Override
    public VTDR_Location clone() {
        try {
            return (VTDR_Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "VTDR_Location{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", alt=" + alt +
                '}';
    }
}
