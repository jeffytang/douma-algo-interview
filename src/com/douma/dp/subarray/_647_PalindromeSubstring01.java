package com.douma.dp.subarray;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _647_PalindromeSubstring01 {
    // 动态规划
    // 时间复杂度：O(n^2)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        // 定义状态，dp[i][j] 表示子数组区间 [i, j] 对应的子串是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        // 状态初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true; // 一个字符，肯定是回文
            res++;
        }
        // 状态转移
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                // [i, j]
                boolean isCharEqual = s.charAt(i) == s.charAt(j);
                if (j - i == 1) { // 只有两个字符
                    dp[i][j] = isCharEqual;
                } else  { // 大于两个字符
                    dp[i][j] = isCharEqual && dp[i + 1][j - 1];
                }
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _647_PalindromeSubstring01().countSubstrings("aaa"));
    }
}
