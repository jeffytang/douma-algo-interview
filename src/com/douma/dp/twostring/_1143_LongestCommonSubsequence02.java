package com.douma.dp.twostring;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _1143_LongestCommonSubsequence02 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 调换字符串顺序可以减少空间的使用
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }

        // dp[i][j]：text1 前 i 个字符和 text2 前 j 个字符【最长公共子序列长度】
        // 当前的状态依赖于前一行和当前行两行的状态值
        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= m; i++) {
            int currRow = i % 2;
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[currRow][j] = 1 + dp[currRow - 1][j - 1];
                } else {
                    dp[currRow][j] =
                            Math.max(dp[currRow][j - 1], dp[currRow - 1][j]);
                }
            }
        }

        return dp[m % 2][n];
    }
}
