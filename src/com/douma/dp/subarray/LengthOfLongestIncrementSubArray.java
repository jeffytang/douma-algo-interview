package com.douma.dp.subarray;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class LengthOfLongestIncrementSubArray {
    public int lengthOfLISA(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = 1 + dp[i - 1];
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}
