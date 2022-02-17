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

public class Vtdr_SpdRec implements Cloneable {

    private String startTime;
    private List<Vtdr_SpdAndStatus> spdAndStatus;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Vtdr_SpdAndStatus> getSpdAndStatus() {
        return spdAndStatus;
    }

    public void setSpdAndStatus(List<Vtdr_SpdAndStatus> spdAndStatus) {
        this.spdAndStatus = spdAndStatus;
    }

    public void addSpdAndStatus(Vtdr_SpdAndStatus spdAndStatus) {
        if (this.spdAndStatus == null)
            this.spdAndStatus = new ArrayList<>();

        this.spdAndStatus.add(spdAndStatus);
    }

    public void assignFrom(Vtdr_SpdRec source) {
        this.startTime = source.startTime;
        if (source.spdAndStatus != null) {
            this.spdAndStatus = new ArrayList<>();

            for (Vtdr_SpdAndStatus e : source.spdAndStatus)
                this.spdAndStatus.add(e.clone());
        } else
            this.spdAndStatus = null;
    }

    @Override
    public Vtdr_SpdRec clone() {
        Vtdr_SpdRec r = new Vtdr_SpdRec();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_SpdRec.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("spdAndStatus=" + spdAndStatus)
                .toString();
    }
}
