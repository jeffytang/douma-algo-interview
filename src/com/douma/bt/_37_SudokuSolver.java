package com.douma.bt;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _37_SudokuSolver {

    public void solveSudoku(char[][] board) {
        // 用于标识数字是否在行、列、箱子中使用过
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];

        // 初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }
    }

    private boolean backTrack(char[][] board,
                           int row, int col,
                           boolean[][] rowUsed,
                           boolean[][] colUsed,
                           boolean[][][] boxUsed) {
        if (col == board[0].length) {
            // 下一行
            row++;
            // 第一列
            col = 0;
            if (row == board.length) {
                return true;
            }
        }

        if (board[row][col] == '.') {
            // 尝试填充 1 到 9 数字
            for (int num = 1; num <= 9; num++) {
                boolean canPlaced = !(rowUsed[row][num]
                        || colUsed[col][num]
                        || boxUsed[row / 3][col / 3][num]);
                if (canPlaced) { // 填充当前的空格
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;

                    board[row][col] = (char)('0' + num);
                    // 尝试填充下一个空格，如果填充成功的话，则返回 true
                    if (backTrack(board, row, col + 1, rowUsed, colUsed, boxUsed)) {
                        return true;
                    }

                    // 否则的话，回溯
                    board[row][col] = '.';
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                }
            }
        } else { // 跳过这个空格
            return backTrack(board, row, col + 1, rowUsed, colUsed, boxUsed);
        }

        return false;
    }
}
