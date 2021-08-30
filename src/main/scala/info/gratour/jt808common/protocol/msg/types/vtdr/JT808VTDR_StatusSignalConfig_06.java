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

public class JT808VTDR_StatusSignalConfig_06 implements JT808VTDRDataBlock {

    private String dateTime;
    private List<VTDR_Status> status;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<VTDR_Status> getStatus() {
        return status;
    }

    public void setStatus(List<VTDR_Status> status) {
        this.status = status;
    }

    public boolean hasStatus() {
        return status != null && !status.isEmpty();
    }

    public void addStatus(VTDR_Status status) {
        if (this.status == null)
            this.status = new ArrayList<>();

        this.status.add(status);
    }

    public void assignFrom(JT808VTDR_StatusSignalConfig_06 source) {
        this.dateTime = source.dateTime;
        if (source.status != null) {
            this.status = new ArrayList<>();

            for (VTDR_Status e : source.status)
                this.status.add(e.clone());
        } else
            this.status = null;
    }

    @Override
    public JT808VTDR_StatusSignalConfig_06 clone() {
        JT808VTDR_StatusSignalConfig_06 r = new JT808VTDR_StatusSignalConfig_06();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808VTDR_StatusSignalConfig_06{" +
                "dateTime='" + dateTime + '\'' +
                ", status=" + status +
                '}';
    }
}
