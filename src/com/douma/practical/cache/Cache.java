package com.douma.practical.cache;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public interface Cache<K, V> {
    V get(K key);

    void put(K key, V value);
}
