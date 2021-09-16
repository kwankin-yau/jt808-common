package info.gratour.jt808common.protocol.msg.types.trk;

import com.google.gson.reflect.TypeToken;
import info.gratour.jt808common.JT1078VidAlarmBit;
import info.gratour.jt808common.JT808AlarmBit;
import info.gratour.jt808common.JT808StateBit;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Trk implements MQEventAddt, Cloneable {

    public static final Type TYPE = new TypeToken<Trk>() {
    }.getType();

    public static class AdasAlarmBits {
        public static final int ADAS_DRIVING_ASSIST_ALARM = 0;
        public static final int ADAS_DRIVER_BEHAVIOR_ALARM = 1;
        public static final int ADAS_TYRE_STATE = 2;
        public static final int ADAS_BLIND_AREA = 3;
        public static final int ADAS_INTENSE_DRIVING_ALARM = 4;
        public static final int ADAS_OVER_SPEED_ALARM = 5;
    }

    private String id;

    private String simNo;
    //    private String vehId;
    private String plateNo;
    private Short plateColor;

    private long recvTm;
    private long gpsTm;

    private Boolean retrans;

    private int alm;
    private int st;
    private double lng;
    private double lat;
    private int alt;
    private float spd;
    private Float recSpd;
    private int dir;

    private Integer signal;
    private Short ioSt;


    private Integer vidAlm;
    private Short adasAlm;

    private Float mile;
    private Float gas;

    private String drvName;
    private String drvNo;

    private TrkAddt addt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

//    public String getVehId() {
//        return vehId;
//    }

//    public void setVehId(String vehId) {
//        this.vehId = vehId;
//    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    public long getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    public long getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(long gpsTm) {
        this.gpsTm = gpsTm;
    }

    public boolean isRetrans() {
        return retrans != null ? retrans : false;
    }

    public Boolean getRetrans() {
        return retrans;
    }

    public void setRetrans(Boolean retrans) {
        this.retrans = retrans;
    }

    public int getAlm() {
        return alm;
    }

    public void setAlm(int alm) {
        this.alm = alm;
    }

    public boolean almTest(int bitIndex) {
        return JTUtils.test(alm, bitIndex);
    }

    public boolean almTest(JT808AlarmBit bit) {
        return JTUtils.test(alm, bit.bitIndex());
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public boolean stTest(int bitIndex) {
        return JTUtils.test(st, bitIndex);
    }

    public boolean stTestAccOn() {
        return stTest(JT808StateBit.ACC_ON.bitIndex());
    }

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

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public float getSpd() {
        return spd;
    }

    public void setSpd(float spd) {
        this.spd = spd;
    }

    public Float getRecSpd() {
        return recSpd;
    }

    public float recSpdDef0() {
        if (recSpd != null)
            return recSpd;
        else
            return 0f;
    }

    public void setRecSpd(Float recSpd) {
        this.recSpd = recSpd;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public boolean signalTest(int bitIndex) {
        if (signal == null)
            return false;
        else
            return JTUtils.test(signal, bitIndex);
    }

    public Short getIoSt() {
        return ioSt;
    }

    public void setIoSt(Short ioSt) {
        this.ioSt = ioSt;
    }

    public boolean ioStTest(int bitIndex) {
        if (ioSt == null)
            return false;
        else
            return JTUtils.test(ioSt.intValue(), bitIndex);
    }

    public Integer getVidAlm() {
        return vidAlm;
    }

    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    public boolean vidAlmTest(int bitIndex) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bitIndex);
        else
            return false;
    }

    public boolean vidAlmTest(JT1078VidAlarmBit bit) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bit.bitIndex());
        else
            return false;
    }

    public Short getAdasAlm() {
        return adasAlm;
    }

    public void setAdasAlm(Short adasAlm) {
        this.adasAlm = adasAlm;
    }

    public boolean adasAlmTest(int bitIndex) {
        if (adasAlm != null)
            return JTUtils.test(adasAlm, bitIndex);
        else
            return false;
    }

    public Float getMile() {
        return mile;
    }

    public void setMile(Float mile) {
        this.mile = mile;
    }

    public float mileDef0() {
        if (mile == null)
            return 0f;
        else
            return mile;
    }

    public Float getGas() {
        return gas;
    }

    public void setGas(Float gas) {
        this.gas = gas;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvNo() {
        return drvNo;
    }

    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    public TrkAddt getAddt() {
        return addt;
    }

    public void setAddt(TrkAddt addt) {
        this.addt = addt;
    }

    public short adasAlmSet(int alarmStateBitIndex) {
        int state;
        if (this.adasAlm != null)
            state = this.adasAlm;
        else
            state = 0;

        state = JTUtils.set(state, alarmStateBitIndex);
        this.adasAlm = (short) state;
        return (short) state;
    }

    public short adasAlmClear(int alarmStateBitIndex) {
        if (this.adasAlm == null)
            return 0;

        int state = this.adasAlm;

        state = JTUtils.clear(state, alarmStateBitIndex);
        this.adasAlm = (short) state;
        return (short) state;
    }

    protected TrkAddt prepareAddt() {
        if (addt == null) {
            addt = new TrkAddt();
            addt.setId(id);
        }

        return addt;
    }

    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        if (unusualDriveBehav == null)
            throw new NullPointerException();

        prepareAddt().setUnusualDriveBehav(unusualDriveBehav);
    }

    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDrivingAssistAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_DRIVING_ASSIST_ALARM);
    }

    public void setDriverBehavAlm(AdasDriverBehavAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDriverBehavAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_DRIVER_BEHAVIOR_ALARM);
    }

    public void setAdasTyreState(AdasTyreState tyreState) {
        if (tyreState == null)
            throw new NullPointerException();

        prepareAddt().setTyreState(tyreState);
        adasAlmSet(AdasAlarmBits.ADAS_TYRE_STATE);
    }

    public void setAdasBlindAreaAlarm(AdasBlindAreaAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setBlindArea(alm);
        adasAlmSet(AdasAlarmBits.ADAS_BLIND_AREA);
    }

    public void setAdasIntenseDrivingAlarm(AdasIntenseDrivingAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setIntenseDrivingAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_INTENSE_DRIVING_ALARM);
    }

    public void setAdasOverSpdAlarm(AdasOverSpdAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAdasOverSpd(alm);
        adasAlmSet(AdasAlarmBits.ADAS_OVER_SPEED_ALARM);
    }

    public void assignFrom(Trk source) {
        this.id = source.id;
        this.simNo = source.simNo;
        this.plateNo = source.plateNo;
        this.plateColor = source.plateColor;
        this.recvTm = source.recvTm;
        this.gpsTm = source.gpsTm;
        this.retrans = source.retrans;
        this.alm = source.alm;
        this.st = source.st;
        this.lng = source.lng;
        this.lat = source.lat;
        this.alt = source.alt;
        this.spd = source.spd;
        this.recSpd = source.recSpd;
        this.dir = source.dir;
        this.signal = source.signal;
        this.ioSt = source.ioSt;
        this.vidAlm = source.vidAlm;
        this.adasAlm = source.adasAlm;
        this.mile = source.mile;
        this.gas = source.gas;
        this.drvName = source.drvName;
        this.drvNo = source.drvNo;
        this.addt = source.addt != null ? source.addt.clone() : null;
    }

    @Override
    public Trk clone() {
        try {
            return (Trk) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static final DecimalFormat FLOAT_FORMAT = new DecimalFormat("0.#");

    private class Stringifier {
        private StringBuilder str = new StringBuilder();
        private boolean first = true;

        private void addF(String propName, Float value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(FLOAT_FORMAT.format(value));

                first = false;
            }
        }

        private void addAxis(String propName, Double value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(JTUtils.formatAxis(value));

                first = false;
            }
        }

        private void add(String propName, Object value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(value);

                first = false;
            }
        }

        public String stringifier() {
            str.append("Trk{");

            add("id", id);
            add("simNo", simNo);
            add("plateNo", plateNo);
            add("plateColor", plateColor);
            add("recvTm", recvTm);
            add("gpsTm", gpsTm);
            add("retrans", retrans);
            add("alm", alm);
            add("st", st);
            addAxis("lng", lng);
            addAxis("lat", lat);
            addF("spd", spd);
            addF("recSpd", recSpd);
            add("dir", dir);
            add("signal", signal);
            add("ioSt", ioSt);
            add("vidAlm", vidAlm);
            add("adasAlm", adasAlm);
            addF("mile", mile);
            addF("gas", gas);
            add("drvName", drvName);
            add("drvNo", drvNo);
            if (addt != null) {
                String s = JTConsts.GSON().toJson(addt);
                add("addt", s);
            }

            str.append("}");
            return str.toString();
        }


    }

    @Override
    public String toString() {
        Stringifier stringifier = new Stringifier();
        return stringifier.stringifier();

//        private String plateNo;
//        private Short plateColor;
//
//        private long recvTm;
//        private long gpsTm;
//
//        private Boolean retrans;
//
//        private int alm;
//        private int st;
//        private double lng;
//        private double lat;
//        private int alt;
//        private float spd;
//        private Float recSpd;
//        private int dir;
//
//        private Integer signal;
//        private Short ioSt;
//
//
//        private Integer vidAlm;
//        private Short adasAlm;
//
//        private Float mile;
//        private Float gas;
//
//        private String drvName;
//        private String drvNo;
//
//        private TrkAddt addt;
    }
}
