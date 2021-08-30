package info.gratour.jt808common.protocol.msg.types;

import info.gratour.jtcommon.JTUtils;

import java.util.Objects;

public class Coordinate implements Cloneable {

    private double lng;
    private double lat;

    public Coordinate() {
    }

    public Coordinate(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String lngStr() {
        return JTUtils.formatAxis(lng);
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String latStr() {
        return JTUtils.formatAxis(lat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.lng, lng) == 0 &&
                Double.compare(that.lat, lat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lng, lat);
    }

    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "POINT (" + lng +
                ", " + lat +
                ')';
    }
}
