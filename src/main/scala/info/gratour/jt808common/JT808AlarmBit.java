package info.gratour.jt808common;


import info.gratour.jtcommon.JTUtils;

import java.util.Locale;
import java.util.ResourceBundle;

class JT808AlarmNames {
    public static final String MESSAGE_KEY_PANIC = "alm.panic.0";
    public static final String MESSAGE_KEY_OVERSPEED = "alm.overspd.1";
    public static final String MESSAGE_KEY_FATIGUED = "alm.fatigued.2";
    public static final String MESSAGE_KEY_DANGER_EARLY_WARNING = "alm.danger_early_warn.3";
    public static final String MESSAGE_KEY_GNSS_FAILED = "alm.gnss_failed.4";
    public static final String MESSAGE_KEY_ANTENNA_CUT = "alm.antenna_cut.5";
    public static final String MESSAGE_KEY_ANTENNA_SHORT = "alm.antenna_short.6";
    public static final String MESSAGE_KEY_POWER_ALARM = "alm.power_alm.7";
    public static final String MESSAGE_KEY_POWER_FAILED = "alm.power_failed.8";
    public static final String MESSAGE_KEY_LCD_FAILED = "alm.led_failed.9";
    public static final String MESSAGE_KEY_TTS_FAILED = "alm.tts_failed.10";
    public static final String MESSAGE_KEY_CAMERA_FAILED = "alm.camera_failed.11";
    public static final String MESSAGE_KEY_ICCARD_FAILED = "alm.iccard_failed.12";
    public static final String MESSAGE_KEY_OVERSPEED_EARLY_WARNING = "alm.overspd_early_warn.13";
    public static final String MESSAGE_KEY_FATIGUED_EARLY_WARNING = "alm.fatigued_early_warn.14";
    public static final String MESSAGE_KEY_VIOLATED_2019 = "alm.violated.15";
    public static final String MESSAGE_KEY_TYRE_EARLY_WARNING_2019 = "alm.tyre_early_warn.16";
    public static final String MESSAGE_KEY_TURN_RIGHT_BLIND_AREA_2019 = "alm.turn_right_blind_area.17";
    public static final String MESSAGE_KEY_DRIVE_OVERTIME = "alm.drive_overtime.18";
    public static final String MESSAGE_KEY_PARK_OVERTIME = "alm.park_overtime.19";
    public static final String MESSAGE_KEY_REGION_EVENT = "alm.region_event.20";
    public static final String MESSAGE_KEY_ROUTE_EVENT = "alm.route_event.21";
    public static final String MESSAGE_KEY_ROAD_TIME_EVENT = "alm.road_time_event.22";
    public static final String MESSAGE_KEY_STRAY_PATH = "alm.stray_path.23";
    public static final String MESSAGE_KEY_VSS_FAILED = "alm.vss_failed.24";
    public static final String MESSAGE_KEY_FUEL_LEAK = "alm.fuel_leak.25";
    public static final String MESSAGE_KEY_STEAL = "alm.steal.26";
    public static final String MESSAGE_KEY_UNINTENDED_IGNITION = "alm.unintended_ignition.27";
    public static final String MESSAGE_KEY_UNINTENDED_MOTION = "alm.unintended_motion.28";
    public static final String MESSAGE_KEY_CRASH_EARLY_WARNING = "alm.crash_early_warn.29";
    public static final String MESSAGE_KEY_TURNOVER_EARLY_WARNING = "alm.turnover_early_warn.30";
    public static final String MESSAGE_KEY_UNINTENDED_OPEN_DOOR = "alm.unintended_open_door.31";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_PANIC,
            MESSAGE_KEY_OVERSPEED,
            MESSAGE_KEY_FATIGUED,
            MESSAGE_KEY_DANGER_EARLY_WARNING,
            MESSAGE_KEY_GNSS_FAILED,
            MESSAGE_KEY_ANTENNA_CUT,
            MESSAGE_KEY_ANTENNA_SHORT,
            MESSAGE_KEY_POWER_ALARM,
            MESSAGE_KEY_POWER_FAILED,
            MESSAGE_KEY_LCD_FAILED,
            MESSAGE_KEY_TTS_FAILED,
            MESSAGE_KEY_CAMERA_FAILED,
            MESSAGE_KEY_ICCARD_FAILED,
            MESSAGE_KEY_OVERSPEED_EARLY_WARNING,
            MESSAGE_KEY_FATIGUED_EARLY_WARNING,
            MESSAGE_KEY_VIOLATED_2019,
            MESSAGE_KEY_TYRE_EARLY_WARNING_2019,
            MESSAGE_KEY_TURN_RIGHT_BLIND_AREA_2019,
            MESSAGE_KEY_DRIVE_OVERTIME,
            MESSAGE_KEY_PARK_OVERTIME,
            MESSAGE_KEY_REGION_EVENT,
            MESSAGE_KEY_ROUTE_EVENT,
            MESSAGE_KEY_ROAD_TIME_EVENT,
            MESSAGE_KEY_STRAY_PATH,
            MESSAGE_KEY_VSS_FAILED,
            MESSAGE_KEY_FUEL_LEAK,
            MESSAGE_KEY_STEAL,
            MESSAGE_KEY_UNINTENDED_IGNITION,
            MESSAGE_KEY_UNINTENDED_MOTION,
            MESSAGE_KEY_CRASH_EARLY_WARNING,
            MESSAGE_KEY_TURNOVER_EARLY_WARNING,
            MESSAGE_KEY_UNINTENDED_OPEN_DOOR
    };

    private static String alarmMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.alarm-names", locale != null ? locale : Locale.getDefault());
    }

    static String getAlarmName(int bitIndex, Locale locale) {
        String key = alarmMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }
}

public enum JT808AlarmBit {

    PANIC(0),
    OVERSPEED(1),
    FATIGUED(2),
    DANGER_EARLY_WARNING(3),
    GNSS_FAILED(4),
    ANTENNA_CUT(5),
    ANTENNA_SHORT(6),
    POWER_ALARM(7),
    POWER_FAILED(8),
    LCD_FAILED(9),
    TTS_FAILED(10),
    CAMERA_FAILED(11),
    ICCARD_FAILED(12),
    OVERSPEED_EARLY_WARNING(13),
    FATIGUED_EARLY_WARNING(14),
    VIOLATED_2019(15),
    TYRE_EARLY_WARNING_2019(16),
    TURN_RIGHT_BLIND_AREA_2019(17),
    DRIVE_OVERTIME(18),
    PARK_OVERTIME(19),
    REGION_EVENT(20),
    ROUTE_EVENT(21),
    ROAD_TIME_EVENT(22),
    STRAY_PATH(23),
    VSS_FAILED(24),
    FUEL_LEAK(25),
    STEAL(26),
    UNINTENDED_IGNITION(27),
    UNINTENDED_MOTION(28),
    CRASH_EARLY_WARNING(29),
    TURNOVER_EARLY_WARNING(30),
    UNINTENDED_OPEN_DOOR(31);

    // BIT31 DEPRECATED IN 2019

    private int index;


    private JT808AlarmBit(int bitIndex) {
        index = bitIndex;
    }

    public int bitIndex() {
        return index;
    }

    public String alarmName(Locale locale) {
        return JT808AlarmNames.getAlarmName(index, locale);
    }

    public static String vehAlarmText(int vehAlarmBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808AlarmBit bit : values()) {
            if (JTUtils.test(vehAlarmBits, bit.index)) {
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
