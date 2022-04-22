package com.hwxy.leetcode.order.l100.l37;

import java.util.Arrays;

/**
 * 数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc37 {

    public static void main(String[] args) {
        Lc37 lc37 = new Lc37();
        char[][] b = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        lc37.solveSudoku(b);
        System.out.println(Arrays.deepToString(b));
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, board, k)) {
                        board[i][j] = k;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    private boolean isValid(int row, int column, char[][] board, char k) {
        // 行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }
        // 列
        for (int j = 0; j < 9; j++) {
            if (board[j][column] == k) {
                return false;
            }
        }
        // 小格子判断
        int startRow = (row / 3) * 3;
        int startCol = (column / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

}
