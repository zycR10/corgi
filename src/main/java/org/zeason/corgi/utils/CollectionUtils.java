package org.zeason.corgi.utils;

import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/16 23:35
 */
public class CollectionUtils {
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }
}
