package com.douma.practical.bitmap;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Test {
    private static Random random = new Random();

    public static void main(String[] args) {
        // 准备 1 千万个整数
        int[] data = new int[10_000_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100_000_000);
        }

        int target = data[8888];

       /* // 1. 使用哈希表
        Set<Integer> set = new HashSet<>(); // 10_000_000 * 4 / 0.75 = 51 MB (理想情况)
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        if (set.contains(target)) { // 时间复杂度 O(1)，会存在哈希冲突
            System.out.println("1 千万个整数中存在目标值：" + target);
        }

        // 2. 使用 boolean 类型的数组
        boolean[] arr = new boolean[100_000_000]; // 100_000_000 byte = 95 MB
        for (int i = 0; i < data.length; i++) {
            arr[data[i]] = true;
        }
        if (arr[target]) { // 时间复杂度 O(1)
            System.out.println("1 千万个整数中存在目标值：" + target);
        }*/

        // 只有 20 MB 给你 --> 位图
        BitMap bitMap = new BitMap(100_000_000); // 100_000_000 bit = 12MB
        for (int i = 0; i < data.length; i++) {
            bitMap.set(data[i]);
        }
        if (bitMap.contains(target)) { // O(1)
            System.out.println("1 千万个整数中存在目标值：" + target);
        }
    }
}
