package com.douma.dp;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci1 {
    public int fib(int n) {
        return dfs(n);
    }
    // 时间复杂度：O(2^n)
    private int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int leftFib = dfs(n - 1);
        int rightFib = dfs(n - 2);

        return leftFib + rightFib;
    }
}
