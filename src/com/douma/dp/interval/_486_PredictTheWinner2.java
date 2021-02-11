package com.douma.dp.interval;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _486_PredictTheWinner2 {
    public boolean predictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {
        if (i == j) return nums[i];
        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];

        int pickI = nums[i] - dfs(nums, i + 1, j, memo);
        int pickJ = nums[j] - dfs(nums, i, j - 1, memo);

        memo[i][j] = Math.max(pickI, pickJ);
        return memo[i][j];
    }
}
