package com.douma.dp.minpathsum;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _64_MinPathSum4 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 状态定义：dp[i][j] 表示从坐标 (i, j) 到右下角的最小路径和
        int[][] dp = new int[m][n];

        // 状态初始化
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        // 状态转移
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                if (i == m - 1 && j != n - 1) { // 最后一行
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // 返回结果
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new _64_MinPathSum4().minPathSum(grid));
    }
}
