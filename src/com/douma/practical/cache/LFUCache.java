package com.douma.practical.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class LFUCache<K, V> implements Cache<K, V> {
    // 每个 key 对应的 value 的映射
    private Map<K, V> cache;
    // 每个 key 使用的次数
    private Map<K, Integer> keyToUsedCount;
    // 每个 count 对应的所有的 keys (按照最近使用的顺序组织)
    private Map<Integer, LinkedHashSet<K>> usedCountToKeys;

    private int capacity;

    // 记录整个缓存中所有 key 中使用最小的次数
    private int minUsedCount;

    public LFUCache() {
        cache = new HashMap<>();
        keyToUsedCount = new HashMap<>();
        usedCountToKeys = new HashMap<>();

        this.capacity = capacity;
        minUsedCount = 0;
    }

    @Override
    public V get(K key) {
        V value = cache.get(key);
        if (value == null) return null;

        // 维护这个 key 对应的 count
        int usedCount = keyToUsedCount.get(key);
        // 1. 从这个 key 目前对应的 count 的集合中删除掉这个 key
        usedCountToKeys.get(usedCount).remove(key);
        keyToUsedCount.put(key, usedCount + 1);

        // 2. 更新最小使用的次数
        // 如果当前的 usedCount 等于最小次数，
        // 并且当前的 usedCount 没有的 key，那么将最小次数加 1
        if (usedCount == minUsedCount
                && usedCountToKeys.get(usedCount).size() == 0) {
            minUsedCount++;
        }

        // 3. 将 key 记录到 usedCount + 1 中的集合中
        putUsedCount(key, usedCount + 1);

        return value;
    }

    private void putUsedCount(K key, int count) {
        if (!usedCountToKeys.containsKey(count)) {
            usedCountToKeys.put(count, new LinkedHashSet<>());
        }
        usedCountToKeys.get(count).add(key);
    }

    @Override
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // 更新 key 对应的 value 值
            cache.put(key, value);
            // 更新 key 对应的 count 值
            get(key);
            return;
        }

        if (cache.size() == capacity) {
            // 删除最少使用的 key
            K removeKey = usedCountToKeys.get(minUsedCount).iterator().next();
            usedCountToKeys.get(minUsedCount).remove(removeKey);
            cache.remove(removeKey);
            keyToUsedCount.remove(removeKey);
        }

        // 新增一个缓存中不存在的 key
        cache.put(key, value);
        keyToUsedCount.put(key, 1);

        // 将 key 记录到 minUsedCount 中的集合中
        minUsedCount = 1;
        putUsedCount(key, minUsedCount);
    }
}
