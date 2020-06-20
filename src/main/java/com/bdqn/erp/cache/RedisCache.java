package com.bdqn.erp.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

public class RedisCache<K,V> implements Cache<K,V> {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Override
    public V get(K k) throws CacheException {

        return  (V) getRedisTemplate().opsForValue().get(k.toString());
    }

    @Override
    public V put(K k, V v) throws CacheException {
           getRedisTemplate().opsForValue().set(k.toString(),v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
    public RedisTemplate<String,Object> getRedisTemplate(){
          redisTemplate.setStringSerializer(new StringRedisSerializer());
          return redisTemplate;
    }
}
