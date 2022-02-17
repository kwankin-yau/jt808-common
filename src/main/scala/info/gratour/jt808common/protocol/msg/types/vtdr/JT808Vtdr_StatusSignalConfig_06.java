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

public class JT808Vtdr_StatusSignalConfig_06 implements JT808VtdrDataBlock {

    private String dateTime;
    private List<Vtdr_Status> status;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Vtdr_Status> getStatus() {
        return status;
    }

    public void setStatus(List<Vtdr_Status> status) {
        this.status = status;
    }

    public boolean hasStatus() {
        return status != null && !status.isEmpty();
    }

    public void addStatus(Vtdr_Status status) {
        if (this.status == null)
            this.status = new ArrayList<>();

        this.status.add(status);
    }

    public void assignFrom(JT808Vtdr_StatusSignalConfig_06 source) {
        this.dateTime = source.dateTime;
        if (source.status != null) {
            this.status = new ArrayList<>();

            for (Vtdr_Status e : source.status)
                this.status.add(e.clone());
        } else
            this.status = null;
    }

    @Override
    public JT808Vtdr_StatusSignalConfig_06 clone() {
        JT808Vtdr_StatusSignalConfig_06 r = new JT808Vtdr_StatusSignalConfig_06();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_StatusSignalConfig_06.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .add("status=" + status)
                .toString();
    }
}
