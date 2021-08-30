/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_F367_BlindMonitorParams {
    private byte rearDistanceAlarmTimeThreshold;
    private byte sideDistanceAlarmTimeThreshold;

    public byte getRearDistanceAlarmTimeThreshold() {
        return rearDistanceAlarmTimeThreshold;
    }

    public void setRearDistanceAlarmTimeThreshold(byte rearDistanceAlarmTimeThreshold) {
        this.rearDistanceAlarmTimeThreshold = rearDistanceAlarmTimeThreshold;
    }

    public byte getSideDistanceAlarmTimeThreshold() {
        return sideDistanceAlarmTimeThreshold;
    }

    public void setSideDistanceAlarmTimeThreshold(byte sideDistanceAlarmTimeThreshold) {
        this.sideDistanceAlarmTimeThreshold = sideDistanceAlarmTimeThreshold;
    }

    @Override
    public String toString() {
        return "TP_F367_BlindMonitorParams{" +
                "rearDistanceAlarmTimeThreshold=" + rearDistanceAlarmTimeThreshold +
                ", sideDistanceAlarmTimeThreshold=" + sideDistanceAlarmTimeThreshold +
                '}';
    }
}
