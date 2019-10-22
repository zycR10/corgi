package org.zeason.corgi.utils;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/21 23:05
 */
public class FileUtils {
    public static String getSet(String field, String type) {
        //todo
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.PUBLIC + type + StringUtils.BLANK + "get" +
                StringUtils.toUpperCaseChar(0, field.toCharArray()))
                .append(StringUtils.PARENTHESES + StringUtils.LEFT_PARENTHESIS)
                .append("\t\treturn this." + field + StringUtils.SEMICOLON)
                .append("\t" + StringUtils.RIGHT_PARENTHESIS);
        return sb.toString();
    }


    public static StringBuilder getAnnotation(String... content) {
        StringBuilder sb = new StringBuilder("\t/**\r\n");
        if (content.length != 0) {
            for (String line : content) {
                sb.append("\t").append(line).append("\r\n");
            }
        }
        sb.append("\t*/\r\n");
        return sb;
    }
}
