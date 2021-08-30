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

public class VTDR_LocationInfoPerHour implements Cloneable {

    private String startTime;
    private List<VTDR_LocationAndSpd> locationAndSpd;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<VTDR_LocationAndSpd> getLocationAndSpd() {
        return locationAndSpd;
    }

    public void setLocationAndSpd(List<VTDR_LocationAndSpd> locationAndSpd) {
        this.locationAndSpd = locationAndSpd;
    }

    public void addLcoationAndSpd(VTDR_LocationAndSpd locationAndSpd) {
        if (this.locationAndSpd == null)
            this.locationAndSpd = new ArrayList<>();

        this.locationAndSpd.add(locationAndSpd);
    }

    public void assignFrom(VTDR_LocationInfoPerHour source) {
        this.startTime = source.startTime;
        if (source.locationAndSpd != null) {
            this.locationAndSpd = new ArrayList<>();
            for (VTDR_LocationAndSpd e : source.locationAndSpd)
                this.locationAndSpd.add(e.clone());
        } else
            this.locationAndSpd = null;
    }

    @Override
    public VTDR_LocationInfoPerHour clone() {
        VTDR_LocationInfoPerHour r = new VTDR_LocationInfoPerHour();
        r.assignFrom(this);
        return  r;
    }

    @Override
    public String toString() {
        return "VTDR_LocationInfoPerHour{" +
                "startTime='" + startTime + '\'' +
                ", locationAndSpd=" + locationAndSpd +
                '}';
    }
}
