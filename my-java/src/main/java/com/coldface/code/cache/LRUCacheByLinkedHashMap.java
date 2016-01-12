package com.coldface.code.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类LRUCacheByLinkedHashMap.java的实现描述：使用LinkedHashMap实现LRU缓存
 * 
 * @author coldface 2016年1月8日 下午5:52:35
 */
public class LRUCacheByLinkedHashMap<K, V> {

    private static final float  hashTableLoadFactor = 0.75f;
    private LinkedHashMap<K, V> map;
    private int                 cacheSize;

    public LRUCacheByLinkedHashMap(int cacheSize) {
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int) Math.ceil(cacheSize / hashTableLoadFactor) + 1;
        map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor, true) {
            private static final long serialVersionUID = 1;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheByLinkedHashMap.this.cacheSize;
            }
        };
    }

    //add an entry to this cache.
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    //Clears the cache.
    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedEntries() {
        return map.size();
    }

    public synchronized Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(map.entrySet());
    }

    //测试
    public static void main(String[] args) {
        LRUCacheByLinkedHashMap<String, String> cache = new LRUCacheByLinkedHashMap<String, String>(3);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "true");
        //遍历元素
        for (Map.Entry<String, String> e : cache.getAll()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
        cache.put("4", "four");
        cache.put("5", "five");
        System.out.println("=================");
        //遍历元素
        for (Map.Entry<String, String> e : cache.getAll()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}
