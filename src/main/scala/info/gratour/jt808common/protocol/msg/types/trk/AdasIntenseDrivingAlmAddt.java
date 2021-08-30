/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

public class AdasIntenseDrivingAlmAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    public static final byte TYP__RAPID_ACCELERATE = 0;
    public static final byte TYP__RAPID_DECELERATE = 1;
    public static final byte TYP__RAPID_TURN = 2;
    public static final byte TYP__IDLING = 3;
    public static final byte TYP__UNEXPECTED_FLAME_OUT = 4;
    public static final byte TYP__SLIDING_ON_N = 5;
    public static final byte TYP__ENGINE_RPM_TOO_HIGH = 6;

    private int almId;
    private byte flag;
    private byte typ;
    private short dur;
    private short thold1;
    private short thold2;
    private short spd;
    private short alt;
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

    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }


    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public short getDur() {
        return dur;
    }

    public void setDur(short dur) {
        this.dur = dur;
    }

    public short getThold1() {
        return thold1;
    }

    public void setThold1(short thold1) {
        this.thold1 = thold1;
    }

    public short getThold2() {
        return thold2;
    }

    public void setThold2(short thold2) {
        this.thold2 = thold2;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public short getAlt() {
        return alt;
    }

    public void setAlt(short alt) {
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
    public AdasIntenseDrivingAlmAddt clone() {
        try {
            return (AdasIntenseDrivingAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AdasIntenseDrivingAlmAddt{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", typ=" + typ +
                ", dur=" + dur +
                ", thold1=" + thold1 +
                ", thold2=" + thold2 +
                ", spd=" + spd +
                ", alt=" + alt +
                ", lat=" + lat +
                ", lng=" + lng +
                ", tm=" + tm +
                ", vehSt=" + vehSt +
                ", almNo=" + almNo +
                '}';
    }
}
