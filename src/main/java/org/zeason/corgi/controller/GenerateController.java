package org.zeason.corgi.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.zeason.corgi.gen_code.dto.TUserInfoDTO;
import org.zeason.corgi.response.BaseResponse;
import org.zeason.corgi.response.Fail;
import org.zeason.corgi.service.GenerateService;
import org.zeason.corgi.service.MetaDataService;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/6 16:28
 */
@RestController
@RequestMapping("/base")
public class GenerateController {
    private final static Logger logger = LoggerFactory.getLogger(GenerateController.class);

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    GenerateService generateService;

    @RequestMapping("/getMetaData")
    public List<Map<String, Object>> getMetaData(@RequestParam String schema, @RequestParam String tableName) {
        List<Map<String, Object>> metaDataDTO = metaDataService.getMetaData(schema, tableName);
        System.out.println(metaDataDTO);
        return metaDataDTO;
    }

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public BaseResponse generate(@RequestBody JSONObject data) {
        String schema = data.getString("scheme");
        String tableName = data.getString("tableName");
        List<Map<String, Object>> metaDataDTOs = metaDataService.getMetaData(schema, tableName);
        if (CollectionUtils.isEmpty(metaDataDTOs)) {
            return new Fail("return null");
        }
        BaseResponse res;
        try {
            res = generateService.generate(metaDataDTOs, schema, tableName);
        } catch (Exception e) {
            logger.info("generate file has exception", e);
            res = new Fail("exception : " + e.getMessage());
        }
        return res;
    }
}
