package com.douma.dp.interval;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _486_PredictTheWinner1 {
    public boolean predictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1) >= 0;
    }

    private int dfs(int[] nums, int i, int j) {
        if (i == j) return nums[i];

        int pickI = nums[i] - dfs(nums, i + 1, j);
        int pickJ = nums[j] - dfs(nums, i, j - 1);

        return Math.max(pickI, pickJ);
    }
}
