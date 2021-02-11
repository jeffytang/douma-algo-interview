package com.douma.dp.subseq;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _300_LengthOfLongestIncrementSubSeq {
    public int lengthOfLISS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
        }

        return maxLen;
    }
}
