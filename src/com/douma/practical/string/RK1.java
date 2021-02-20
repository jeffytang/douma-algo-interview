package com.douma.practical.string;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class RK1 {
    // 时间复杂度：O((m - n)*n)
    // 空间复杂度：O(m - n)
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 1. 计算主串中 m - n + 1 个子串的哈希值
        int[] hashCodes = new int[m - n + 1];
        for (int i = 0; i < m - n + 1; i++) {
            hashCodes[i] = calHashCode(mainStr.substring(i, i + n));
        }

        // 2. 计算模式串的哈希值
        int hashCode = calHashCode(pattern);

        // 3. 在所有子串哈希值中，寻找是否有模式串的哈希值
        for (int i = 0; i < m - n + 1; i++) {
            if (hashCode == hashCodes[i]) {
                return i;
            }
        }

        return -1;
    }

    private int calHashCode(String str) {
        return str.hashCode(); // O(n)
    }

    public static void main(String[] args) {
        RK1 b = new RK1();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
