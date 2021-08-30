/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public interface MQEventAddt {

    public static final String MSG_ID__ONLINE = "ONLINE";
    public static final String MSG_ID__OFFLINE = "OFFLINE";

    public static final String MSG_ID__0100_TERM_REGISTER = "0100";
    public static final String MSG_ID__0200_LOCATION = "0200";
    public static final String MSG_ID__0704_BATCH_LOCATION = "0704";
    public static final String MSG_ID__0301_EVENT_REPORT = "0301";
    public static final String MSG_ID__0303_INFO_DEMAND = "0303";
    public static final String MSG_ID__0701_WAY_BILL = "0701";
    public static final String MSG_ID__0702_DRIVER_IDENTITY = "0702";
    public static final String MSG_ID__0705_CAN_DATA = "0705";
    public static final String MSG_ID__0800_MULTI_MEDIA_EVENT = "0800";
    public static final String MSG_ID__0801_MULTI_MEDIA_DATA = "0801";
    public static final String MSG_ID__0900_PASS_THROUGH_UL = "0900";
    public static final String MSG_ID__1005_PASSENGER_TRAFFIC = "1005";
}
