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

public class JT808VTDR_SpdRecords_08 implements JT808VTDRDataBlock {

    private List<VTDR_SpdRec> spdRecords;

    public List<VTDR_SpdRec> getSpdRecords() {
        return spdRecords;
    }

    public void setSpdRecords(List<VTDR_SpdRec> spdRecords) {
        this.spdRecords = spdRecords;
    }

    public void addSpdRec(VTDR_SpdRec spdRec) {
        if (this.spdRecords == null)
            this.spdRecords = new ArrayList<>();

        this.spdRecords.add(spdRec);
    }

    public void assignFrom(JT808VTDR_SpdRecords_08 source) {
        if (source.spdRecords != null) {
            this.spdRecords = new ArrayList<>();

            for (VTDR_SpdRec e : source.spdRecords)
                this.spdRecords.add(e.clone());
        } else
            this.spdRecords = null;
    }

    @Override
    public JT808VTDR_SpdRecords_08 clone() {
        JT808VTDR_SpdRecords_08 r = new JT808VTDR_SpdRecords_08();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808VTDR_SpdRecords_08{" +
                "spdRecords=" + spdRecords +
                '}';
    }
}
