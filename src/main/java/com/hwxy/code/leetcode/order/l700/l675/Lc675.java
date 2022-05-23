package com.hwxy.code.leetcode.order.l700.l675;

import java.util.*;

/**
 * 675. 为高尔夫比赛砍树
 * https://leetcode.cn/problems/cut-off-trees-for-golf-event/
 * 
 * @author hwxy
 * @date 2022/05/23
 **/
public class Lc675 {
    private static final int[][] STEPS = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int row;
    private int column;
    private List<List<Integer>> forest;

    /**
     * 题目的意思是最小的到最大的走
     * 第一个位置是(0,0)求最短路径所以bfs而不是dfs
     * 
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return -1;
        }
        this.forest = forest;
        row = forest.size();
        column = forest.get(0).size();
        // 先对所有🌲按照高度排序
        List<int[]> trees = new ArrayList<>();
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (forest.get(x).get(y) > 1) {
                    trees.add(new int[] {x, y});
                }
            }
        }
        trees.sort(Comparator.comparingInt(tree -> forest.get(tree[0]).get(tree[1])));
        int ans = 0;
        int sx = 0;
        int sy = 0;
        // 对每个节点遍历直到砍完所有树
        for (int[] tree : trees) {
            int steps = bfs(sx, sy, tree[0], tree[1]);
            if (-1 == steps) {
                return -1;
            }
            ans += steps;
            sx = tree[0];
            sy = tree[1];
        }
        return ans;
    }

    private int bfs(int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) {
            return 0;
        }
        // 不能重读遍历
        boolean[][] used = new boolean[row][column];
        used[sx][sy] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sx, sy});
        int steps = 0;
        while (!queue.isEmpty()) {
            // 一层算一步
            steps++;
            int size = queue.size();
            // 每次上下左右移动
            for (int i = 0; i < size; i++) {
                int[] tree = queue.poll();
                for (int[] step : STEPS) {
                    int nx = tree[0] + step[0];
                    int ny = tree[1] + step[1];
                    if (checkout(nx, ny) || used[nx][ny]) {
                        continue;
                    }
                    // 使用了
                    used[nx][ny] = true;
                    // 找到了
                    if (nx == ex && ny == ey) {
                        return steps;
                    }
                    int treeHeight = forest.get(nx).get(ny);
                    if (treeHeight > 0) {
                        // 没找到
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 纵轴是x,横轴是y
     * 
     * @param x
     * @param y
     * @return
     */
    private boolean checkout(int x, int y) {
        return x < 0 || x >= row || y < 0 || y >= column;
    }
}
