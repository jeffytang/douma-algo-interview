package com.douma.dp.subarray;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _53_MaxSubArray06 {

    // 动态规划(改变状态定义)
    public int maxSubArray(int[] nums) {
        // 状态定义：dp[i] 表示以索引为 i 的元素结尾的最大子数组和
        int[] dp = new int[nums.length];
        // 状态初始化
        dp[0] = nums[0];
        int maxSum = dp[0];
        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            dp[i] =Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int res = new _53_MaxSubArray06().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
