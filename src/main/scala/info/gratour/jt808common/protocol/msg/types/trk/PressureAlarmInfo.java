package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jtcommon.JTUtils;

public class PressureAlarmInfo {

    public static final byte BIT__PRESS_VALUE = 0;
    public static final byte BIT__PRESS_TOO_HIGH = 1;
    public static final byte BIT__PRESS_TOO_LOW = 2;
    public static final byte BIT__TEMP_TOO_HIGH = 3;
    public static final byte BIT__SENSOR_FAILURE = 4;
    public static final byte BIT__PRESS_DISBALANCE = 5;
    public static final byte BIT__AIR_LEAK_SLOWLY = 6;
    public static final byte BIT__BATTERY_LOW = 7;

    private byte tyreNo;
    private short typ;
    private int press;
    private int temp;
    private int batt;

    public byte getTyreNo() {
        return tyreNo;
    }

    public void setTyreNo(byte tyreNo) {
        this.tyreNo = tyreNo;
    }

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public boolean hasAlm(int almBit) {
        return JTUtils.test(typ, almBit);
    }

    public int getPress() {
        return press;
    }

    public void setPress(int press) {
        this.press = press;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getBatt() {
        return batt;
    }

    public void setBatt(int batt) {
        this.batt = batt;
    }

    @Override
    public String toString() {
        return "PressureAlarmInfo{" +
                "tyreNo=" + tyreNo +
                ", typ=" + typ +
                ", press=" + press +
                ", temp=" + temp +
                ", batt=" + batt +
                '}';
    }
}
