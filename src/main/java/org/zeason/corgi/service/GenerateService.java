package org.zeason.corgi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.zeason.corgi.response.BaseResponse;
import org.zeason.corgi.response.Success;
import org.zeason.corgi.utils.JdbcTypeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.JDBCType;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/9 23:25
 */
@Service
public class GenerateService {
    private final static Logger logger = LoggerFactory.getLogger(GenerateService.class);

    @Value("${file.location}")
    String fileLocation;

    public BaseResponse generate(List<Map<String, Object>> metaDataDTOs, String schema, String tableName) throws IOException {
        String fileName = generateName(tableName);
        File file = new File(fileLocation + "/" + fileName);
//        if (file.exists()) {
//
//        }
        String str = "Hello";
        Path path = Paths.get(fileName);
        String columnName;
        String columnComment;
        String field;
        StringBuilder sb = new StringBuilder();
        for(Map<String, Object> metaData : metaDataDTOs) {
            columnName = (String) metaData.get("COLUMN_NAME");
            columnComment = (String) metaData.get("COLUMN_COMMENT");
            field = JdbcTypeUtils.getType((String) metaData.get("DATA_TYPE"));
            sb.append("private " + field + columnName);
        }

        byte[] strToBytes = str.getBytes();
        Files.write(path, strToBytes);

        return new Success("succ");
    }

    private String generateName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return null;
        }
        int index = 0;
        char[] array = tableName.toCharArray();
        int length = array.length;
        char c;
        while (index < length) {
            c = array[index];
            if ('_' == c) {
                // check char is lowercase
                toUpperCaseChar(++index, array);
            }
            index++;
        }
        toUpperCaseChar(0, array);
        String res = new String(array).replaceAll("_", "") + "DTO.java";
        return res;
    }

    private void toUpperCaseChar(int index, char[] array) {
        char replace = array[index];
        if (replace >= 87 && replace <= 122) {
            replace -= 32;
            array[index] = replace;
        }
    }
}
