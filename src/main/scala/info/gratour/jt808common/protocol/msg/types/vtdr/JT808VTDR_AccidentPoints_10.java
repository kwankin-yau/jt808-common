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

public class JT808VTDR_AccidentPoints_10 implements JT808VTDRDataBlock {

    private List<VTDR_AccidentPoint> accidentPoints;

    public List<VTDR_AccidentPoint> getAccidentPoints() {
        return accidentPoints;
    }

    public void setAccidentPoints(List<VTDR_AccidentPoint> accidentPoints) {
        this.accidentPoints = accidentPoints;
    }

    public void addAccidentPoint(VTDR_AccidentPoint accidentPoint) {
        if (this.accidentPoints == null)
            this.accidentPoints = new ArrayList<>();

        this.accidentPoints.add(accidentPoint);
    }

    public void assignFrom(JT808VTDR_AccidentPoints_10 source) {
        if (source.accidentPoints != null) {
            this.accidentPoints = new ArrayList<>();

            for (VTDR_AccidentPoint p : source.accidentPoints) {
                this.accidentPoints.add(p.clone());
            }
        } else
            this.accidentPoints = null;
    }

    @Override
    public JT808VTDR_AccidentPoints_10 clone() {
        JT808VTDR_AccidentPoints_10 r = new JT808VTDR_AccidentPoints_10();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808VTDR_AccidentPoints{" +
                "accidentPoints=" + accidentPoints +
                '}';
    }
}
