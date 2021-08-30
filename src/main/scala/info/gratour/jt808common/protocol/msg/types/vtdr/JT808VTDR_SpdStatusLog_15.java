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

public class JT808VTDR_SpdStatusLog_15 implements JT808VTDRDataBlock {
    private List<VTDR_LogRec> logRecords;

    public List<VTDR_LogRec> getLogRecords() {
        return logRecords;
    }

    public void setLogRecords(List<VTDR_LogRec> logRecords) {
        this.logRecords = logRecords;
    }

    public void addLogRecord(VTDR_LogRec logRec) {
        if (this.logRecords == null)
            this.logRecords = new ArrayList<>();

        this.logRecords.add(logRec);
    }

    public void assignFrom(JT808VTDR_SpdStatusLog_15 source) {
        if (source.logRecords != null) {
            this.logRecords = new ArrayList<>();

            for (VTDR_LogRec e : source.logRecords)
                this.logRecords.add(e.clone());
        } else
            this.logRecords = null;
    }

    @Override
    public JT808VTDR_SpdStatusLog_15 clone() {
        JT808VTDR_SpdStatusLog_15 r = new JT808VTDR_SpdStatusLog_15();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808VTDR_SpdStatusLog_15{" +
                "logRecords=" + logRecords +
                '}';
    }
}
