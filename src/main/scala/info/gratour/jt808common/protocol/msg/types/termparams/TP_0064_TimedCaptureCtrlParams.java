/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;

public class TP_0064_TimedCaptureCtrlParams {

    private boolean[] chanEnabledFlags;
    private boolean[] chanStoredFlags;
    private byte timeUnit;
    private short interval;

    public boolean[] getChanEnabledFlags() {
        return chanEnabledFlags;
    }

    public void setChanEnabledFlags(boolean[] chanEnabledFlags) {
        this.chanEnabledFlags = chanEnabledFlags;
    }

    public boolean[] getChanStoredFlags() {
        return chanStoredFlags;
    }

    public void setChanStoredFlags(boolean[] chanStoredFlags) {
        this.chanStoredFlags = chanStoredFlags;
    }

    public boolean chanEnabled(int chanId) {
        if (chanId >= 1 && chanId <= 5) {
            int index = chanId - 1;
            if (index >= 0 && index < chanEnabledFlags.length)
                return chanEnabledFlags[index];
            else
                return false;
        } else
            return false;
    }

    public boolean chanStored(int chanId) {
        if (chanId >= 1 && chanId <= 5) {
            int index = chanId - 1;
            if (index >= 0 && index < chanStoredFlags.length)
                return chanStoredFlags[index];
            else
                return false;
        } else
            return false;
    }

    public byte getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(byte timeUnit) {
        this.timeUnit = timeUnit;
    }

    public short getInterval() {
        return interval;
    }

    public void setInterval(short interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "TP_0064_TimedCaptureCtrlParams{" +
                "chanEnabledFlags=" + Arrays.toString(chanEnabledFlags) +
                ", chanStoredFlags=" + Arrays.toString(chanStoredFlags) +
                ", timeUnit=" + timeUnit +
                ", interval=" + interval +
                '}';
    }
}
