package com.douma.dp.coinchange;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange4 {
    // DP
    // O(k * n) n 表示硬币的种类
    public int coinChange(int[] c, int k) {
        if (k < 0) return -1;
        if (k == 0) return 0;

        // 1. 状态定义：dp[i] 表示凑齐总金额为 i 的时候需要的最小硬币数
        int[] dp = new int[k + 1];

        // 2. 状态初始化
        // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 3. 状态转移
        for (int target = 1; target <= k; target++) {
            for (int coin : c) {
                if (target >= coin && dp[target - coin] != Integer.MAX_VALUE) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }

        // 4. 返回最终需要的状态值
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(new _322_CoinChange4().coinChange(c, 13));
    }
}
