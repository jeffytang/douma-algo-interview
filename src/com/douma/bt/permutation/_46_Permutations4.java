package com.douma.bt.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _46_Permutations4 {
    // O(n! * n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path, res, used);
        return res;
    }

    private void dfs(int[] nums,
                     List<Integer> path,
                     List<List<Integer>> res,
                     boolean[] used) { // O(n)
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝，判断重复使用的数字
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, res, used);
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _46_Permutations4().permute(new int[]{1, 1, 2}));
    }
}
