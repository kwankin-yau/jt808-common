/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class VtdrCmdConsts {

    public static final byte QRY_VER_INFO_00 = 0x00;
    public static final byte QRY_DRIVER_INFO_01 = 0x01;
    public static final byte QRY_TIME_02 = 0x02;
    public static final byte QRY_MILEAGE_03 = 0x03;
    public static final byte QRY_PULSE_FACTOR_04 = 0x04;
    public static final byte QRY_VEH_INFO_05 = 0x05;
    public static final byte QRY_STATUS_SIGNAL_CONFIG_06 = 0x06;
    public static final byte QRY_ID_07 = 0x07;
    public static final byte QRY_SPD_RECORDS_08 = 0x08;
    public static final byte QRY_LOCATIONS_09 = 0X09;
    public static final byte QRY_ACCIDENT_POINTS_10 = 0x10;
    public static final byte QRY_DRIVE_OVER_TIME_11 = 0x11;
    public static final byte QRY_DRIVER_CARD_EVENTS_12 = 0x12;
    public static final byte QRY_POWER_EVENTS_13 = 0x13;
    public static final byte QRY_REV_EVENTS_14 = 0x14;
    public static final byte QRY_SPD_STATUS_LOG_15 = 0x15;
    public static final byte SET_VEH_INFO_82 = (byte) 0x82;
    public static final byte SET_INSTALL_DATE_83 = (byte) 0x83;
    public static final byte SET_STATUS_SIGNAL_CONFIG_84 = (byte) 0x84;
    public static final byte SET_TIME_C2 = (byte) 0xC2;
    public static final byte SET_PULSE_FACTOR_C3 = (byte) 0xC3;
    public static final byte SET_MILEAGE_C4 = (byte) 0xC4;
}
