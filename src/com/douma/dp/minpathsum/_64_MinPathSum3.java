package com.douma.dp.minpathsum;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _64_MinPathSum3 {
    private int[][] dirs = {{1, 0}, {0, 1}};
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        int minPathSum = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0
                    || nextRow >= grid.length
                    || nextCol >= grid[0].length) continue;
            int childMinPathSum = dfs(grid, nextRow, nextCol, memo);
            minPathSum = Math.min(minPathSum, childMinPathSum);
        }
        memo[row][col] = minPathSum + grid[row][col];
        return memo[row][col];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new _64_MinPathSum3().minPathSum(grid));
    }
}
