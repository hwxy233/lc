package com.hwxy.leetcode.order.l100.l51;

import java.util.LinkedList;
import java.util.List;

/**
 * n皇后
 * https://leetcode-cn.com/problems/n-queens/submissions/
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc51 {

    public static void main(String[] args) {
        Lc51 lc51 = new Lc51();
        System.out.println(lc51.solveNQueens(4));
        // System.out.println(lc51.solveNQueens(3));
    }

    private LinkedList<List<String>> res = new LinkedList<>();

    private String[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return res;
        }
        chessboard = new String[n][n];
        backtracking(n, 0);
        return res;
    }

    /**
     * row记录递归遍历到哪行(row)了
     * 
     * @param n
     * @param row
     */
    private void backtracking(int n, int row) {
        // row == n,说明(n-1,n-1)都遍历完了
        if (row == n) {
            List<String> path = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (chessboard[i][j] == null) {
                        // 这里append下.
                        stringBuilder.append(".");
                        continue;
                    }
                    stringBuilder.append(chessboard[i][j]);
                }
                path.add(stringBuilder.toString());
            }
            res.add(new LinkedList<>(path));
            return;
        }
        // 遍历列
        for (int column = 0; column < n; column++) {
            // 直到找到一个列
            if (!checkChess(row, column)) {
                continue;
            }
            chessboard[row][column] = "Q";
            backtracking(n, row + 1);
            chessboard[row][column] = ".";
        }
    }

    /**
     * 只有左上(45°),正上,右上(135°)才需要检查
     * 
     * @param row
     * @param column
     * @return
     */
    private boolean checkChess(int row, int column) {
        // 竖着,最多到row-1是有数据的
        for (int i = 0; i < row; i++) {
            if ("Q".equals(chessboard[i][column])) {
                return false;
            }
        }
        // 左上
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(chessboard[i][j])) {
                return false;
            }
        }
        // 右上
        for (int i = row - 1, j = column + 1; i >= 0 && j < chessboard.length; i--, j++) {
            if ("Q".equals(chessboard[i][j])) {
                return false;
            }
        }
        return true;
    }
}
