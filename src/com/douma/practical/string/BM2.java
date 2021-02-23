package com.douma.practical.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BM2 {
    // 时间复杂度：
    // 最坏情况下，BM 算法的比较次数上限是 5m ：http://dl.acm.org/citation.cfm?id=1382431.1382552
    // 最坏情况下，BM 算法的比较次数上限是 3m ：http://dl.acm.org/citation.cfm?id=127830
    // 空间复杂度：O(n)
    // 使用坏字符规则实现 BM
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 数据(模式串)预处理, 构建坏字符哈希表
        Map<Character, Integer> bc = genBadCharIndexMap(pattern);

        // 数据预处理：构建好后缀规则
        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        genGoodSuffixArr(pattern.toCharArray(), suffix, prefix);

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
            int badCharMoveSteps = y - x;

            // 根据好后缀规则，计算移动的位数
            int goodSuffixMoveSteps = 0;
            if (y < n - 1) { // 说明有好后缀，否则没有
                goodSuffixMoveSteps = calMoveSteps(y, n, suffix, prefix);
            }

            // 4. 往后移动最大位数
            i = i + Math.max(badCharMoveSteps, goodSuffixMoveSteps);
        }

        return -1;
    }

    // y 表示坏字符对应的模式串中的字符位置
    private int calMoveSteps(int y, int n, int[] suffix, boolean[] prefix) {
        int k = n - y - 1; // k 表示好后缀的长度
        // 看看模式串中是否存在好后缀(第二种情况)
        if (suffix[k] != -1) return y - suffix[k] + 1;
        // 看看好后缀的后缀子串是否和模式串的前缀子串匹配(第三种情况)
        for (int i = y + 1; i < n; i++) {
            if (prefix[n - i]) {
                return i;
            }
        }
        // 将整个模式串后移 n 位(第一种情况)
        return n;
    }

    private void genGoodSuffixArr(char[] pattern, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        int n = pattern.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && pattern[j] == pattern[n - 1 - k]) {
                k++;
                suffix[k] = j;
                j--;
            }
            if (j == -1) prefix[k] = true;
        }
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
        BM2 b = new BM2();
        String mainStr = "aaabaaa";
        String patternStr = "baaa";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
