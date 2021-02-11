package com.douma.bt.combinationsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _39_CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
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
            combination.add(nums[i]);
            findCombinationSum(nums, i, target - nums[i], combination, res);
            // 回溯的过程中，将当前的节点从 combination 中删除
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 3, 5};
        System.out.println(new _39_CombinationSum1().combinationSum(data, 8));
    }
}
