/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class VTDR_LocationAndSpd implements Cloneable {

    private VTDR_Location location;
    private short spd;

    public VTDR_Location getLocation() {
        return location;
    }

    public void setLocation(VTDR_Location location) {
        this.location = location;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public void assignFrom(VTDR_LocationAndSpd source) {
        this.location = source.location != null ? source.location.clone() : null;
        this.spd = source.spd;
    }

    @Override
    public VTDR_LocationAndSpd clone() {
        try {
            return (VTDR_LocationAndSpd) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "VTDR_LocationAndSpd{" +
                "location=" + location +
                ", spd=" + spd +
                '}';
    }
}
