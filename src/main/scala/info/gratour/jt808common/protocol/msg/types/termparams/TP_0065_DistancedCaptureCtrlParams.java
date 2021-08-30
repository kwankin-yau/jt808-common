/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;

public class TP_0065_DistancedCaptureCtrlParams {

    private boolean[] chanEnabledFlags;
    private boolean[] chanStoredFlags;
    private byte distanceUnit;
    private short distance;

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

    public byte getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(byte distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public short getDistance() {
        return distance;
    }

    public void setDistance(short distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TP_0065_DistancedCaptureCtrlParams{" +
                "chanEnabledFlags=" + Arrays.toString(chanEnabledFlags) +
                ", chanStoredFlags=" + Arrays.toString(chanStoredFlags) +
                ", distanceUnit=" + distanceUnit +
                ", distance=" + distance +
                '}';
    }
}
