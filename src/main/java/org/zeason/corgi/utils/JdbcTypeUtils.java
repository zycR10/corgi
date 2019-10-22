package org.zeason.corgi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/12 17:18
 */
public class JdbcTypeUtils {
    private static Map<String, String> typeMap = new HashMap<>();

    private static void init() {
        typeMap.put("CHAR", "String");
        typeMap.put("VARCHAR", "String");
        typeMap.put("LONGVARCHAR", "String");
        typeMap.put("NUMERIC", "BigDecimal");
        typeMap.put("DECIMAL", "BigDecimal");
        typeMap.put("BOOLEAN", "boolean");
        typeMap.put("TINYINT", "Byte");
        typeMap.put("SMALLINT", "short");
        typeMap.put("INT", "Integer");
        typeMap.put("BIGINT", "Long");
        typeMap.put("DOUBLE", "Double");
        typeMap.put("DATE", "Date");
        typeMap.put("DATETIME", "Date");
        typeMap.put("TIME", "Date");
        typeMap.put("TIMESTAMP", "Date");
    }

    public static String getType(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        if (CollectionUtils.isEmpty(typeMap)) {
            init();
        }
        return typeMap.get(name);
    }
}
