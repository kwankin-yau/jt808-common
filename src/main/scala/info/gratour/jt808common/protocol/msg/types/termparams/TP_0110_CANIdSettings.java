/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_0110_CANIdSettings {

    private int canId;
    private boolean calculated; // bit29
    private boolean extFrame; // bit30
    private boolean can2; // bit31
    private int samplingInterval;

    public int getCanId() {
        return canId;
    }

    public void setCanId(int canId) {
        this.canId = canId;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public boolean isExtFrame() {
        return extFrame;
    }

    public void setExtFrame(boolean extFrame) {
        this.extFrame = extFrame;
    }

    public boolean isCan2() {
        return can2;
    }

    public void setCan2(boolean can2) {
        this.can2 = can2;
    }

    public int getSamplingInterval() {
        return samplingInterval;
    }

    public void setSamplingInterval(int samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    @Override
    public String toString() {
        return "TP_0110_CANIdSettings{" +
                "canId=" + canId +
                ", calculated=" + calculated +
                ", extFrame=" + extFrame +
                ", can2=" + can2 +
                ", samplingInterval=" + samplingInterval +
                '}';
    }
}
