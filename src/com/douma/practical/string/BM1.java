package com.douma.practical.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BM1 {
    // 时间复杂度：<= O((m - n)*n)
    // 最好情况下时间复杂度：O(m/n)
    // 空间复杂度：O(n)
    // 使用坏字符规则实现 BM
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 数据(模式串)预处理, 构建坏字符哈希表
        Map<Character, Integer> bc = genBadCharIndexMap(pattern);

        int i = 0; // i 表示每次匹配的时候，主串的起始位置，初始化为 0
        while (i <= m - n) {
            // 1. 找到第一个坏字符
            int y;
            for (y = n - 1;  y >= 0 ; y--) { // 从后往前匹配
                if (mainStr.charAt(i + y) != pattern.charAt(y)) break;
            }

            // 2. 表示匹配成功
            if (y < 0) {
                // 返回主串和模式串第一个匹配字符串的位置
                return i;
            }

            // 3. 匹配不成功，模式串往后移动
            // 先计算坏字符在模式串中的位置 x
            char badChar = mainStr.charAt(i + y);
            int x = bc.getOrDefault(badChar, -1);

            // 4. 往后移动 y - x 位
            i = i + (y - x);
        }

        return -1;
    }

    private Map<Character, Integer> genBadCharIndexMap(String pattern) {
        char[] patternChars = pattern.toCharArray();
        Map<Character, Integer> bc = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            bc.put(patternChars[i], i);
        }
        return bc;
    }

    public static void main(String[] args) {
        BM1 b = new BM1();
        String mainStr = "aaaaaaa";
        String patternStr = "baaa";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
