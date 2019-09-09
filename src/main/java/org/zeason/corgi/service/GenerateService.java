package org.zeason.corgi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.zeason.corgi.response.BaseResponse;
import org.zeason.corgi.response.Success;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/9 23:25
 */
@Service
public class GenerateService {
    @Value("${file.location}")
    String fileLocation;

    public BaseResponse generate(List<Map<String, Object>> metaDataDTOs, String schema, String tableName) {
        String fileName = generateName(tableName);
        File file = new File(fileLocation + "/" + fileName);
//        if (file.exists()) {
//
//        }
        for (Map map : metaDataDTOs) {

        }
        return new Success("succ");
    }

    private String generateName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return null;
        }
        // regex
        String res = tableName.replaceAll("", "");
        return res;
    }
}
