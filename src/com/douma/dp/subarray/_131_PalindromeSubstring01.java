package com.douma.dp.subarray;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _131_PalindromeSubstring01 {
    public List<List<String>> allPartitions(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        // 定义状态，dp[i][j] 表示子数组区间 [i, j] 对应的子串是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 状态初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true; // 一个字符，肯定是回文
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
            }
        }

        dfs(s, 0, new ArrayList<>(), res, dp);
        return res;
    }

    private void dfs(String s, int start,
                     List<String> path,
                     List<List<String>> res,
                     boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // [start, i]
            // 不是回文的话就剪枝
            if (!dp[start][i]) continue;

            path.add(s.substring(start, i + 1));
            dfs(s, i + 1, path, res, dp);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<String>> res
                = new _131_PalindromeSubstring01().allPartitions("aab");
        for (List<String> path : res) {
            System.out.println(path);
        }
    }
}
