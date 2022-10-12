package com.sonfengine.cache.simplecacheservice.api;

import com.softengine.cache.core.LocalCache;
import com.sonfengine.cache.simplecacheservice.model.CacheModel;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/cache")
@Slf4j
@ToString
public class CacheApi {

    @PostMapping
    public void set(@Validated @RequestBody CacheModel model){
        log.warn("{}",model);
        LocalCache cache = LocalCache.getLocalCache();
        if (Objects.nonNull(model.getExpireAtMillisecond())&& model.getExpireAtMillisecond()>10){
            cache.set(model.getKey(),model.getValue(),model.getExpireAtMillisecond());
        }else if (Objects.nonNull(model.getExpireAtTime())&& model.getExpireAtTime().compareTo(LocalDateTime.now())>0){
            cache.set(model.getKey(),model.getValue(),model.getExpireAtTime());
        }else{
            cache.set(model.getKey(),model.getValue());
        }

    }
    @GetMapping("/{key}")
    public String get(@PathVariable("key") String key){
        LocalCache cache = LocalCache.getLocalCache();
       return cache.get(key,String.class);
    }
    @GetMapping
    public Set<String> get(){
        return LocalCache.getLocalCache().getKeySet();
    }

}
