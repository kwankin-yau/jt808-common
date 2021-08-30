/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

public class AdasOverSpdAlmAddt implements Cloneable {


    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;
    public static final byte FLAG__CONTINUOUS = 3;

    public static final byte BIT__OVER_EQUIP_SPEED_LIMIT = 0;
    public static final byte BIT__OVER_ROAD_SPEED_LIMIT = 1;

    private int almId;
    private byte flag;
    private byte typ;
    private byte overSpdAlmTyp;
    private short termSpdThold;
    private short rdSpdThold;
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

    public boolean flagIsStart() {
        return flag == FLAG__START;
    }


    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public byte getOverSpdAlmTyp() {
        return overSpdAlmTyp;
    }

    public void setOverSpdAlmTyp(byte overSpdAlmTyp) {
        this.overSpdAlmTyp = overSpdAlmTyp;
    }

    public short getTermSpdThold() {
        return termSpdThold;
    }

    public void setTermSpdThold(short termSpdThold) {
        this.termSpdThold = termSpdThold;
    }

    public short getRdSpdThold() {
        return rdSpdThold;
    }

    public void setRdSpdThold(short rdSpdThold) {
        this.rdSpdThold = rdSpdThold;
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
    public AdasOverSpdAlmAddt clone() {
        try {
            return (AdasOverSpdAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AdasOverSpdAlmAddt{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", typ=" + typ +
                ", overSpdAlmTyp=" + overSpdAlmTyp +
                ", terminalSpdThreshold=" + termSpdThold +
                ", rdSpdThold=" + rdSpdThold +
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
