package com.douma.dp;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci4 {
    public int fib(int n) {
        if (n <= 1) return n;
        // 1. 定义数组，arr[i] 表示的是数字 i 的斐波那契数
        int[] arr = new int[n + 1];

        // 2. 初始化数组元素
        arr[0] = 0;
        arr[1] = 1;

        // 3. 计算数组的元素
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        // 4. 返回最终结果
        return arr[n];
    }

}
