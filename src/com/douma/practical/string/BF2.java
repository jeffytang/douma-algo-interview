package com.douma.practical.string;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BF2 {
    // 时间复杂度：O(mn)
    // 空间复杂度：O(1)
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        char first = pattern.charAt(0);
        for (int i = 0; i < m; i++) {
            // 1. 找到等于模式串中第一个字符的位置
            if (mainStr.charAt(i) != first) {
                while (++i < m && mainStr.charAt(i) != first);
            }

            if (i < m) {
                // 2. 比对后面的字符，如果相等的话，一直比对下去
                int k = i + 1;
                int j = 1;
                for (; j < n && k < m ; j++, k++) {
                    if (mainStr.charAt(k) == pattern.charAt(j)) {
                        // 3. 如果 j 是模式串的最后一个字符，说明匹配到了模式串
                        if (j == n - 1) return i;

                        continue;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BF2 b = new BF2();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
