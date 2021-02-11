package com.douma.greedy.coinchange;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange2 {
    // 回溯
    public int coinChange(int[] c, int k) {
        // 1. 回溯穷举所有的硬币组合
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> coins = new ArrayList<>();
        dfs(k, c, coins, res);

        // 2. 没有任何的硬币组合，返回 -1
        if (res.isEmpty()) return -1;

        // 3. 找到适应硬币数最少的组合的硬币数
        int min = 0;
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).size() < res.get(min).size()) {
                min = i;
            }
        }
        return res.get(min).size();
    }

    private void dfs(int target, int[] c,
                     List<Integer> coins,
                     List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(coins));
            return;
        }

        for (int i = 0; i < c.length; i++) {
            coins.add(c[i]);
            dfs(target - c[i], c, coins, res);
            coins.remove(coins.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(new _322_CoinChange2().coinChange(c, 11));
    }
}
