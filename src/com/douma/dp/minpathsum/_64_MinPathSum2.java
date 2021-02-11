package com.douma.dp.minpathsum;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _64_MinPathSum2 {
    private int[][] dirs = {{1, 0}, {0, 1}};
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        int minPathSum = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0
                    || nextRow >= grid.length
                    || nextCol >= grid[0].length) continue;
            int childMinPathSum = dfs(grid, nextRow, nextCol);
            minPathSum = Math.min(minPathSum, childMinPathSum);
        }
        return minPathSum + grid[row][col];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new _64_MinPathSum2().minPathSum(grid));
    }
}
