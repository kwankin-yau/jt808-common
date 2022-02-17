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

public class Vtdr_LogRec implements Cloneable {

    private byte spdState;
    private String startTime;
    private String endTime;
    private List<Vtdr_SpdLogEntry> spdLogEntries;

    public byte getSpdState() {
        return spdState;
    }

    public void setSpdState(byte spdState) {
        this.spdState = spdState;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Vtdr_SpdLogEntry> getSpdLogEntries() {
        return spdLogEntries;
    }

    public void setSpdLogEntries(List<Vtdr_SpdLogEntry> spdLogEntries) {
        this.spdLogEntries = spdLogEntries;
    }

    public void addSpdLogEntry(Vtdr_SpdLogEntry entry) {
        if (this.spdLogEntries == null)
            this.spdLogEntries = new ArrayList<>();

        this.spdLogEntries.add(entry);
    }

    public void assignFrom(Vtdr_LogRec source) {
        this.spdState = source.spdState;
        this.startTime = source.startTime;
        this.endTime = source.endTime;

        if (source.spdLogEntries != null) {
            this.spdLogEntries = new ArrayList<>();

            for (Vtdr_SpdLogEntry e : source.spdLogEntries)
                this.spdLogEntries.add(e.clone());
        } else
            this.spdLogEntries = null;
    }

    @Override
    public Vtdr_LogRec clone() {
        try {
            return (Vtdr_LogRec) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LogRec.class.getSimpleName() + "[", "]")
                .add("spdState=" + spdState)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("spdLogEntries=" + spdLogEntries)
                .toString();
    }
}
