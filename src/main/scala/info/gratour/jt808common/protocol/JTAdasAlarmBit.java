/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol;

import info.gratour.jtcommon.JTUtils;

import java.util.Locale;
import java.util.ResourceBundle;

class JTAdasAlarmNames {

    public static final String MESSAGE_KEY_DRIVING_ASSIST_ALM = "adas.driving_assist.0";
    public static final String MESSAGE_KEY_DRIVER_BEHAV_ALM = "adas.driver_behav.1";
    public static final String MESSAGE_KEY_TYRE_STATE_ALM = "adas.tyre_state.2";
    public static final String MESSAGE_KEY_BLIND_AREA_ALM = "adas.blind_area.3";
    public static final String MESSAGE_KEY_INTENSE_DRIVING_ALM = "adas.intense_driving.4";
    public static final String MESSAGE_KEY_OVER_SPD_ALM = "adas.over_spd.5";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_DRIVING_ASSIST_ALM,
            MESSAGE_KEY_DRIVER_BEHAV_ALM,
            MESSAGE_KEY_TYRE_STATE_ALM,
            MESSAGE_KEY_BLIND_AREA_ALM,
            MESSAGE_KEY_INTENSE_DRIVING_ALM,
            MESSAGE_KEY_OVER_SPD_ALM
    };

    private static String alarmMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static final ResourceBundle resourceBundle(Locale locale) {
      return ResourceBundle.getBundle("info.gratour.jt808common.protocol.adas-alarm-names", locale != null ? locale : Locale.getDefault());
    }

    static String getAlarmName(int bitIndex, Locale locale) {
        String key = alarmMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }

}

public enum JTAdasAlarmBit {

    DRIVING_ASSIST_ALM(0),
    DRIVER_BEHAV_ALM(1),
    TYRE_STATE_ALM(2),
    BLIND_AREA_ALM(3),
    INTENSE_DRIVING_ALM(4),
    OVER_SPD_ALM(5);

    private int index;

    JTAdasAlarmBit(int bitIndex) {
        this.index = bitIndex;
    }

    public int bitIndex() {
        return index;
    }

    public String alarmName(Locale locale) {
        return JTAdasAlarmNames.getAlarmName(index, locale);
    }

    public static String adasAlmText(int adasAlmBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JTAdasAlarmBit bit : values()) {
            if (JTUtils.test(adasAlmBits, bit.index)) {
                if (first)
                    first = false;
                else
                    str.append(',');
                str.append(bit.alarmName(locale));
            }
        }
        return str.toString();

    }

}


