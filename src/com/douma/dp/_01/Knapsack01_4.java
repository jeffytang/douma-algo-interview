package com.douma.dp._01;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Knapsack01_4 {

    public int knapsack01(int[] w, int[] v, int C) {
        int len = w.length;
        if (len == 0) {
            return 0;
        }
        // 1. 状态定义：dp[i][j] 表示将 i 号物品放入容量为 j 的背包中的最大价值
        int[] dp = new int[C + 1];

        // 2. 状态初始化
        Arrays.fill(dp, -1);

        // 考虑将第 0 号物品放入背包中
        for (int j = 0; j <= C; j++) {
            dp[j] = (j >= w[0] ? v[0] : 0);
        }

        // 3. 状态转移
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < w[i]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
                }
            }
        }

        // 4. 返回结果
        return dp[C];
    }


    public static void main(String[] args) {
        Knapsack01_4 k = new Knapsack01_4();
        int w[] = {3, 4, 5};
        int v[] = {15, 10, 12};

        System.out.println(k.knapsack01(w, v, 10));
    }
}
