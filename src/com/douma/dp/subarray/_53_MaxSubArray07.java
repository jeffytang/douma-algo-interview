package com.douma.dp.subarray;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _53_MaxSubArray07 {
    // 动态规划 (三)
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int maxSubArray(int[] nums) {
        // 状态初始化
        int prevMaxSum = nums[0];
        int maxSum = prevMaxSum;

        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            prevMaxSum = Math.max(prevMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, prevMaxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int res = new _53_MaxSubArray07().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
