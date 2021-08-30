package info.gratour.jt808common.protocol.msg.types.trk;

public class AdasDrivingAssistAlmAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    public static final byte TYP__FRONT_CRASH = 1;
    public static final byte TYP__STRAY_PATH = 2;
    public static final byte TYP__TOO_CLOSE_TO_FRONT_CAR = 3;
    public static final byte TYP__PEDESTRIAN_HIT = 4;
    public static final byte TYP__CHANGE_LANE_FREQUENTLY = 5;
    public static final byte TYP__ROAD_RECOG_MARK_OVERRUN = 6;
    public static final byte TYP__OBSTACLE = 7;
    public static final byte TYP__ASSIST_FUNC_FAILURE = 8;
    public static final byte TYP__ROAD_RECOG_EVENT = 0x10;
    public static final byte TYP__ACTIVE_CAPTURE_EVENT = 0x11;

    /**
     * 实绩变道报警
     */
    public static final byte TYP__VIOLATED_CHANGE_PATH = 0x12;

    /**
     * 车厢过道行人监测
     */
    public static final byte TYP__PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = 0x13;


    private int almId;
    private byte flag;
    private byte typ;
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
        return "AdasDrivingAssistAlmAddt{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", typ=" + typ +
                ", lvl=" + lvl +
                ", frontCarSpd=" + frontCarSpd +
                ", frontCarDist=" + frontCarDist +
                ", deviateTyp=" + deviateTyp +
                ", rdRecogMark=" + rdRecogMark +
                ", rdRecogDat=" + rdRecogDat +
                ", speed=" + spd +
                ", alt=" + alt +
                ", lat=" + lat +
                ", lng=" + lng +
                ", time=" + tm +
                ", vehSt=" + vehSt +
                ", almNo='" + almNo + '\'' +
                '}';
    }
}
