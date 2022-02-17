/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class JT808Vtdr_Mileage_03 implements JT808VtdrDataBlock {

    private String dateTime;
    private String installTime;
    private float initMile;
    private float mile;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public float getInitMile() {
        return initMile;
    }

    public void setInitMile(float initMile) {
        this.initMile = initMile;
    }

    public float getMile() {
        return mile;
    }

    public void setMile(float mile) {
        this.mile = mile;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_Mileage_03.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .add("installTime='" + installTime + "'")
                .add("initMile=" + initMile)
                .add("mile=" + mile)
                .toString();
    }

    @Override
    public JT808Vtdr_Mileage_03 clone() {
        try {
            return (JT808Vtdr_Mileage_03) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
