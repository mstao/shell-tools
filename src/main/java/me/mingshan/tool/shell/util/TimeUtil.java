package me.mingshan.tool.shell.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Provides common methods to operate time with JDK8.
 *
 * @author hanjuntao
 */
public class TimeUtil {
  private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE_24.formatter;

  private TimeUtil() {
    throw new UnsupportedOperationException("It's prohibited to create instances of the class.");
  }

  /**
   * Gets the current datetime by default format.
   *
   * @return the current datetime
   */
  public static String getCurrentDateTime() {
    return DEFAULT_DATE_TIME_FORMATTER.format(LocalDateTime.now());
  }

  /**
   * Gets the current datetime by specified format.
   *
   * @param format
   *          the specified format
   * @return the current datetime
   */
  public static String getCurrentDateTime(TimeFormat format) {
    return format.formatter.format(LocalDateTime.now());
  }

  /**
   * Formats a date-time into a date/time string by default format.
   *
   * @param time
   *          the time value to be formatted into a time string
   * @return the formatted time string
   */
  public static String format(LocalDateTime time) {
    return DEFAULT_DATE_TIME_FORMATTER.format(time);
  }

  /**
   * Formats a date-time into a date/time string by default format.
   *
   * @param date
   *          the time value to be formatted into a time string
   * @return the formatted time string
   */
  public static String format(Date date) {
    return DEFAULT_DATE_TIME_FORMATTER.format(date2LocalDateTime(date));
  }

  /**
   * Formats a date-time into a date/time string by default format.
   *
   * @param time
   *          the time value to be formatted into a time string
   * @param format
   *          the specified format
   * @return the formatted string
   */
  public static String format(LocalDateTime time, TimeFormat format) {
    return format.formatter.format(time);
  }

  /**
   * Formats a date-time into a date/time string by default format.
   *
   * @param date
   *          the time value to be formatted into a time string
   * @param format
   *          the specified format
   * @return the formatted string
   */
  public static String format(Date date, TimeFormat format) {
    return format.formatter.format(date2LocalDateTime(date));
  }

  /**
   * Obtains an instance of {@code LocalDateTime} from a text string using a
   * specific formatter.
   * <p>
   * The text is parsed using the formatter, returning a date-time.
   *
   * @param text
   *          the text to parse, not null
   * @return the parsed local date-time, not null
   */
  public static LocalDateTime parse(String text) {
    return LocalDateTime.parse(text, DEFAULT_DATE_TIME_FORMATTER);
  }

  /**
   * Obtains an instance of {@code LocalDateTime} from a text string using a
   * specific formatter.
   * <p>
   * The text is parsed using the formatter, returning a date-time.
   *
   * @param text
   *          the text to parse, not null
   * @param format
   *          the formatter to use, not null
   * @return the parsed local date-time, not null
   */
  public static LocalDateTime parse(String text, TimeFormat format) {
    return LocalDateTime.parse(text, format.formatter);
  }

  /**
   * LocalDateTime to Date
   * 
   * @param localDateTime the time value
   * @return the date
   */
  public static Date localDateTime2Date(LocalDateTime localDateTime) {
    ZoneId zoneId = ZoneId.systemDefault();
    // Combines this date-time with a time-zone to create a  ZonedDateTime.
    ZonedDateTime zdt = localDateTime.atZone(zoneId);
    return Date.from(zdt.toInstant());
  }

  /**
   * Date to LocalDateTime
   * 
   * @param date the date
   * @return the LocalDateTime
   */
  public static LocalDateTime date2LocalDateTime(Date date) {
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    return LocalDateTime.ofInstant(instant, zone);
  }

  /**
   * LocalDateTime to Date
   *
   * @param localDate the time value
   * @return the date
   */
  public static Date localDate2Date(LocalDate localDate) {
    ZoneId zoneId = ZoneId.systemDefault();
    // Combines this date-time with a time-zone to create a  ZonedDateTime.
    ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
    return Date.from(zdt.toInstant());
  }

  /**
   * Date to LocalDate
   *
   * @param date the date
   * @return the LocalDateTime
   */
  public static LocalDate date2LocalDate(Date date) {
    LocalDateTime localDateTime = date2LocalDateTime(date);
    return localDateTime.toLocalDate();
  }

