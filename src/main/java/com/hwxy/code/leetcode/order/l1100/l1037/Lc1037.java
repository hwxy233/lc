package com.hwxy.code.leetcode.order.l1100.l1037;

/**
 * 1037. 有效的回旋镖
 * https://leetcode.cn/problems/valid-boomerang/
 * 
 * @author hwxy
 * @date 2022/06/08
 **/
public class Lc1037 {
    public boolean isBoomerang(int[][] points) {
        if (points == null || points.length != 3) {
            return false;
        }
        return !check(points[0][0], points[0][1],
                points[1][0], points[1][1],
                points[2][0], points[2][1]);
    }

    /**
     * 判断斜率是否相等
     * (y3−y1)(x2−x1)−(y2−y1)(x3−x1)=0
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return
     */
    private boolean check(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3 - y1) * (x2 - x1) - (y2 - y1) * (x3 - x1) == 0;
    }
}
