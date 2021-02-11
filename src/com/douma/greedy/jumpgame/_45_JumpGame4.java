package com.douma.greedy.jumpgame;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _45_JumpGame4 {
    // 贪心
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps = 0;
        int maxPos = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxPos;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new _45_JumpGame4().jump(nums));
    }
}
