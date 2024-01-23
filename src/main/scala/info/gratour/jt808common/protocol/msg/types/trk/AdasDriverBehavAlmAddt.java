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

import java.util.StringJoiner;

public class AdasDriverBehavAlmAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    /**
     * 疲劳驾驶报警
     */
    public static final byte TYP__FATIGUED = 1;

    /**
     * 接打手持电话报警
     */
    public static final byte TYP__PHONE_CALL = 2;

    /**
     * 抽烟报警报警
     */
    public static final byte TYP__SMOKE = 3;

    /**
     * 长时间不目视前方报警
     */
    public static final byte TYP__NO_LOOK_AHEAD = 4;

    /**
     * 未检测到驾驶员报警
     */
    public static final byte TYP__DRIVER_NOT_DETECTED = 5;

    /**
     * 双手同时脱离方向盘报警
     */
    public static final byte TYP__STEERING_WHEEL_NOT_HOLDING = 6;


    /**
     * 驾驶员行为监测功能失效报警
     */
    public static final byte TYP__DRIVER_BEHAV_ALM_FUNC_FAILURE = 7;

    /**
     * 未系安全带报警
     */
    public static final byte TYP__NOT_BELTING = 8;

    /**
     * 红外阻断型墨镜失效报警
     */
    public static final byte TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE = 0x0B;

    /**
     * 玩手机报警
     */
    public static final byte TYP__PLAY_SMART_PHONE = 0x0D;

    /**
     * 夜间禁行报警
     */
    public static final byte TYP__NIGHT_DRIVE_PROHIBITED = 0x0E;

    /**
     * 超时驾驶报警
     */
    public static final byte TYP__DRIVE_OVERTIME = 0x0F;

    /**
     * 自动抓拍事件
     */
    public static final byte TYP__AUTO_CAPTURE = 0x10;

    /**
     * 驾驶员变更事件
     */
    public static final byte TYP__DRIVER_CHANGED_EVENT = 0x11;

    /**
     * 驾驶员身份异常
     */
    public static final byte TYP__INVALID_DRIVER_ID = 0x12;

    /**
     * 点火抓拍事件
     */
    public static final byte TYP__IGNITED_CAPTURE = 0x14;

    /**
     * 探头遮挡报警（粤标）
     */
    public static final byte TYP__CAMERA_COVERED = (byte) 0xF0;

    /**
     * 不能识别或厂商自定义报警/事件类型
     */
    public static final byte TYP__CUSTOM = (byte) 0xFF;


    private int almId;
    private byte flag;
    private short typ;
    private short typ2;
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

    /**
     * Get the original protocol uploaded alarm type.
     *
     * @return the original protocol uploaded alarm type.
     */
    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * Get the mapped alarm type.
     *
     * @return the mapped alarm type.
     */

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
        return new StringJoiner(", ", AdasDriverBehavAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("typ2=" + typ2)
                .add("lvl=" + lvl)
                .add("fatigue=" + fatigue)
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
