package org.zeason.corgi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zeason.corgi.response.BaseResponse;
import org.zeason.corgi.response.Success;
import org.zeason.corgi.utils.FileUtils;
import org.zeason.corgi.utils.JdbcTypeUtils;
import org.zeason.corgi.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String className = generateName(tableName);
        File file = new File(fileLocation + "/" + className);
//        if (file.exists()) {
//
//        }
        Path path = Paths.get(className);
        String columnName;
        String columnComment;
        String dataType;
        String field;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.PUBLIC_CLASS + className + StringUtils.LEFT_PARENTHESIS);
        for (Map<String, Object> metaData : metaDataDTOs) {
            columnName = (String) metaData.get("COLUMN_NAME");
            columnComment = (String) metaData.get("COLUMN_COMMENT");
            dataType = (String) metaData.get("DATA_TYPE");
            field = JdbcTypeUtils.getType(dataType.toUpperCase());
            if (StringUtils.isNotEmpty(columnComment)) {
                sb.append(FileUtils.getAnnotation(columnComment));
            }
            sb.append(StringUtils.PRIVATE + field + StringUtils.BLANK + columnName + StringUtils.SEMICOLON);
        }

        byte[] strToBytes = sb.toString().getBytes();
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
