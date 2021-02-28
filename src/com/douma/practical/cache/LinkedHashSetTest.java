package com.douma.practical.cache;

import java.util.*;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(1);
        set.add(10);
        set.add(1);
        set.add(3);
        System.out.println(set);
    }
}
