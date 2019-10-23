package org.zeason.corgi.utils;


/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/15 23:15
 */
public class StringUtils {
    public static final String BLANK = " ";
    public static final String PUBLIC_CLASS = "public class ";
    public static final String PUBLIC = "\tpublic ";
    public static final String PRIVATE = "\tprivate ";
    public static final String SEMICOLON = ";\r\n";
    public static final String PARENTHESES = "()";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String EQUAL = " = ";
    public static final String LEFT_PARENTHESIS = " {\r\n";
    public static final String RIGHT_PARENTHESIS = "}\r\n";

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static String castToCamel(String str) {
        return "Camel";
    }

    public static boolean isNotEmpty(String columnComment) {
        return !isEmpty(columnComment);
    }

    public static String toUpperCaseChar(int index, char[] array) {
        char replace = array[index];
        if (replace >= 87 && replace <= 122) {
            replace -= 32;
            array[index] = replace;
        }
        return new String(array);
    }
}
