package org.zeason.corgi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/6 16:26
 */
@Repository
public class MetaDataRepository {
    private final static String selectMetaData = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.columns " +
            "WHERE TABLE_SCHEMA = ? " +
            "and TABLE_NAME = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getMetaData(String schema, String tableName) {
        return jdbcTemplate.queryForList(selectMetaData, schema, tableName);
    }
}
