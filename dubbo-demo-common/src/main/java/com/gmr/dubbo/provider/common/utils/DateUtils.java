package com.gmr.dubbo.provider.common.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtils {

    private DateUtils() {}

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime today() {
        return LocalDateTime.now();
    }

    public static LocalDateTime yesterday() {
        LocalDateTime localDateTime = today();
        return localDateTime.minusDays(1);
    }

    public static LocalDateTime tomorrow() {
        LocalDateTime localDateTime = today();
        return localDateTime.plusDays(1);
    }

    public static LocalDateTime timestampToDateTime(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDateTime timestampToDateTime(Timestamp timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp.getTime());
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static long localDateToTimestamp(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(zone).toInstant();
        return instant.toEpochMilli();
    }

    public static long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static String dateToDateString(Date date) {
        return timestampToDateString(date.getTime());
    }

    public static String localDateTimeToDateString(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMATTER);
    }

    public static String timestampToDatetimeString(Long timestamp) {
        return timestampToDateTime(timestamp).format(DATE_TIME_FORMATTER);
    }

    public static String timestampToDateString(Long timestamp) {
        return timestampToDateTime(timestamp).format(DATE_FORMATTER);
    }

    public static String timestampToDatetimeString(Timestamp timestamp) {
        return timestampToDateTime(timestamp).format(DATE_TIME_FORMATTER);
    }

    public static String timestampToDateString(Timestamp timestamp) {
        return timestampToDateTime(timestamp).format(DATE_FORMATTER);
    }

    public static List<String> listDateStringDuring(Long from, Long to) {
        LocalDate startDate = timestampToDateTime(from).toLocalDate();
        LocalDate endDate = timestampToDateTime(to).toLocalDate();
        return listDateStringDuring(startDate, endDate);
    }

    public static List<String> listDateStringDuring(Timestamp from, Timestamp to) {
        return listDateStringDuring(from.getTime(), to.getTime());
    }

    public static List<String> listDateStringDuring(Date from, Date to) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = dateToLocalDateTime(from).toLocalDate();
        LocalDate endDate = dateToLocalDateTime(to).toLocalDate();
        while (!endDate.isBefore(startDate)) {
            list.add(startDate.format(DATE_FORMATTER));
            startDate = startDate.plusDays(1);
        }
        return list;
    }

    public static List<String> listDateStringDuring(LocalDate from, LocalDate to) {
        List<String> list = new ArrayList<>();
        while (!to.isBefore(from)) {
            list.add(from.format(DATE_FORMATTER));
            from = from.plusDays(1);
        }
        return list;
    }
}