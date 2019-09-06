package org.zeason.corgi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.zeason.corgi.repository.MetaDataRepository;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/6 17:51
 */
@Service
public class MetaDataService {
    @Autowired
    MetaDataRepository metaDataRepository;

    public List<Map<String, Object>> getMetaData(String schema, String tableName) {
        List<Map<String, Object>> res = metaDataRepository.getMetaData(schema, tableName);
        if (CollectionUtils.isEmpty(res)) {
            return null;
        }
        return res;
    }
}
