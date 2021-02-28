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
public class LinkedHashMapTest {
    public static void main(String[] args) {
        // 1. LinkedHashMap 会维护 put 的键值对的相对顺序
        // 2. 维护最近使用的键值对，放在表头，表尾的键值对就是最久未使用的
        Map<Integer, Integer> map = new LinkedHashMap<>(3, 0.75F, true);

        map.put(5, 5);
        map.put(2, 2);
        map.put(9, 9);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("--------------------------------------");

        map.put(2, 10);
        map.get(5);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
