package com.douma.dp;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci5 {
    // 动态规划的四个步骤
    public int fib(int n) {
        if (n <= 1) return n;
        // 1. 定义状态数组，dp[i] 表示的是数字 i 的斐波那契数
        int[] dp = new int[n + 1];

        // 2. 状态初始化
        dp[0] = 0;
        dp[1] = 1;

        // 3. 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 4. 返回最终需要的状态值
        return dp[n];
    }

}
