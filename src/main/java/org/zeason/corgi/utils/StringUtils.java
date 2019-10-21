package org.zeason.corgi.utils;


/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/15 23:15
 */
public class StringUtils {
    public static final String BLANK = " ";
    public static final String PUBLIC_CLASS = "public class ";
    public static final String PRIVATE = "private ";
    public static final String SEMICOLON = ";\r\n";
    public static final String LEFT_PARENTHESIS = "{\r\n";

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static String castToCamel(String str) {
        return "Camel";
    }

    public static boolean isNotEmpty(String columnComment) {
        return !isEmpty(columnComment);
    }
}
