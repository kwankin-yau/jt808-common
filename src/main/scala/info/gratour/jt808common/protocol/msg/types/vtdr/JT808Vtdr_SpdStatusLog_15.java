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

public class JT808Vtdr_SpdStatusLog_15 implements JT808VtdrDataBlock {
    private List<Vtdr_LogRec> logRecords;

    public List<Vtdr_LogRec> getLogRecords() {
        return logRecords;
    }

    public void setLogRecords(List<Vtdr_LogRec> logRecords) {
        this.logRecords = logRecords;
    }

    public void addLogRecord(Vtdr_LogRec logRec) {
        if (this.logRecords == null)
            this.logRecords = new ArrayList<>();

        this.logRecords.add(logRec);
    }

    public void assignFrom(JT808Vtdr_SpdStatusLog_15 source) {
        if (source.logRecords != null) {
            this.logRecords = new ArrayList<>();

            for (Vtdr_LogRec e : source.logRecords)
                this.logRecords.add(e.clone());
        } else
            this.logRecords = null;
    }

    @Override
    public JT808Vtdr_SpdStatusLog_15 clone() {
        JT808Vtdr_SpdStatusLog_15 r = new JT808Vtdr_SpdStatusLog_15();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_SpdStatusLog_15.class.getSimpleName() + "[", "]")
                .add("logRecords=" + logRecords)
                .toString();
    }
}
