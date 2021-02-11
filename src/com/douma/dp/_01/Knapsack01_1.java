package com.douma.dp._01;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Knapsack01_1 {
    private int[] w;
    private int[] v;

    private int maxValue = 0;

    public int knapsack01(int[] w, int[] v, int C) {
        this.w = w;
        this.v = v;
        dfs(0, C, 0);
        return maxValue;
    }

    private void dfs(int index, int c, int currValue) {
        if (index == w.length) {
            maxValue = Math.max(maxValue, currValue);
            return;
        }
        // 从 index 开始是为了控制顺序
        for (int i = index; i < w.length; i++) {
            // 放不下则剪枝
            if (c < w[index]) continue;
            // i + 1，表示的子节点中物体必须是在父节点物体后面
            dfs(i + 1, c - w[index], currValue + v[index]);
        }
    }

    public static void main(String[] args) {
        Knapsack01_1 k = new Knapsack01_1();
        int w[] = {3, 4, 5};
        int v[] = {15, 10, 12};

        System.out.println(k.knapsack01(w, v, 10));
    }
}
