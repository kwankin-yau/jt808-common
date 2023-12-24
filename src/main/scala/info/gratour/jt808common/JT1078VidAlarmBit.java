/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common;


import info.gratour.jtcommon.JTUtils;

import java.util.Locale;
import java.util.ResourceBundle;

class JT1078VidAlarmNames {
    public static final String MESSAGE_KEY_VID_LOSS = "vid_alm.vid_loss.0";
    public static final String MESSAGE_KEY_VID_COVER = "vid_alm.vid_cover.1";
    public static final String MESSAGE_KEY_VID_STG_ALM = "vid_alm.stg_alm.2";
    public static final String MESSAGE_KEY_VID_OTHER_EQUIP_FAULT = "vid_alm.other_equip_fault.3";
    public static final String MESSAGE_KEY_PASSENGER_OVERLOAD = "vid_alm.passenger_overload.4";
    public static final String MESSAGE_KEY_UNUSUAL_DRIVE_BEHAV = "vid_alm.unusual_drive_behav.5";
    public static final String MESSAGE_KEY_SPECIAL_REC_STG_RUN_OUT = "vid_alm.spc_rec_stg_run_out.6";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_VID_LOSS,
            MESSAGE_KEY_VID_COVER,
            MESSAGE_KEY_VID_STG_ALM,
            MESSAGE_KEY_VID_OTHER_EQUIP_FAULT,
            MESSAGE_KEY_PASSENGER_OVERLOAD,
            MESSAGE_KEY_UNUSUAL_DRIVE_BEHAV,
            MESSAGE_KEY_SPECIAL_REC_STG_RUN_OUT
    };

    private static String alarmMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.video-alarm-names", locale != null ? locale : Locale.getDefault());
    }

    static String getAlarmName(int bitIndex, Locale locale) {
        String key = alarmMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }

}

public enum JT1078VidAlarmBit {

    VID_LOSS(0),
    VID_COVER(1),
    VID_STG_ALM(2),
    VID_OTHER_EQUIP_FAULT(3),
    PASSENGER_OVERLOAD(4),
    UNUSUAL_DRIVE_BEHAV(5),
    SPECIAL_REC_STG_RUN_OUT(6);



    private final int index;

    private JT1078VidAlarmBit(int index) {
        this.index = index;
    }

    public int bitIndex() {
        return index;
    }

    public String alarmName(Locale locale) {
        return JT1078VidAlarmNames.getAlarmName(index, locale);
    }

    public static String vidAlmText(int vidAlmBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT1078VidAlarmBit bit : values()) {
            if (JTUtils.test(vidAlmBits, bit.index)) {
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
