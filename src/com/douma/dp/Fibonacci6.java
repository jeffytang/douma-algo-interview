package com.douma.dp;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci6 {
    // 状态数组空间压缩
    public int fib(int n) {
        if (n <= 1) return n;
        // 只存储前两个状态
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
