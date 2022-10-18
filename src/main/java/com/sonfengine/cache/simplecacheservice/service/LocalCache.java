package com.sonfengine.cache.simplecacheservice.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalCache {
    private static LocalCache instance;

    public static LocalCache getLocalCache() {
        if (instance == null){
            synchronized(LocalCache.class){
                instance = new LocalCache();
            }
        }
        return instance;
    }

    public <T> void set(String key, T value){
        CacheCore.put(key,value);
    }

    public <T> T get(String key, Class<T> tClass){
        return CacheCore.get(key,tClass);
    }

    public <T> void set(String key, T value, long expireToMillisecond){
        CacheCore.put(key,value);
        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                CacheCore.remove(key);
            }
        },expireToMillisecond);
    }

    public <T> void set(String key, T value, LocalDateTime expireAtTime){
        CacheCore.put(key,value);
        long delay = LocalDateTime.now().until(expireAtTime, ChronoUnit.MILLIS);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                CacheCore.remove(key);
            }
        },delay);
    }


}