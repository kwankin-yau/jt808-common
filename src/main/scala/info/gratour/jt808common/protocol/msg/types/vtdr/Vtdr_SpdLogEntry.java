/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_SpdLogEntry implements Cloneable {

    private short recSpd;
    private short refSpd;

    public short getRecSpd() {
        return recSpd;
    }

    public void setRecSpd(short recSpd) {
        this.recSpd = recSpd;
    }

    public short getRefSpd() {
        return refSpd;
    }

    public void setRefSpd(short refSpd) {
        this.refSpd = refSpd;
    }

    @Override
    public Vtdr_SpdLogEntry clone() {
        try {
            return (Vtdr_SpdLogEntry) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_SpdLogEntry.class.getSimpleName() + "[", "]")
                .add("recSpd=" + recSpd)
                .add("refSpd=" + refSpd)
                .toString();
    }
}
