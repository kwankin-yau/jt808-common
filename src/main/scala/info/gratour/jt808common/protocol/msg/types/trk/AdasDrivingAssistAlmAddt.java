package info.gratour.jt808common.protocol.msg.types.trk;

import java.util.StringJoiner;

public class AdasDrivingAssistAlmAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    /**
     * 前身碰撞报警
     */
    public static final byte TYP__FRONT_CRASH = 1;

    /**
     * 车道偏离报警
     */
    public static final byte TYP__STRAY_PATH = 2;

    /**
     * 车距过近报警
     */
    public static final byte TYP__TOO_CLOSE_TO_FRONT_CAR = 3;

    /**
     * 行人碰撞报警
     */
    public static final byte TYP__PEDESTRIAN_HIT = 4;

    /**
     * 频繁变道报警
     */
    public static final byte TYP__CHANGE_LANE_FREQUENTLY = 5;

    /**
     * 道路标识超限报警
     */
    public static final byte TYP__ROAD_RECOG_MARK_OVERRUN = 6;

    /**
     * 障碍物报警
     */
    public static final byte TYP__OBSTACLE = 7;

    /**
     * 驾驶辅助功能失效报警
     */
    public static final byte TYP__ASSIST_FUNC_FAILURE = 8;

    /**
     * 道路标志识别事件
     */
    public static final byte TYP__ROAD_RECOG_EVENT = 0x10;

    /**
     * 主动抓拍识别事件
     */
    public static final byte TYP__ACTIVE_CAPTURE_EVENT = 0x11;

    /**
     * 实线变道报警
     */
    public static final byte TYP__VIOLATED_CHANGE_PATH = 0x12;

    /**
     * 车厢过道行人监测
     */
    public static final byte TYP__PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = 0x13;

    /**
     * 设备失效提醒
     */
    public static final byte TYP__DEVICE_FAILURE = 0x14;

    public static final byte TYP__CUSTOM = (byte) 0xFF;


    private int almId;
    private byte flag;
    private short typ;
    private short typ2;
    private byte lvl;
    private Short frontCarSpd;
    private Float frontCarDist;
    private Byte deviateTyp;
    private Byte rdRecogMark;
    private Byte rdRecogDat;
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

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public short getTyp2() {
        return typ2;
    }

    public void setTyp2(short typ2) {
        this.typ2 = typ2;
    }

    public byte getLvl() {
        return lvl;
    }

    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    public Short getFrontCarSpd() {
        return frontCarSpd;
    }

    public void setFrontCarSpd(Short frontCarSpd) {
        this.frontCarSpd = frontCarSpd;
    }

    public Float getFrontCarDist() {
        return frontCarDist;
    }

    public void setFrontCarDist(Float frontCarDist) {
        this.frontCarDist = frontCarDist;
    }

    public Byte getDeviateTyp() {
        return deviateTyp;
    }

    public void setDeviateTyp(Byte deviateTyp) {
        this.deviateTyp = deviateTyp;
    }

    public Byte getRdRecogMark() {
        return rdRecogMark;
    }

    public void setRdRecogMark(Byte rdRecogMark) {
        this.rdRecogMark = rdRecogMark;
    }

    public Byte getRdRecogDat() {
        return rdRecogDat;
    }

    public void setRdRecogDat(Byte rdRecogDat) {
        this.rdRecogDat = rdRecogDat;
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
    public AdasDrivingAssistAlmAddt clone() {
        try {
            return (AdasDrivingAssistAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasDrivingAssistAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("typ2=" + typ2)
                .add("lvl=" + lvl)
                .add("frontCarSpd=" + frontCarSpd)
                .add("frontCarDist=" + frontCarDist)
                .add("deviateTyp=" + deviateTyp)
                .add("rdRecogMark=" + rdRecogMark)
                .add("rdRecogDat=" + rdRecogDat)
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
