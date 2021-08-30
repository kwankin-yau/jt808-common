/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import java.util.List;

public class AdasTyreState implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    private int almId;
    private byte flag;
    private short spd;
    private short alt;
    private double lat;
    private double lng;
    private long tm;
    private short vehSt;
    private String almNo;
    private List<PressureAlarmInfo> pressureAlarmInfoList;

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

    public List<PressureAlarmInfo> getPressureAlarmInfoList() {
        return pressureAlarmInfoList;
    }

    public void setPressureAlarmInfoList(List<PressureAlarmInfo> pressureAlarmInfoList) {
        this.pressureAlarmInfoList = pressureAlarmInfoList;
    }

    @Override
    public AdasTyreState clone() {
        try {
            return (AdasTyreState) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AdasTyreState{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", spd=" + spd +
                ", alt=" + alt +
                ", lat=" + lat +
                ", lng=" + lng +
                ", tm=" + tm +
                ", vehSt=" + vehSt +
                ", almNo=" + almNo +
                ", pressureAlarmInfoList=" + pressureAlarmInfoList +
                '}';
    }
}
