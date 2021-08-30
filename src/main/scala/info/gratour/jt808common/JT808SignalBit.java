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

class JT808SignalNames {

    /**
     * 近光灯
     */
    public static final String MESSAGE_KEY_LOW_BEAMS = "signal.low_beams.0";

    /**
     * 远光灯
     */
    public static final String MESSAGE_KEY_HIGH_BEAMS = "signal.high_beams.1";

    /**
     * 右转向灯
     */
    public static final String MESSAGE_KEY_TURN_RIGHT = "signal.turn_right.2";

    /**
     * 左转向灯
     */
    public static final String MESSAGE_KEY_TURN_LEFT = "signal.turn_left.3";

    /**
     * 制动信号
     */
    public static final String MESSAGE_KEY_BRAKE = "signal.brake.4";

    /**
     * 倒车信号
     */
    public static final String MESSAGE_KEY_REVERSING = "signal.reversing.5";

    /**
     * 雾灯信号
     */
    public static final String MESSAGE_KEY_FOG_LAMPS = "signal.fog_lamps.6";

    /**
     * 示廓灯
     */
    public static final String MESSAGE_KEY_OUTLINE_MARKER_LAMPS = "signal.outline_marker_lamps.7";

    /**
     * 喇叭信号
     */
    public static final String MESSAGE_KEY_HORN = "signal.horn.8";

    /**
     * 空调状态
     */
    public static final String MESSAGE_KEY_AIR_CONDITIONER = "signal.air_conditioner.9";

    /**
     * 空档信号
     */
    public static final String MESSAGE_KEY_NEUTRAL = "signal.neutral.10";

    /**
     * 缓速器工作
     */
    public static final String MESSAGE_KEY_RETARDER = "signal.retarder.11";

    /**
     * ABS工作
     */
    public static final String MESSAGE_KEY_ABS = "signal.abs.12";

    /**
     * 加热器工作
     */
    public static final String MESSAGE_KEY_HEATER = "signal.heater.13";

    /**
     * 离合器工作
     */
    public static final String MESSAGE_KEY_CLUTCH = "signal.clutch.14";



    private static String signalMessageKey(int bitIndex) {
        switch (bitIndex) {
            case 0:
                return MESSAGE_KEY_LOW_BEAMS;

            case 1:
                return MESSAGE_KEY_HIGH_BEAMS;

            case 2:
                return MESSAGE_KEY_TURN_RIGHT;

            case 3:
                return MESSAGE_KEY_TURN_LEFT;

            case 4:
                return MESSAGE_KEY_BRAKE;

            case 5:
                return MESSAGE_KEY_REVERSING;

            case 6:
                return MESSAGE_KEY_FOG_LAMPS;

            case 7:
                return MESSAGE_KEY_OUTLINE_MARKER_LAMPS;

            case 8:
                return MESSAGE_KEY_HORN;

            case 9:
                return MESSAGE_KEY_AIR_CONDITIONER;

            case 10:
                return MESSAGE_KEY_NEUTRAL;

            case 11:
                return MESSAGE_KEY_RETARDER;

            case 12:
                return MESSAGE_KEY_ABS;

            case 13:
                return MESSAGE_KEY_HEATER;

            case 14:
                return MESSAGE_KEY_CLUTCH;

            default:
                return null;
        }
    }

    private static final ResourceBundle resourceBundle(Locale locale) {
      return ResourceBundle.getBundle("info.gratour.jt808common.protocol.signal-names", locale != null ? locale : Locale.getDefault());
    }

    public static String getSignalName(int bitIndex, Locale locale) {
        String key = signalMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }
}

public enum JT808SignalBit {

    /**
     * 近光灯
     */
    LOW_BEAMS(0),

    /**
     * 远光灯
     */
    HIGH_BEAMS(1),

    /**
     * 右转向灯
     */
    TURN_RIGHT(2),

    /**
     * 左转向灯
     */
    TURN_LEFT(3),

    /**
     * 制动信号
     */
    BRAKE(4),

    /**
     * 倒车信号
     */
    REVERSING(5),

    /**
     * 雾灯信号
     */
    FOG_LAMPS(6),

    /**
     * 示廓灯
     */
    OUTLINE_MARKER_LAMPS(7),

    /**
     * 喇叭信号
     */
    HORN(8),

    /**
     * 空调状态
     */
    AIR_CONDITIONER(9),

    /**
     * 空档信号
     */
    NEUTRAL(10),

    /**
     * 缓速器工作
     */
    RETARDER(11),

    /**
     * ABS工作
     */
    ABS(12),

    /**
     * 加热器工作
     */
    HEATER(13),

    /**
     * 离合器工作
     */
    CLUTCH(14);


    private int index;

    JT808SignalBit(int bitIndex) {
        this.index = bitIndex;
    }

    public int bitIndex() {
        return index;
    }

    public String signalName(Locale locale) {
        return JT808SignalNames.getSignalName(index, locale);
    }

    public static String vehSignalText(int vehSignalBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808SignalBit bit : values()) {
            if (JTUtils.test(vehSignalBits, bit.index)) {
                if (first)
                    first = false;
                else
                    str.append(";");
                str.append(bit.signalName(locale));
            }
        }

        return str.toString();
    }
}
