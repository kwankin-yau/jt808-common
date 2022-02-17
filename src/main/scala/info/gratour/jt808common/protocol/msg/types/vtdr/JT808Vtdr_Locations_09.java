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

public class JT808Vtdr_Locations_09 implements JT808VtdrDataBlock {

    private List<Vtdr_LocationInfoPerHour> locations;

    public List<Vtdr_LocationInfoPerHour> getLocations() {
        return locations;
    }

    public void setLocations(List<Vtdr_LocationInfoPerHour> locations) {
        this.locations = locations;
    }

    public void addLocation(Vtdr_LocationInfoPerHour locationInfoPerHour) {
        if (this.locations == null)
            this.locations = new ArrayList<>();

        this.locations.add(locationInfoPerHour);
    }

    public void assignFrom(JT808Vtdr_Locations_09 source) {
        if (source.locations != null) {
            this.locations = new ArrayList<>();
            for (Vtdr_LocationInfoPerHour e : source.locations)
                this.locations.add(e.clone());
        } else
            this.locations = null;
    }

    @Override
    public JT808Vtdr_Locations_09 clone() {
        JT808Vtdr_Locations_09 r = new JT808Vtdr_Locations_09();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_Locations_09.class.getSimpleName() + "[", "]")
                .add("locations=" + locations)
                .toString();
    }
}
