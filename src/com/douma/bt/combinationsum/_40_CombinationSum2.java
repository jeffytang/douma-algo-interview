package com.douma.bt.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _40_CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        // 将相同的元素放在一起
        Arrays.sort(nums);
        findCombinationSum(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void findCombinationSum(int[] nums,
                     int startIndex,
                     int target,
                     List<Integer> combination,
                     List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 为了保证数组元素访问的顺序，所以 i > startIndex
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            combination.add(nums[i]);
            findCombinationSum(nums, i + 1, target - nums[i], combination, res);
            // 回溯的过程中，将当前的节点从 combination 中删除
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 2, 1, 2};
        System.out.println(new _40_CombinationSum2().combinationSum(data, 5));
    }
}
