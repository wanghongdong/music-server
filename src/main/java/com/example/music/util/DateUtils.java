package com.example.music.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 时间工具
 * @ClassPath com.example.music.util
 * @ClassName DateUtils
 * @Author whd
 * @Date 2021/7/28 15:37
 * @Version 1.0
 */
public class DateUtils {

    public static final String DEFAULT_TIME_STR = "1970-01-01 00:00:00";

    public static Date toDate(String dateStr){
        try {
            return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toDate(DEFAULT_TIME_STR);
    }


}
