/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_LocationAndSpd implements Cloneable {

    private Vtdr_Location location;
    private short spd;

    public Vtdr_Location getLocation() {
        return location;
    }

    public void setLocation(Vtdr_Location location) {
        this.location = location;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public void assignFrom(Vtdr_LocationAndSpd source) {
        this.location = source.location != null ? source.location.clone() : null;
        this.spd = source.spd;
    }

    @Override
    public Vtdr_LocationAndSpd clone() {
        try {
            return (Vtdr_LocationAndSpd) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LocationAndSpd.class.getSimpleName() + "[", "]")
                .add("location=" + location)
                .add("spd=" + spd)
                .toString();
    }
}
