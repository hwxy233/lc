package com.hwxy.code.OJ.base.dfs.lakecounting;

/**
 * POJ 2386
 * lake counting
 *
 * @author hwxy
 * @date 2021/03/20
 **/
public class LakeCounting {
    public static void main(String[] args) {
        LakeCounting lakeCounting = new LakeCounting();
        System.out.println(lakeCounting.countLake(new char[][]{
                {'W', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.'},
                {'.', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W', 'W', 'W'},
                {'.', '.', '.', '.', 'W', 'W', '.', '.', '.', 'W', 'W', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
                {'.', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
                {'.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', 'W', '.'},
                {'W', '.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', '.'},
                {'.', 'W', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.'},
                {'.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W', '.'}
        }, 10, 12));
    }

    /**
     * 水
     */
    public static final char LAKE = 'W';
    /**
     * 无水
     */
    public static final char LAND = '.';
    /**
     * 园子(格子)
     */
    private char[][] yield;
    /**
     * 行数
     */
    private static int N;
    /**
     * 列数
     */
    private static int M;

    /**
     * 计算有多少个相邻成水洼的
     *
     * @param yield
     * @param n
     * @param m
     * @return
     */
    public int countLake(char[][] yield, int n, int m) {
        this.yield = yield;
        N = n;
        M = m;
        int count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (yield[x][y] == LAKE) {
                    dfs(x, y);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 每次将LAKE替换成LAND
     * 这样会将第一个LAKE的相邻的LAKE都替换为LAND
     * 最后剩下的LAKE数量(调用dfs的数量)就是答案
     *
     * @param x 当前的横坐标
     * @param y 当前的纵坐标
     */
    private void dfs(int x, int y) {
        yield[x][y] = LAND;
        // 每次找周围8个格子
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                int nx = x + dx;
                int ny = y + dy;
                if (inYield(nx, ny) && yield[nx][ny] == LAKE) {
                    dfs(nx, ny);
                }
            }
        }
    }

    /**
     * 判断是否在园子里
     *
     * @param nx
     * @param ny
     * @return
     */
    private boolean inYield(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
