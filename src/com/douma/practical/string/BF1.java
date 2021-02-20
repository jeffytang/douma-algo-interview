package com.douma.practical.string;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BF1 {
    // 时间复杂度：O(mn)
    // 空间复杂度：O(1)
    public int indexOf(String mainStr, String pattern) {
        if (mainStr == null || pattern == null) return -1;

        int m = mainStr.length();
        int n = pattern.length();
        if (m < n) return -1;

        for (int i = 0; i < m; i++) {
            // 1. 比对后面的字符，如果相等的话，一直比对下去
            int k = i;
            for (int j = 0; j < n; j++) {
                if (pattern.charAt(j) == mainStr.charAt(k)) {
                    k++;

                    // 2. 如果 j 是模式串的最后一个字符，说明匹配到了模式串
                    if (j == n - 1) return i;
                } else {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BF1 b = new BF1();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
