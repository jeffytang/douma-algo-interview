package com.douma.dp.subarray;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _53_MaxSubArray04 {
    // 动态规划
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n^2)
    public int maxSubArray(int[] nums) {
        // 状态定义：dp[i][j] 表示子数组 [i, j] 的累加和
        int[][] dp = new int[nums.length][nums.length];
        // 状态初始化
        dp[0][0] = nums[0];
        int maxSum = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
            maxSum = Math.max(maxSum, dp[0][i]);
        }
        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // [i, j]
                dp[i][j] = dp[0][j] - dp[0][i - 1];
                maxSum = Math.max(maxSum, dp[i][j]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int res = new _53_MaxSubArray04().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
