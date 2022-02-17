/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_PowerEvent implements Cloneable {

    public static final int TYP_POWER_ON = 1;
    public static final int TYP_POWER_OFF = 2;

    private String time;
    private byte typ;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public Vtdr_PowerEvent clone() {
        try {
            return (Vtdr_PowerEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_PowerEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("typ=" + typ)
                .toString();
    }
}
