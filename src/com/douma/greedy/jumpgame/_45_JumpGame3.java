package com.douma.greedy.jumpgame;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _45_JumpGame3 {
    // 贪心
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps = 0;
        int start = 0, end = 0;
        while (end < nums.length - 1) { // 走到最后一个位置的时候就不用走了
            int maxPos = 0;
            for (int i = start; i <= end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end + 1;
            end = maxPos;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new _45_JumpGame3().jump(nums));
    }
}
