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

public class VTDR_SpdRec implements Cloneable {

    private String startTime;
    private List<VTDR_SpdAndStatus> spdAndStatus;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<VTDR_SpdAndStatus> getSpdAndStatus() {
        return spdAndStatus;
    }

    public void setSpdAndStatus(List<VTDR_SpdAndStatus> spdAndStatus) {
        this.spdAndStatus = spdAndStatus;
    }

    public void addSpdAndStatus(VTDR_SpdAndStatus spdAndStatus) {
        if (this.spdAndStatus == null)
            this.spdAndStatus = new ArrayList<>();

        this.spdAndStatus.add(spdAndStatus);
    }

    public void assignFrom(VTDR_SpdRec source) {
        this.startTime = source.startTime;
        if (source.spdAndStatus != null) {
            this.spdAndStatus = new ArrayList<>();

            for (VTDR_SpdAndStatus e : source.spdAndStatus)
                this.spdAndStatus.add(e.clone());
        } else
            this.spdAndStatus = null;
    }

    @Override
    public VTDR_SpdRec clone() {
        VTDR_SpdRec r = new VTDR_SpdRec();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "VTDR_SpdRec{" +
                "startTime='" + startTime + '\'' +
                ", spdAndStatus=" + spdAndStatus +
                '}';
    }
}
