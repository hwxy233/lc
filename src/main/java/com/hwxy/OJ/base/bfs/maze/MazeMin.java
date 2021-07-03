package com.hwxy.OJ.base.bfs.maze;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 求迷宫到出口的最短距离
 *
 * @author hwxy
 * @date 2021/03/20
 **/
public class MazeMin {
    /**
     * 墙
     */
    private static final char WALL = '#';
    /**
     * 通道
     */
    private static final char AISLE = '.';
    /**
     * 开始地点
     */
    private static final char START = 'S';
    /**
     * 终点
     */
    private static final char END = 'G';
    /**
     * 行
     */
    private static int N;
    /**
     * 列
     */
    private static int M;
    /**
     * 迷宫
     */
    private static char[][] MAZE;
    /**
     * 队列
     */
    private static final Queue<Co> QUEUE = new LinkedList<>();
    /**
     * 最小步数
     * 状态
     */
    private static int[][] STEP_COUNT;
    /**
     * 上下左右的x移动距离
     */
    private static final int[] DX = {0, 0, -1, 1};
    /**
     * 上下左右的y移动距离
     */
    private static final int[] DY = {1, -1, 0, 0};

    /**
     * 求起点到终点的最少步数
     */
    public int minMaze(char[][] maze, int n, int m, int sx, int sy, int gx, int gy) {
        N = n;
        M = m;
        MAZE = maze;
        return bfs(sx, sy, gx, gy);
    }


    private int bfs(int sx, int sy, int gx, int gy) {
        initStepCount();
        Co start = new Co(sx, sy);
        QUEUE.offer(start);
        STEP_COUNT[sx][sy] = 0;

        while (QUEUE.size() > 0) {
            Co nc = QUEUE.poll();
            // 当到达终点了
            if (nc.x == gx && nc.y == gy) {
                break;
            }
            // 4个方向移动
            for (int i = 0; i < 4; i++) {
                int nx = nc.x + DX[i];
                int ny = nc.y + DY[i];
                // 在范围内且可以移动且没有访问过
                if (nx >= 0 && nx < N && ny >= 0
                        && ny < M && MAZE[nx][ny] != WALL
                        && STEP_COUNT[nx][ny] == Integer.MAX_VALUE) {
                    // 就放到队里
                    QUEUE.offer(new Co(nx, ny));
                    // 同时步数+1
                    STEP_COUNT[nx][ny] = STEP_COUNT[nc.getX()][nc.getY()] + 1;
                }
            }
        }
        // 到终点的步数
        return STEP_COUNT[gx][gy];
    }

    /**
     * 将从起点到所有位置的步数都设为最大值
     */
    private void initStepCount() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                STEP_COUNT[x][y] = Integer.MAX_VALUE;
            }
        }
    }


    /**
     * 坐标
     */
    static class Co {
        private int x;
        private int y;

        public Co(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Co co = (Co) o;
            return x == co.x && y == co.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
