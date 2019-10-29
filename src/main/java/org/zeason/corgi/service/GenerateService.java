package org.zeason.corgi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zeason.corgi.dto.MetaDataDTO;
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
        String fileName = className + ".java";

        String fileLocate = new File(".").getCanonicalPath() + fileLocation + fileName;
        Path path = Paths.get(fileLocate);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        MetaDataDTO dto = new MetaDataDTO();
        String type;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.PUBLIC_CLASS + className + StringUtils.LEFT_PARENTHESIS + "\r\n");
        for (Map<String, Object> metaData : metaDataDTOs) {
            dto.setColumn_name((String) metaData.get("COLUMN_NAME"));
            dto.setColumn_comment((String) metaData.get("COLUMN_COMMENT"));
            dto.setData_type((String) metaData.get("DATA_TYPE"));
            type = JdbcTypeUtils.getType(dto.getData_type().toUpperCase());
            if (StringUtils.isNotEmpty(dto.getColumn_comment())) {
                sb.append(FileUtils.getAnnotation(dto.getColumn_comment()));
            }
            sb.append(StringUtils.PRIVATE + type + StringUtils.BLANK + dto.getColumn_name() + StringUtils.SEMICOLON + "\r\n");
        }

        for (Map<String, Object> metaData : metaDataDTOs) {
            dto.setColumn_name((String) metaData.get("COLUMN_NAME"));
            dto.setData_type((String) metaData.get("DATA_TYPE"));
            type = JdbcTypeUtils.getType(dto.getData_type().toUpperCase());
            sb.append(FileUtils.getSet(className, dto.getColumn_name(), type));
        }
        sb.append(StringUtils.RIGHT_PARENTHESIS);

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
                StringUtils.toUpperCaseChar(++index, array);
            }
            index++;
        }
        StringUtils.toUpperCaseChar(0, array);
        String res = new String(array).replaceAll("_", "") + "DTO";
        return res;
    }
}
