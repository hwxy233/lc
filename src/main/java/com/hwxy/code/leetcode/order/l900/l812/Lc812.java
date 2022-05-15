package com.hwxy.code.leetcode.order.l900.l812;

import java.util.LinkedList;

/**
 * 812. 最大三角形面积
 * https://leetcode.cn/problems/largest-triangle-area/
 * 
 * @author hwxy
 *
 * @date 2022/05/15
 **/
public class Lc812 {
    public static final int SIZE = 3;
    private LinkedList<Integer> midRes;

    private double ans;

    public double largestTriangleArea(int[][] points) {
        if (points == null || points.length < 3) {
            return 0D;
        }
        midRes = new LinkedList<>();
        ans = 0D;
        // 回溯 + 三角形面积公式
        backtracking(points, 0);
        return ans;
    }

    private void backtracking(int[][] points, int index) {
        if (midRes.size() == SIZE) {
            // 计算面积
            ans = Math.max(ans, cal(points));
            return;
        }
        for (int i = index; i < points.length; i++) {
            midRes.add(i);
            backtracking(points, i + 1);
            midRes.removeLast();
        }
    }

    private double cal(int[][] points) {
        // S=(1/2)* | ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) |
        return 0.5 * Math.abs((points[midRes.get(1)][0] - points[midRes.get(0)][0])
                * (points[midRes.get(2)][1] - points[midRes.get(0)][1])
                - (points[midRes.get(2)][0] - points[midRes.get(0)][0])
                        * (points[midRes.get(1)][1] - points[midRes.get(0)][1]));
    }
}
