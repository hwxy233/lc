package com.hwxy.code.leetcode.order.l1800.l1706;

import java.util.Arrays;

/**
 * 1706. 球会落何处
 * https://leetcode-cn.com/problems/where-will-the-ball-fall/
 * 
 * @author hwxy
 * @date 2022/02/24
 **/
public class Lc1706 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lc1706().findBall(new int[][] {
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        })));
        // System.out.println(Arrays.toString(new Lc1706().findBall(new int[][] {
        // {1, 1, 1, -1, -1},
        // {1, 1, 1, -1, -1},
        // {-1, -1, -1, 1, 1},
        // {1, 1, 1, 1, -1},
        // {-1, -1, -1, -1, -1}
        // })));
    }

    // private int[][] canReach;

    /**
     * dfs,不需要记忆(因为没用)
     * 注意返回值要再走一步
     * 
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        // 列的长度
        int[] res = new int[grid[0].length];
        // 如果可以到达底部则记录下
        // canReach = new int[grid.length][grid[0].length];
        // for (int[] cr : canReach) {
        // Arrays.fill(cr, -1);
        // }
        // 遍历列
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = dfs(0, i, grid);
        }
        return res;
    }

    /**
     * 深度遍历
     * 
     * @param line
     * @param column
     * @param grid
     * @return
     */
    private int dfs(int line, int column, int[][] grid) {
        // 卡住 - 左边
        if (column == 0 && grid[line][column] == -1) {
            return -1;
        }
        // 卡住 - 右边
        if (column == grid[line].length - 1 && grid[line][column] == 1) {
            return -1;
        }
        // V字
        if (grid[line][column] == 1 && column + 1 < grid[0].length
                && grid[line][column + 1] == -1) {
            return -1;
        }
        if (grid[line][column] == -1 && column - 1 > 0
                && grid[line][column - 1] == 1) {
            return -1;
        }
        // 滑了
        // if (canReach[line][column] != -1) {
        // return canReach[line][column];
        // }
        if (line == grid.length - 1) {
            return column + grid[line][column];
        }
        int res = dfs(line + 1, column + grid[line][column], grid);
        // canReach[line][column] = res;
        return res;
    }
}