  /**
   * 日期相隔天数
   *
   * @param startDateInclusive 开始时间
   * @param endDateExclusive 结束时间
   * @return 天数
   */
  public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
    return Period.between(startDateInclusive, endDateExclusive).getDays();
  }

  /**
   * 日期相隔天数
   *
   * @param startDateInclusive 开始时间
   * @param endDateExclusive 结束时间
   * @return 天数
   */
  public static int periodDays(Date startDateInclusive, Date endDateExclusive) {
    LocalDate startLocalDate = date2LocalDate(startDateInclusive);
    LocalDate endLocalDate = date2LocalDate(endDateExclusive);
    return Period.between(startLocalDate, endLocalDate).getDays();
  }

  /**
   * 传入时间是否在当天之前
   *
   * @param date 传入时间
   * @return {@code true}，传入时间在当天之前；{@code false}，传入时间在当天之后或是当天
   */
  public static boolean isBeforeToday(Date date) {
    LocalDate now = LocalDate.now();
    return date2LocalDate(date).isBefore(now);
  }

  /**
   * 传入时间是否在当天之后
   *
   * @param date 传入时间
   * @return {@code true}，传入时间在当天之后；{@code false}，传入时间在当天之前或当天
   */
  public static boolean isAfterToday(Date date) {
    LocalDate now = LocalDate.now();
    return date2LocalDate(date).isAfter(now);
  }

  /**
   * The format of time
   */
  public enum TimeFormat {

    /**
     * Short time format - just 6 bit
     */
    SHORT_DATE_PATTERN_NONE_6("yyMMdd"),
    SHORT_DATE_PATTERN_LINE_6("yy-MM-dd"),
    SHORT_DATE_PATTERN_SLASH_6("yy/MM/dd"),
    SHORT_DATE_PATTERN_DOUBLE_SLASH_6("yy\\MM\\dd"),

    /**
     * Short time format
     */
    SHORT_DATE_PATTERN_NONE("yyyyMMdd"),
    SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
    SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
    SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),

    /**
     * Short time format - 12 clock
     */
    SHORT_HMS_DATE_PATTERN_NONE_12("hh:mm:ss"),
    SHORT_HMS_DATE_PATTERN_LINE_12("hhmmss"),

    /**
     * Short time format - 24 clock
     */
    SHORT_HMS_DATE_PATTERN_NONE_24("HH:mm:ss"),
    SHORT_HMS_DATE_PATTERN_LINE_24("HHmmss"),

    /**
     * Long time format, 12-hour clock
     */
    LONG_DATE_PATTERN_NONE_12("yyyyMMdd hh:mm:ss"),
    LONG_DATE_PATTERN_LINE_12("yyyy-MM-dd hh:mm:ss"),
    LONG_DATE_PATTERN_SLASH_12("yyyy/MM/dd hh:mm:ss"),
    LONG_DATE_PATTERN_DOUBLE_SLASH_12("yyyy\\MM\\dd hh:mm:ss"),

    /**
     * Long time format, 24-hour clock
     */
    LONG_DATE_PATTERN_NONE_24("yyyyMMdd HH:mm:ss"),
    LONG_DATE_PATTERN_LINE_24("yyyy-MM-dd HH:mm:ss"),
    LONG_DATE_PATTERN_SLASH_24("yyyy/MM/dd HH:mm:ss"),
    LONG_DATE_PATTERN_DOUBLE_SLASH_24("yyyy\\MM\\dd HH:mm:ss"),

    /**
     * Long time format with millisecond , 12-hour clock
     */
    LONG_DATE_PATTERN_WITH_MILSEC_LINE_12("yyyy-MM-dd hh:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_SLASH_12("yyyy/MM/dd hh:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH_12("yyyy\\MM\\dd hh:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_NONE_12("yyyyMMdd hh:mm:ss.SSS"),

    /**
     * Long time format with millisecond , 24-hour clock
     */
    LONG_DATE_PATTERN_WITH_MILSEC_LINE_24("yyyy-MM-dd HH:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_SLASH_24("yyyy/MM/dd HH:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH_24("yyyy\\MM\\dd HH:mm:ss.SSS"),
    LONG_DATE_PATTERN_WITH_MILSEC_NONE_24("yyyyMMdd HH:mm:ss.SSS");

    private transient DateTimeFormatter formatter;

    TimeFormat(String pattern) {
      this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

  }

}
