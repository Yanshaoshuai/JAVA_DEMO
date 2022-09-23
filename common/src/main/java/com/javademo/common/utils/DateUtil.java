package com.javademo.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DateUtil {
    private DateUtil() {
    }

    /**
     * ISO时间格式
     * 2022-07-06T18:21:34.499Z
     */
    public static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /**
     * 普通时间格式
     * 2022-07-06 18:15:29:410
     */
    public static final DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 时区时间格式
     * 2022-07-06 18:15:29:410 GMT+08:00/2022-07-06 18:15:29:410 HKT
     */
    public static final DateTimeFormatter ZONE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS z");

    /**
     * 获取所有时区
     *
     * @return
     */
    public static List<String> getAllTimeZones() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        return availableZoneIds.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 格式转为ISO格式
     *
     * @param dateTimeStr
     * @param formatter
     * @return
     */
    public static String getISOFormatDateTime(String dateTimeStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateTimeStr, formatter).format(ISO_FORMATTER);
    }

    /**
     * 时区转换
     *
     * @param dateTimeStr
     * @param sourceZone
     * @param targetZone
     * @param formatter
     * @return
     */
    public static String zoneConvert(String dateTimeStr, ZoneId sourceZone, ZoneId targetZone, DateTimeFormatter formatter) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.parse(dateTimeStr, formatter), sourceZone);
        ZonedDateTime targetZoneDateTime = zonedDateTime.withZoneSameInstant(targetZone);
        return targetZoneDateTime.format(formatter);
    }

    /**
     * 时区转换到UTC
     *
     * @param dateTimeStr
     * @param sourceZone
     * @param formatter
     * @return
     */
    public static String zoneToUTC(String dateTimeStr, ZoneId sourceZone, DateTimeFormatter formatter) {
        return zoneConvert(dateTimeStr, sourceZone, ZoneId.of("UTC"), formatter);
    }

    public static String utcToZone(String dateTimeStr, ZoneId targetZone, DateTimeFormatter formatter) {
        return zoneConvert(dateTimeStr, ZoneId.of("UTC"), targetZone, formatter);
    }

    /**
     * 获取当年第一天
     */
    public static String getYearStartDate(LocalDate date,DateTimeFormatter formatter){
        return date.with(TemporalAdjusters.firstDayOfYear()).format(formatter);
    }
    /**
     * 获取当月第一天
     */
    public static String getMonthStartDate(LocalDate date,DateTimeFormatter formatter){
        return date.with(TemporalAdjusters.firstDayOfMonth()).format(formatter);
    }
    /**
     * 获取当季第一天
     */
    public static String getQuarterStartDate(LocalDate date,DateTimeFormatter formatter){
        return date.with(date.getMonth().firstMonthOfQuarter()).with(TemporalAdjusters.firstDayOfMonth()).format(formatter);
    }
}
