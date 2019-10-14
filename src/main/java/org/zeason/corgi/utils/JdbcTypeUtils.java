package org.zeason.corgi.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/12 17:18
 */
public class JdbcTypeUtils {
    private Map<String, String> typeMap;

    private void init() {
        typeMap.put("CHAR", "String");
        typeMap.put("VARCHAR", "String");
        typeMap.put("LONGVARCHAR", "String");
        typeMap.put("NUMERIC", "BigDecimal");
        typeMap.put("DECIMAL", "BigDecimal");
        typeMap.put("BOOLEAN", "boolean");
        typeMap.put("TINYINT", "Byte");
        typeMap.put("SMALLINT", "short");
        typeMap.put("INTEGER", "INTEGER");
        typeMap.put("BIGINT", "Long");
        typeMap.put("DOUBLE", "Double");
        typeMap.put("DATE", "Date");
        typeMap.put("TIME", "Date");
        typeMap.put("TIMESTAMP", "Date");
    }

    public static String getType(String name) {
        if (CollectionUtils.isEmpty(name))
    }
}
