package com.douma.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _51_NQueens {
    private int n;
    // 存储皇后的位置
    private int[] rows;
    // 标记是否被列方向的皇后攻击
    private int[] cols;
    // 标记是否被主对角线方向的皇后攻击
    private int[] mains;
    // 标记是否被次对角线方向的皇后攻击
    private int[] secondary;

    private List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.mains = new int[2 * n - 1];
        this.secondary = new int[2 * n -1];

        this.output = new ArrayList<>();

        dfs(0);

        return output;
    }
    // 回溯，在每一行中放置一个皇后
    private void dfs(int row) {
        if (row >= n) return;
        // 分别尝试在当前行的每一列中放置皇后
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                // 选择，在当前的位置上放置皇后
                placeQueen(row, col);
                // 当前行是最后一行，则找到了一个解决方案
                if (row == n - 1) addSolution();
                // 在下一行中放置皇后
                dfs(row + 1);
                // 撤销，回溯，即将当前位置的皇后去掉
                removeQueen(row, col);
            }
        }
    }

    // 在指定的位置上放置皇后
    private void placeQueen(int row, int col) {
        // 在 row 行，col 列 放置皇后
        rows[row] = col;
        // 当前位置的列方向已经有皇后了
        cols[col] = 1;
        // 当前位置的主对角线方向已经有皇后了
        mains[row - col + n - 1] = 1;
        // 当前位置的次对角线方向已经有皇后了
        secondary[row + col] = 1;
    }

    private void removeQueen(int row, int col) {
        // 移除 row 行上的皇后
        rows[row] = 0;
        // 当前位置的列方向没有皇后了
        cols[col] = 0;
        // 当前位置的主对角线方向没有皇后了
        mains[row - col + n - 1] = 0;
        // 当前位置的次对角线方向没有皇后了
        secondary[row + col] = 0;
    }

    // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
    private boolean isNotUnderAttack(int row, int col) {
        // 判断的逻辑是：
        //      1. 当前位置的这一列方向没有皇后攻击
        //      2. 当前位置的主对角线方向没有皇后攻击
        //      3. 当前位置的次对角线方向没有皇后攻击
        int res = cols[col] + mains[row - col + n - 1] + secondary[row + col];
        // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
        return res == 0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            int col = rows[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public static void main(String[] args) {
        System.out.println(new _51_NQueens().solveNQueens(8));
    }
}
