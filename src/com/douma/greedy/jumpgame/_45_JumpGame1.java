package com.douma.greedy.jumpgame;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _45_JumpGame1 {
    private int minSteps = Integer.MAX_VALUE;
    // DFS
    public int jump(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return minSteps == Integer.MAX_VALUE ? 0 : minSteps;
    }

    private void dfs(int[] nums, int jumpedIndex, List<Integer> path) {
        if (jumpedIndex == nums.length - 1) {
            minSteps = Math.min(minSteps, path.size());
            return;
        }

        for (int i = 1; i <= nums[jumpedIndex]; i++) {
            if (jumpedIndex + i >= nums.length) continue;
            path.add(i);
            // jumpedIndex + i，表示跳到下一步所在的位置
            dfs(nums, jumpedIndex + i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new _45_JumpGame1().jump(nums));
    }
}
