package com.douma.dp.coinchange;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange2 {
    // 回溯
    public int coinChange(int[] c, int k) {
        return dfs(k, c);
    }

    private int dfs(int target, int[] c) {
        if (target == 0) {
            return 0;
        }
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            if (target - c[i] < 0) continue;
            int subMinCoins = dfs(target - c[i], c);
            if (subMinCoins == -1) continue;
            minCoins = Math.min(minCoins, subMinCoins + 1);
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(new _322_CoinChange2().coinChange(c, 13));
    }
}
