package org.zeason.corgi.utils;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/21 23:05
 */
public class FileUtils {
    public static String getSet(String field, String type) {
        //todo
        return null;
    }

    public static StringBuilder getAnnotation(String... content) {
        StringBuilder sb = new StringBuilder("/**\r\n");
        if (content.length != 0) {
            for (String line : content) {
                sb.append(line).append("\r\n");
            }
        }
        sb.append("*/\r\n");
        return sb;
    }
}
