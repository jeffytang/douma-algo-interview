package com.douma.greedy.coinchange;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange3 {
    private int minCoins = Integer.MAX_VALUE;
    // 回溯
    public int coinChange(int[] c, int k) {
        // 1. 回溯穷举所有的硬币组合
        dfs(k, c, new ArrayList<>());
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private void dfs(int target, int[] c,
                     List<Integer> coins) {
        if (target == 0) {
            minCoins = Math.min(minCoins, coins.size());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (target - c[i] < 0) continue;
            System.out.println(c[i]);
            coins.add(c[i]);
            dfs(target - c[i], c, coins);
            coins.remove(coins.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(new _322_CoinChange3().coinChange(c, 12));
    }
}
