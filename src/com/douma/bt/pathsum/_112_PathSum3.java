package com.douma.bt.pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _112_PathSum3 {
    public boolean hasPathSum(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        System.out.println(res);
        for (int onePathSum : res) {
            if (onePathSum == target) return true;
        }
        return false;
    }

    private void dfs(TreeNode node,
                     int parentNodePathSum, // 父亲节点的路径和
                     List<Integer> res) {
        if (node == null) return;
        int currNodePathSum = parentNodePathSum + node.val;
        if (node.left == null && node.right == null) {
            res.add(currNodePathSum);
        }
        dfs(node.left, currNodePathSum, res);
        dfs(node.right, currNodePathSum, res);
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

        System.out.println(new _112_PathSum3().hasPathSum(root, 22));
    }
}
