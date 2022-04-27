package com.hwxy.leetcode.order.l500.l417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * 
 * @author hwxy
 * @date 2022/04/27
 **/
public class Lc417 {
    /**
     * 可以流入太平洋
     */
    private boolean[][] pacific;
    /**
     * 可以流入大西洋
     */
    private boolean[][] atlantic;
    /**
     * 4个方向
     */
    private static int[][] NES = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    private int[][] heights;

    /**
     * dfs从pacific的西和北找到所有能到pacific的
     * 同理从atlantic的东和南找到所有能到atlantic的
     * 如果某个下标都能到则就是结果
     * 
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null) {
            return Collections.emptyList();
        }
        pacific = new boolean[heights.length][heights[0].length];
        atlantic = new boolean[heights.length][heights[0].length];
        this.heights = heights;
        // pacific西侧
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, pacific);
        }
        // pacific北侧
        for (int i = 0; i < heights[0].length; i++) {
            dfs(0, i, pacific);
        }
        // atlantic东侧
        for (int i = heights.length - 1; i >= 0; i--) {
            // 注意下标
            dfs(i, heights[i].length - 1, atlantic);
        }
        // atlantic南侧
        for (int i = heights[0].length - 1; i >= 0; i--) {
            // 注意下标
            dfs(heights.length - 1, i, atlantic);
        }
        // 同时为true的就是结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < pacific.length; i++) {
            for (int j = 0; j < pacific[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    /**
     * 从(x,y)向4个方向深度遍历
     * (x,y)可达,则高度>=(x,y)的也可达
     * 
     * @param x
     * @param y
     * @param ocean
     */
    private void dfs(int x, int y, boolean[][] ocean) {
        // 已经遍历过了
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        for (int[] ne : NES) {
            int newX = x + ne[0];
            int newY = y + ne[1];
            // 必须>=才能扩散
            if (newX >= 0 && newX < heights.length &&
                    newY >= 0 && newY < heights[0].length &&
                    heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, ocean);
            }
        }
    }
}
