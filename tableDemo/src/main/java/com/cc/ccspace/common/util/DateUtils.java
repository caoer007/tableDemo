package com.cc.ccspace.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**遵循阿里巴巴的开发规则 采用安全的写法获取日期格式 每个线程采用threadlocal获得一个属于自己的日期格式
 *
 * @AUTHOR CF
 * @DATE Created on 2017/3/14 15:56.
 */
public class DateUtils {
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}