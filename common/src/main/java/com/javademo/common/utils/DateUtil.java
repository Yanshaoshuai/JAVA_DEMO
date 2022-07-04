package com.javademo.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DateUtil {
    private DateUtil(){}
    /**
     * UTC时间格式
     */
    public static DateTimeFormatter UTC_FORMATTER=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /**
     * 普通时间格式
     */
    public static DateTimeFormatter COMMON_FORMATTER=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 获取所有时区
     * @return
     */
    public static List<String> getAllTimeZones(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        return availableZoneIds.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 格式转为UTC
     * @param dateTimeStr
     * @param formatter
     * @return
     */
    public static String getUtcFormatDateTime(String dateTimeStr,DateTimeFormatter formatter){
        return LocalDateTime.parse(dateTimeStr,formatter).format(UTC_FORMATTER);
    }

    /**
     * 时区转换
     * @param dateTimeStr
     * @param sourceZone
     * @param targetZone
     * @param formatter
     * @return
     */
    public static String zoneConvert(String dateTimeStr,String sourceZone,String targetZone,DateTimeFormatter formatter){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.parse(dateTimeStr, formatter), ZoneId.of(sourceZone));
        ZonedDateTime targetZoneDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(targetZone));
        return targetZoneDateTime.format(formatter);
    }

    /**
     * 时区转换到UTC
     * @param dateTimeStr
     * @param sourceZone
     * @param formatter
     * @return
     */
   public static String zoneToUTC(String dateTimeStr,String sourceZone,DateTimeFormatter formatter){
        return zoneConvert(dateTimeStr,sourceZone,"UTC",formatter);
   }

    public static void main(String[] args) {
        List<String> allTimeZones = getAllTimeZones();
        System.out.println(allTimeZones);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(COMMON_FORMATTER));
        System.out.println(getUtcFormatDateTime(now.format(COMMON_FORMATTER),COMMON_FORMATTER));
        System.out.println(zoneToUTC(now.format(COMMON_FORMATTER),"Asia/Shanghai",COMMON_FORMATTER));
    }
}
