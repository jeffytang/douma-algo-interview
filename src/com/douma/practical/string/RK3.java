package com.douma.practical.string;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class RK3 {
    // 时间复杂度：O(m - n)
    // 空间复杂度：O(m - n)
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 1. 计算主串中 m - n + 1 个子串的哈希值
        int[] hashCodes = new int[m - n + 1];
        // 计算第一个子串的 hash 值
        hashCodes[0] = calFirstSubStrHashCode(mainStr.substring(0, n));
        for (int i = 1; i < m - n + 1; i++) {
            // 根据前一个子串的 hash 值计算下一个子串的 hash 值
            hashCodes[i] = calHashCode(mainStr, i, hashCodes, n);
        }

        // 2. 计算模式串的哈希值
        int hashCode = calFirstSubStrHashCode(pattern);

        // 3. 在所有子串哈希值中，寻找是否有模式串的哈希值
        for (int i = 0; i < m - n + 1; i++) {
            if (hashCode == hashCodes[i]) {
                return i;
            }
        }

        return -1;
    }

    private int calHashCode(String mainStr, int i, int[] hashCodes, int n) {
        return hashCodes[i - 1] * 26 - (mainStr.charAt(i - 1) - 'a') * (int)Math.pow(26, n)
                + (mainStr.charAt(i + n - 1) - 'a');
    }

    // abc => 0 * 26^2 + 1 * 26 + 2 = 28
    private int calFirstSubStrHashCode(String str) { // O(n)
        int n = str.length();

        int hashCode = 0;
        for (int i = 0; i < n; i++) {
            hashCode += (int)Math.pow(26, i) * (str.charAt(n - i - 1) - 'a');
        }

        return hashCode;
    }

    public static void main(String[] args) {
        RK3 b = new RK3();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
