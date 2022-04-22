package com.hwxy.leetcode.order.l700.l688;

/**
 * 688. 骑士在棋盘上的概率
 * https://leetcode-cn.com/problems/knight-probability-in-chessboard/
 * 
 * @author hwxy
 * @date 2022/02/17
 **/
public class Lc688 {
    public static void main(String[] args) {
        // System.out.println(new Lc688().knightProbability(3, 2, 0, 0));
        System.out.println(new Lc688().f1(8, 16, 6, 4));
    }

    private final int[][] steps =
            new int[][] {{2, 1}, {2, -1}, {-2, -1}, {-2, 1},
                    {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};

    /**
     * 记录剩余步数到达这个位置的可行数量
     * 一定要用double
     */
    private double[][][] stepped;


    public double knightProbability(int n, int k, int row, int column) {
        if (n <= 0) {
            return 0;
        }
        return f1(n, k, row, column);
    }

    private double f1(int n, int k, int row, int column) {
        stepped = new double[k + 1][n][n];
        double cnt = backtracking(n, k, row, column);
        System.out.println("f1:" + cnt);
        return cnt / Math.pow(8, k);
    }

    private double backtracking(int n, int k, int row, int column) {
        // 已经来过了
        if (stepped[k][row][column] > 0) {
            return stepped[k][row][column];
        }
        if (k == 0) {
            return 1;
        }
        // 从这个点出发的所有cnt和,要用double
        double cnt = 0;
        // 从steps遍历
        for (int[] step : steps) {
            int x = row + step[0];
            int y = column + step[1];
            if (!in(n, x, y)) {
                continue;
            }
            cnt += backtracking(n, k - 1, x, y);
        }
        // 这个点和还剩步数就有这么多cnt
        stepped[k][row][column] = cnt;
        return cnt;
    }

    private boolean in(int n, int row, int column) {
        return row >= 0 && row < n && column >= 0 && column < n;
    }

}
