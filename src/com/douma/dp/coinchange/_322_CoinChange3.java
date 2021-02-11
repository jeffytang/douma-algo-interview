package com.douma.dp.coinchange;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange3 {
    // 回溯
    public int coinChange(int[] c, int k) {
        int[] memo = new int[k + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dfs(k, c, memo);
    }
    // 计算返回凑成总金额 target 需要的最少硬币数
    private int dfs(int target, int[] c, int[] memo) {
        if (target == 0) {
            return 0;
        }
        if (memo[target] != Integer.MAX_VALUE) {
            return memo[target];
        }
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            if (target - c[i] < 0) continue;
            int subMinCoins = dfs(target - c[i], c, memo);
            if (subMinCoins == -1) continue;
            minCoins = Math.min(minCoins, subMinCoins + 1);
        }
        memo[target] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return memo[target];
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(new _322_CoinChange3().coinChange(c, 13));
    }
}
