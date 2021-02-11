package com.douma.bt.pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _112_PathSum2 {
    public boolean hasPathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, res);
        for (List<Integer> onePath : res) {
            int sum = 0;
            for (int val : onePath) sum += val;
            if (sum == target) return true;
        }
        return false;
    }

    private void dfs(TreeNode node,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // 添加路径的时候需要 new 一个新的 ArrayList 的原因：
            // 1. 使得 res 中的对象和 path 不是同一个对象
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, path, res);
        dfs(node.right, path, res);
        // 回溯的过程中，将当前的节点从 path 中删除
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node2.left = node6;
        node2.right = node7;
        node7.left = node8;
        node7.right = node9;

        System.out.println(new _112_PathSum2().hasPathSum(root, 13));
    }
}
