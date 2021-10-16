/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.codec.CodecError;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class AdasDriverBehavAlmAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    public static final byte TYP__FATIGUED = 1;
    public static final byte TYP__PHONE_CALL = 2;
    public static final byte TYP__SMOKE = 3;
    public static final byte TYP__NO_LOOK_AHEAD = 4;
    public static final byte TYP__DRIVER_NOT_DETECTED = 5;
    public static final byte TYP__STEERING_WHEEL_NOT_HOLDING__SI_CHUAN = 6;
    public static final byte TYP__CAMERA_COVERED__GDRTA = 6;
    public static final byte TYP__DRIVER_BEHAV_ALM_FUNC_FAILURE = 7;
    public static final byte TYP__NOT_BELTING__SI_CHUAN = 8;
    public static final byte TYP__ONE_TIME_DRIVE_OVERTIME__GDRTA = 8;
    public static final byte TYP__NOT_BELTING__GDRTA = 0x0A;
    public static final byte TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE__GDRTA = 0x0B;
    public static final byte TYP__STEERING_WHEEL_NOT_HOLDING__GDRTA = 0x0C;
    public static final byte TYP__PLAY_SMART_PHONE = 0x0D;
    public static final byte TYP__AUTO_CAPTURE = 0x10;
    public static final byte TYP__DRIVER_CHANGED_EVENT = 0x11;
    public static final byte TYP__INVALID_DRIVER_ID = 0x12;


    private int almId;
    private byte flag;
    private byte typ;
    private byte lvl;
    private byte fatigue;
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

    public byte getLvl() {
        return lvl;
    }

    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    public byte getFatigue() {
        return fatigue;
    }

    public void setFatigue(byte fatigue) {
        this.fatigue = fatigue;
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

    public byte[] almNoBytes() {
        try {
            return Hex.decodeHex(almNo);
        } catch (DecoderException e) {
            throw new CodecError("Can not decode almNo: " + almNo, e);
        }
    }

    @Override
    protected AdasDriverBehavAlmAddt clone() {
        try {
            return (AdasDriverBehavAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AdasDriverBehavAlmAddt{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", typ=" + typ +
                ", lvl=" + lvl +
                ", fatigue=" + fatigue +
                ", spd=" + spd +
                ", alt=" + alt +
                ", lat=" + lat +
                ", lng=" + lng +
                ", tm=" + tm +
                ", vehSt=" + vehSt +
                ", almNo='" + almNo + '\'' +
                '}';
    }
}
