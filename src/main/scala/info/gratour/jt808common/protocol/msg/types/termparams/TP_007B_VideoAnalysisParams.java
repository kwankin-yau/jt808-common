/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_007B_VideoAnalysisParams {


    private byte maxBoarding;
    private byte fatigueThreshold;

    public byte getMaxBoarding() {
        return maxBoarding;
    }

    public void setMaxBoarding(byte maxBoarding) {
        this.maxBoarding = maxBoarding;
    }

    public byte getFatigueThreshold() {
        return fatigueThreshold;
    }

    public void setFatigueThreshold(byte fatigueThreshold) {
        this.fatigueThreshold = fatigueThreshold;
    }

    @Override
    public String toString() {
        return "TP_007B_VideoAnalysisParams{" +
                "maxBoarding=" + maxBoarding +
                ", fatigueThreshold=" + fatigueThreshold +
                '}';
    }
}
