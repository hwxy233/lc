package com.hwxy.code.leetcode.order.l100.l79;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 * 
 * @author hwxy
 * @date 2022/07/11
 **/
public class Lc79 {
    public static final int[][] STEPS = new int[][] {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null
                || word.isEmpty()
                || word.length() > board.length * board[0].length) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        int[][] used = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, used, wordChars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 在外层使用一个for循环来进行遍历
     * 
     * @param board
     * @param used
     * @param wordChars
     * @param x
     * @param y
     * @param wordCharIndex
     * @return
     */
    private boolean backtracking(char[][] board, int[][] used, char[] wordChars,
            int x, int y, int wordCharIndex) {
        if (wordCharIndex >= wordChars.length ||
                board[x][y] != wordChars[wordCharIndex]) {
            return false;
        }
        if (wordCharIndex == wordChars.length - 1) {
            return true;
        }
        // 这里标记为使用过
        used[x][y] = 1;
        // 上下左右
        for (int[] step : STEPS) {
            int nx = x + step[0];
            int ny = y + step[1];
            if (!checkXy(nx, ny, board.length, board[0].length)
                    // 使用过就下一个位置
                    || used[nx][ny] == 1) {
                continue;
            }
            if (backtracking(board, used, wordChars, nx, ny, wordCharIndex + 1)) {
                return true;
            }
        }
        used[x][y] = 0;
        return false;

    }

    private boolean checkXy(int nx, int ny, int xLength, int yLength) {
        return nx >= 0 && nx < xLength && ny >= 0 && ny < yLength;
    }
}
