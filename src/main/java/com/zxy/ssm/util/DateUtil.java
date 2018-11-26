package com.zxy.ssm.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 时间日期工具类
 * @date 2018/11/26 14:20
 */
public class DateUtil {

    /**
     * 日期时间匹配格式
     */
    public interface Pattern {
        //
        // 常规模式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyy-MM-dd
         */
        String DATE = "yyyy-MM-dd";
        /**
         * yyyy-MM-dd HH:mm:ss
         */
        String DATETIME = "yyyy-MM-dd HH:mm:ss";
        /**
         * yyyy-MM-dd HH:mm
         */
        String DATETIME_MM = "yyyy-MM-dd HH:mm";
        /**
         * yyyy-MM-dd HH:mm:ss.SSS
         */
        String DATETIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
        /**
         * HH:mm
         */
        String TIME = "HH:mm";
        /**
         * HH:mm:ss
         */
        String TIME_SS = "HH:mm:ss";

        //
        // 系统时间格式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyy/MM/dd
         */
        String SYS_DATE = "yyyy/MM/dd";
        /**
         * yyyy/MM/dd HH:mm:ss
         */
        String SYS_DATETIME = "yyyy/MM/dd HH:mm:ss";
        /**
         * yyyy/MM/dd HH:mm
         */
        String SYS_DATETIME_MM = "yyyy/MM/dd HH:mm";
        /**
         * yyyy/MM/dd HH:mm:ss.SSS
         */
        String SYS_DATETIME_SSS = "yyyy/MM/dd HH:mm:ss.SSS";

        //
        // 无连接符模式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyyMMdd
         */
        String NONE_DATE = "yyyyMMdd";
        /**
         * yyyyMMddHHmmss
         */
        String NONE_DATETIME = "yyyyMMddHHmmss";
        /**
         * yyyyMMddHHmm
         */
        String NONE_DATETIME_MM = "yyyyMMddHHmm";
        /**
         * yyyyMMddHHmmssSSS
         */
        String NONE_DATETIME_SSS = "yyyyMMddHHmmssSSS";
    }

    public static final String DEFAULT_PATTERN = Pattern.DATETIME;

    public static final String[] PARSE_PATTERNS = new String[]{
            Pattern.DATE,
            Pattern.DATETIME,
            Pattern.DATETIME_MM,
            Pattern.DATETIME_SSS,
            Pattern.SYS_DATE,
            Pattern.SYS_DATETIME,
            Pattern.SYS_DATETIME_MM,
            Pattern.SYS_DATETIME_SSS
    };

    /**
     * 格式化日期时间
     *
     * @param date 日期时间
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String format(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * 格式化日期
     *
     * @param date    日期(时间)
     * @param pattern 匹配模式 参考：{@link DateUtil.Pattern}
     * @return 格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        pattern = StringUtils.isNotBlank(pattern) ? pattern : DEFAULT_PATTERN;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 解析日期
     *
     * @param date 日期字符串
     * @return 解析后的日期 默认格式：yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return DateUtils.parseDate(date, PARSE_PATTERNS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析日期
     *
     * @param date    日期
     * @param pattern 格式 参考：{@link DateUtil.Pattern}
     * @return 解析后的日期，默认格式：yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDate(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        String[] parsePatterns;
        parsePatterns = StringUtils.isNotBlank(pattern) ? new String[]{pattern} : PARSE_PATTERNS;
        try {
            return DateUtils.parseDate(date, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间戳与字符串的缠缠绵绵 +
     * 获取系统时间(时间戳) +
     * date转时间戳
     * @author hiYuzu
     * @date 2018/11/22 10:43:57
     */
    /**
     * 时间戳转换成字符串（yyyy-MM-dd HH:mm:ss）
     * @param timestamp
     * @return
     */
    public static String timestampToString(Timestamp timestamp) {
        try {
            if (timestamp != null) {
                DateFormat dateFormat = new SimpleDateFormat(DEFAULT_PATTERN);
                return dateFormat.format(timestamp);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("转换日期失败，失败原因：" + e.getMessage());
            return null;
        }
    }
    /**
     * 将字符串转换成时间戳
     * @param datetime
     * @return
     */
    public static Timestamp stringToTimestampSecond(String datetime) {
        try {
            if (datetime != null && !datetime.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
                Date date = sdf.parse(datetime);
                return new Timestamp(date.getTime());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("转换日期失败，失败原因：" + e.getMessage());
            return null;
        }
    }
    /**
     * 按指定参数将字符串转换成时间戳
     * @param datetime
     * @param format
     * @return
     */
    public static Timestamp stringToTimestampFormat(String datetime,String format) {
        try {
            if (datetime != null && !datetime.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                Date date = sdf.parse(datetime);
                return new Timestamp(date.getTime());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("转换日期失败，失败原因：" + e.getMessage());
            return null;
        }
    }
    /**
     * 获取系统时间
     * @return
     */
    public static Timestamp getSystemDateTime(String pattern) {
        Date date = new Date();
        String dateTime = format(date, pattern);
        Timestamp timestamp = stringToTimestampSecond(dateTime);
        return timestamp;
    }
    /**
     * date to timestamp
     */
    public static Timestamp dateToTimestamp(Date date) {
        String dateTime = format(date, DEFAULT_PATTERN);
        Timestamp timestamp = stringToTimestampSecond(dateTime);
        return timestamp;
    }

}
