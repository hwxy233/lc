package com.hwxy.leetcode.order.l1100.l1002;

/**
 * 1020. 飞地的数量
 * https://leetcode-cn.com/problems/number-of-enclaves/
 * 
 * @author hwxy
 * @date 2022/02/12
 **/
public class Lc1002 {
    public static void main(String[] args) {
        System.out.println(new Lc1002().numEnclaves(new int[][] {
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}}));
    }


    private int[][] arounds;
    private int[][] used;

    public int numEnclaves(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        // dfs,从4个边开始不断的把能到达的land都标记上,最后统计未标记的land数量
        arounds = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        used = new int[grid.length][grid[0].length];
        // 左右2列
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        // 上下2行
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, 0, i);
            dfs(grid, grid.length - 1, i);
        }
        // 统计没去过的
        int res = 0;
        // 可以不统计4边
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1 && used[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int line, int column) {
        // 不在grid里 || 不是land || 使用过
        if (line < 0 || column < 0 || line >= grid.length || column >= grid[0].length
                || grid[line][column] == 0 || used[line][column] == 1) {
            return;
        }

        // 用过了
        used[line][column] = 1;
        // 四周
        for (int[] around : arounds) {
            dfs(grid, line + around[0], column + around[1]);
        }
    }

}
