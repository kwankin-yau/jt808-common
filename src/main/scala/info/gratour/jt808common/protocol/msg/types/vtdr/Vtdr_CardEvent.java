/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_CardEvent implements Cloneable {

    public static final int TYP_LOGIN = 1;
    public static final int TYP_LOGOUT = 2;

    private String time;
    private String licenseNo;
    private byte typ;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public Vtdr_CardEvent clone() {
        try {
            return (Vtdr_CardEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_CardEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("licenseNo='" + licenseNo + "'")
                .add("typ=" + typ)
                .toString();
    }
}
