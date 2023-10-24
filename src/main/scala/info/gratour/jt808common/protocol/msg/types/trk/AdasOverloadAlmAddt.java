package info.gratour.jt808common.protocol.msg.types.trk;

import java.util.StringJoiner;

/**
 * 载重报警附加信息
 */
public class AdasOverloadAlmAddt implements Cloneable {

    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;
    public static final byte FLAG__CONTINUOUSLY = 3;

    /**
     * 超过车辆额定载重报警
     */
    public static final byte TYP__OVER_VEH_LOADING = 1;

    /**
     * 超过道路额定载重报警
     */
    public static final byte TYP__OVER_ROAD_LOADING = 2;

    private int almId;
    private byte flag;
    private byte typ;
    private int actualLoading;
    private int threshold;
    private short spd;
    private int alt;
    private double lat;
    private double lng;

    private long tm;
    private short vehSt;
    private String almNo;

    public int getAlmId() {
        return almId;
    }

    public void setAlmId(int almId) {
        this.almId = almId;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public int getActualLoading() {
        return actualLoading;
    }

    public void setActualLoading(int actualLoading) {
        this.actualLoading = actualLoading;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }

    public short getVehSt() {
        return vehSt;
    }

    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    public String getAlmNo() {
        return almNo;
    }

    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    @Override
    public AdasOverloadAlmAddt clone() {
        try {
            return (AdasOverloadAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasOverloadAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("actualLoading=" + actualLoading)
                .add("threshold=" + threshold)
                .add("spd=" + spd)
                .add("alt=" + alt)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("tm=" + tm)
                .add("vehSt=" + vehSt)
                .add("almNo='" + almNo + "'")
                .toString();
    }
}
