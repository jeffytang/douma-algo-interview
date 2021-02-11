package com.douma.bt.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _77_Combinations1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return res;
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k,
                     int start,
                     List<Integer> combination,
                     List<List<Integer>> res) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 根据不能重复使用数字的条件，剪枝
            // if (combination.contains(i)) continue;
            combination.add(i);
            dfs(n, k, i + 1, combination, res);
            // 回溯的过程中，将当前的节点从 combination 中删除
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _77_Combinations1().combine(4, 2));
    }
}
