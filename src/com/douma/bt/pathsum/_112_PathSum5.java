package com.douma.bt.pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _112_PathSum5 {
    public boolean hasPathSum(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        boolean hasPathSum = dfs(root, target, res);
        System.out.println(res);
        return hasPathSum;
    }

    private boolean dfs(TreeNode node,
                     int parentNodeTarget, List<Integer> res) {
        if (node == null) return false;

        res.add(node.val);

        int currNodeTarget = parentNodeTarget - node.val;
        if (node.left == null && node.right == null) {
            return currNodeTarget == 0;
        }
        boolean isLeftHasPathSum = dfs(node.left, currNodeTarget, res);
        // 提前退出
        if (isLeftHasPathSum) return true;
        boolean isRightHasPathSum = dfs(node.right, currNodeTarget, res);

        return isLeftHasPathSum || isRightHasPathSum;
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

        System.out.println(new _112_PathSum5().hasPathSum(root, 22));
    }
}
