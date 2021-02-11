package com.douma.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Fibonacci2 {
    private Map<Integer, Integer> map;
    public int fib(int n) {
        map = new HashMap<>();
        return dfs(n);
    }
    // 时间复杂度：O(n)
    private int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 先从 Map 中检索子问题的解
        // 如果已经计算，则直接返回即可
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int leftFib = dfs(n - 1);
        int rightFib = dfs(n - 2);
        // 将计算好的结果放入到 Map 中，编译后续检索
        map.put(n, leftFib + rightFib);

        return leftFib + rightFib;
    }
}
