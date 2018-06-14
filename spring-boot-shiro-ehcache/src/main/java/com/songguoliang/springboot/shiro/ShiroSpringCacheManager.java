package com.songguoliang.springboot.shiro;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-05 11:56
 */
public class ShiroSpringCacheManager implements CacheManager {

    private org.springframework.cache.CacheManager cacheManager;

    public ShiroSpringCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        org.springframework.cache.Cache cache = cacheManager.getCache(name);
        return new ShiroSpringCache<>(cache);
    }

    class ShiroSpringCache<K, V> implements Cache<K, V> {
        private org.springframework.cache.Cache springCache;

        public ShiroSpringCache(org.springframework.cache.Cache springCache) {
            if (springCache == null) {
                throw new IllegalArgumentException("Cache argument cannot be null.");
            }
            this.springCache = springCache;
        }

        @Override
        public V get(K key) throws CacheException {
            org.springframework.cache.Cache.ValueWrapper valueWrapper = springCache.get(key);
            if (valueWrapper != null) {
                return (V) valueWrapper.get();
            }
            return null;
        }

        @Override
        public V put(K key, V value) throws CacheException {
            V previous = get(key);
            springCache.put(key, value);
            return previous;
        }

        @Override
        public V remove(K key) throws CacheException {
            V previous = get(key);
            springCache.evict(key);
            return previous;
        }

        @Override
        public void clear() throws CacheException {
            springCache.clear();
        }

        @Override
        public int size() {
            Object nativeCache = springCache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                return ehcache.getSize();
            }
            throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
        }

        @Override
        public Set<K> keys() {
            Object nativeCache = springCache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                return new HashSet<>(ehcache.getKeys());
            }
            throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
        }

        @Override
        public Collection<V> values() {
            Object nativeCache = springCache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                List keys = ehcache.getKeys();
                Map<Object, Element> elementMap = ehcache.getAll(keys);
                List<Object> values = new ArrayList<>();
                for (Element element : elementMap.values()) {
                    values.add(element.getObjectValue());
                }
                return (Collection<V>) values;
            }
            throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
        }
    }

}
