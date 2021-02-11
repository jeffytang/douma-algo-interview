package com.douma.bt.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _90_Subsets2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        findSubset(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void findSubset(int[] nums,
                            int startIndex,
                            List<Integer> subset,
                            List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            findSubset(nums, i + 1,  subset, res);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _90_Subsets2().subsets(new int[]{1, 2, 2}));
    }
}
