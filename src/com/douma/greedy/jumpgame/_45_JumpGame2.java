package com.douma.greedy.jumpgame;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _45_JumpGame2 {
    // BFS
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int jumpedIndex = queue.poll();
                if (jumpedIndex == nums.length - 1) return level;
                for (int j = 1; j <= nums[jumpedIndex]; j++) {
                    queue.offer(jumpedIndex + j);
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new _45_JumpGame2().jump(nums));
    }
}
