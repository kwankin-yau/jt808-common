/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Vtdr_LocationInfoPerHour implements Cloneable {

    private String startTime;
    private List<Vtdr_LocationAndSpd> locationAndSpd;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Vtdr_LocationAndSpd> getLocationAndSpd() {
        return locationAndSpd;
    }

    public void setLocationAndSpd(List<Vtdr_LocationAndSpd> locationAndSpd) {
        this.locationAndSpd = locationAndSpd;
    }

    public void addLcoationAndSpd(Vtdr_LocationAndSpd locationAndSpd) {
        if (this.locationAndSpd == null)
            this.locationAndSpd = new ArrayList<>();

        this.locationAndSpd.add(locationAndSpd);
    }

    public void assignFrom(Vtdr_LocationInfoPerHour source) {
        this.startTime = source.startTime;
        if (source.locationAndSpd != null) {
            this.locationAndSpd = new ArrayList<>();
            for (Vtdr_LocationAndSpd e : source.locationAndSpd)
                this.locationAndSpd.add(e.clone());
        } else
            this.locationAndSpd = null;
    }

    @Override
    public Vtdr_LocationInfoPerHour clone() {
        Vtdr_LocationInfoPerHour r = new Vtdr_LocationInfoPerHour();
        r.assignFrom(this);
        return  r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LocationInfoPerHour.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("locationAndSpd=" + locationAndSpd)
                .toString();
    }
}
