package com.douma.practical.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache1(int capacity, int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > capacity) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LRUCache1<Integer, Integer> cache =
                new LRUCache1<>(3, 3, 0.75F);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
        cache.put(2, 5);
        cache.put(5, 6);
        System.out.println(cache.get(4));
    }
}
