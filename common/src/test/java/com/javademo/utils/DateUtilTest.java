package com.javademo.utils;

import com.javademo.common.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateUtilTest implements Serializable {
    private final static Logger LOG = LoggerFactory.getLogger(DateUtilTest.class);

    @Test
    public void dateFormatTest() {
        LocalDateTime now = LocalDateTime.now();
        //时间格式化
        String commonDateTime = now.format(DateUtil.COMMON_FORMATTER);
        LOG.info(commonDateTime);
        ZonedDateTime defaultZone = now.atZone(ZoneId.systemDefault());
        String defaultZoneDateTime = defaultZone.format(DateUtil.ZONE_TIME_FORMAT);
        LOG.info(defaultZoneDateTime);
        ZonedDateTime gmtOffsetZone = now.atZone(ZoneId.of("GMT+8"));
        String gmtOffsetZoneDateTime = gmtOffsetZone.format(DateUtil.ZONE_TIME_FORMAT);
        LOG.info(gmtOffsetZoneDateTime);
        String utcDateTime = now.format(DateUtil.ISO_FORMATTER);
        LOG.info(utcDateTime);
        //字符串转时间
        assert LocalDateTime.parse("2022-07-06 18:39:36:843", DateUtil.COMMON_FORMATTER)
                .isEqual(LocalDateTime.parse("2022-07-06 18:39:36:843 HKT", DateUtil.ZONE_TIME_FORMAT))
                &&
                LocalDateTime.parse("2022-07-06 18:39:36:843", DateUtil.COMMON_FORMATTER)
                        .isEqual(LocalDateTime.parse("2022-07-06 18:39:36:843 HKT", DateUtil.ZONE_TIME_FORMAT))
                &&
                LocalDateTime.parse("2022-07-06 18:39:36:843 HKT", DateUtil.ZONE_TIME_FORMAT)
                        .isEqual(LocalDateTime.parse("2022-07-06 18:39:36:843 GMT+08:00", DateUtil.ZONE_TIME_FORMAT))
                &&
                LocalDateTime.parse("2022-07-06 18:39:36:843 GMT+08:00", DateUtil.ZONE_TIME_FORMAT)
                        .isEqual(LocalDateTime.parse("2022-07-06T18:39:36.843Z", DateUtil.ISO_FORMATTER));
    }

    @Test
    public void zoneConvert() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId cnZone = ZoneId.of("GMT+8");
        ZonedDateTime cnDateTime = now.atZone(cnZone);
        String cnTime = cnDateTime.format(DateUtil.COMMON_FORMATTER);
        ZoneId utcZone = ZoneId.of("UTC");
        String utcDateTime = DateUtil.zoneConvert(cnTime, cnZone, utcZone, DateUtil.COMMON_FORMATTER);
        LOG.info(cnTime);
        LOG.info(utcDateTime);
        assert DateUtil.zoneConvert(utcDateTime, utcZone, cnZone, DateUtil.COMMON_FORMATTER).equals(cnTime);
    }

    @Test
    public void zoneToUTC() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId cnZone = ZoneId.of("GMT+8");
        ZonedDateTime cnDateTime = now.atZone(cnZone);
        String cnTime = cnDateTime.format(DateUtil.COMMON_FORMATTER);
        String utcDateTime = DateUtil.zoneToUTC(cnTime, cnZone, DateUtil.COMMON_FORMATTER);
        LOG.info(cnTime);
        LOG.info(utcDateTime);
        assert cnTime.equals(DateUtil.utcToZone(utcDateTime, cnZone, DateUtil.COMMON_FORMATTER));
    }

    @Test
    public void getISOFormatDateTime() {
        String isoFormatDateTime = DateUtil.getISOFormatDateTime("2022-07-06 19:05:15:033", DateUtil.COMMON_FORMATTER);
        assert isoFormatDateTime.equals("2022-07-06T19:05:15.033Z");
    }

    @Test
    public void getAllTimeZones() {
        List<String> allTimeZones = DateUtil.getAllTimeZones();
        assert allTimeZones != null && !allTimeZones.isEmpty();
        LOG.info("Available ZoneIds {}", allTimeZones);
        for (String zoneId :
                allTimeZones) {
            assert zoneId != null;
        }
    }
    @Test
    public void testGetXXXStartDate(){
        LocalDate now = LocalDate.now();
        LOG.info("first day of year:{}",DateUtil.getYearStartDate(now, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LOG.info("first day of month:{}",DateUtil.getMonthStartDate(now,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LOG.info("first day of quarter:{}",DateUtil.getQuarterStartDate(now,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
