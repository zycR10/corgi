package org.zeason.corgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zeason.corgi.service.MetaDataService;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/6 16:28
 */
@RestController
@RequestMapping("/generate")
public class GenerateController {
    @Autowired
    MetaDataService metaDataService;

    @RequestMapping("/getMetaData")
    public List<Map<String, Object>> getMetaData(@RequestParam String schema, @RequestParam String tableName) {
        List<Map<String, Object>> metaDataDTO = metaDataService.getMetaData(schema, tableName);
        System.out.println(metaDataDTO);
        return metaDataDTO;
    }
}
