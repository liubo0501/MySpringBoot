package com.anbot.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataCache {
    /**
     *  token缓存
     */
    public static Map<String, String> tokenMap = new ConcurrentHashMap<>();
}
