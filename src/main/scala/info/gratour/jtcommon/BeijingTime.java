/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtcommon;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class BeijingTime {

    public static final DateTimeFormatter CONVENIENT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final ZoneOffset ZONE_OFFSET = ZoneOffset.ofHours(8);

    public static String millisToString(long millis) {
        return Instant.ofEpochMilli(millis).atOffset(ZONE_OFFSET).format(CONVENIENT_FORMATTER);
    }

    public static long stringToMillis(String dateTime) {
        return LocalDateTime.parse(dateTime, CONVENIENT_FORMATTER).atOffset(ZONE_OFFSET).toInstant().toEpochMilli();
    }

    public static String secondsToString(long seconds) {
        return Instant.ofEpochSecond(seconds).atOffset(ZONE_OFFSET).format(CONVENIENT_FORMATTER);
    }

    public static long stringToSeconds(String dateTime) {
        return LocalDateTime.parse(dateTime, CONVENIENT_FORMATTER).atOffset(ZONE_OFFSET).toEpochSecond();
    }

    public static LocalDateTime stringToLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, CONVENIENT_FORMATTER);
    }
}
