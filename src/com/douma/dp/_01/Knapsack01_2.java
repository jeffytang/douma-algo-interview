package com.douma.dp._01;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Knapsack01_2 {
    private int[] w;
    private int[] v;

    public int knapsack01(int[] w, int[] v, int C) {
        this.w = w;
        this.v = v;
        return dfs(0, C);
    }

    // 在容量为 c 的背包里放入第 index 号物品，得到的最大价值
    private int dfs(int index, int c) { // 状态参数
        if (index == w.length) {
            return 0;
        }

        int maxValue = 0;
        for (int i = index; i < w.length; i++) {
            if (c < w[index]) continue;
            int childValue = dfs(i + 1, c - w[index]);
            maxValue = Math.max(maxValue, v[index] + childValue);
        }
        return maxValue;

    }

    public static void main(String[] args) {
        Knapsack01_2 k = new Knapsack01_2();
        int w[] = {3, 4, 5};
        int v[] = {15, 10, 12};

        System.out.println(k.knapsack01(w, v, 10));
    }
}
