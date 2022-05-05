package com.hwxy.code.leetcode.order.l900.l883;

import java.util.HashMap;
import java.util.Map;

/**
 * 883. 三维形体投影面积
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * 
 * @author hwxy
 * @date 2022/04/26
 **/
public class Lc883 {
    /**
     * 记录每行的最大值
     * 每列的最大值
     * 所有不为0的数量
     * 
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        // 所有grid[][] != 0的数量
        int xy = 0;
        // i相同,grid[][j]的最大值的sum
        int xz = 0;
        // j相同,grid[i][]的最大值的sum
        int yz = 0;
        Map<Integer, Integer> yzMax = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            int xzMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    xy++;
                }
                xzMax = Math.max(xzMax, grid[i][j]);
                yzMax.put(j, Math.max(yzMax.getOrDefault(j, 0), grid[i][j]));
            }
            xz += xzMax;
        }
        yz = yzMax.values().stream().mapToInt(i -> i).sum();
        return xy + xz + yz;
    }
}
