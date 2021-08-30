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

public class JT808VTDR_DriveOverTime_11 implements JT808VTDRDataBlock {
    private List<VTDR_DriveOverTimeEntry> driveOverTimes;

    public List<VTDR_DriveOverTimeEntry> getDriveOverTimes() {
        return driveOverTimes;
    }

    public void setDriveOverTimes(List<VTDR_DriveOverTimeEntry> driveOverTimes) {
        this.driveOverTimes = driveOverTimes;
    }

    public void addDriveOverTimeEntry(VTDR_DriveOverTimeEntry driveOverTimeEntry) {
        if (this.driveOverTimes == null)
            this.driveOverTimes = new ArrayList<>();

        this.driveOverTimes.add(driveOverTimeEntry);
    }

    public void assignFrom(JT808VTDR_DriveOverTime_11 source) {
        if (source.driveOverTimes != null) {
            this.driveOverTimes = new ArrayList<>();

            for (VTDR_DriveOverTimeEntry e : source.driveOverTimes)
                this.driveOverTimes.add(e.clone());
        } else
            this.driveOverTimes = null;
    }

    @Override
    public String toString() {
        return "JT808VTDR_DriveOverTime_11{" +
                "driveOverTimes=" + driveOverTimes +
                '}';
    }

    @Override
    public JT808VTDR_DriveOverTime_11 clone() {
        JT808VTDR_DriveOverTime_11 r = new JT808VTDR_DriveOverTime_11();
        r.assignFrom(this);
        return r;
    }
}
