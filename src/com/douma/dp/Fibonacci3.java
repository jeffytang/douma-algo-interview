package com.douma.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci3 {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }
    // 时间复杂度：O(n)
    private int dfs(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }
        int leftFib = dfs(n - 1, memo);
        int rightFib = dfs(n - 2, memo);

        memo[n] = leftFib + rightFib;

        return leftFib + rightFib;
    }
}
