package com.douma.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class TreeDFS {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }
    }

    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<TreeNode> res) {
        if (node == null) return;
        res.add(node);
        dfs(node.left, res);
        dfs(node.right, res);
    }
}
