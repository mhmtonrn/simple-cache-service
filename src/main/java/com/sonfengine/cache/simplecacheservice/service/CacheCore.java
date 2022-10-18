package com.sonfengine.cache.simplecacheservice.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * cache core class
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheCore {
    private static Map<String,Object> cache = new ConcurrentHashMap<>();

    public static  <T> T get(String key, Class<T> tClass){
        return tClass.cast(cache.get(key));
    }

    public static <T> void put(String key, T value){
        cache.put(key,value);
    }

    public static void remove(String key){
        System.out.println("removed "+key);
        cache.remove(key);
    }
}