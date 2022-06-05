package com.hwxy.code.leetcode.order.l500.l478;

import java.util.Arrays;
import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * https://leetcode.cn/problems/generate-random-point-in-a-circle/
 * 
 * @author hwxy
 * @date 2022/06/05
 **/
public class Lc478 {
    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
    }
}


class Solution {
    private final double radius;
    private final double x_center;
    private final double y_center;
    private final Random random;

    /**
     * 在正方形上选点如果不在圆内就继续选
     * 
     * @param radius
     * @param x_center
     * @param y_center
     */
    public Solution(double radius, double x_center, double y_center) {
        this.y_center = y_center;
        this.x_center = x_center;
        this.radius = radius;
        random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            // 生成一个[-R,R]的x和y
            double x = random.nextDouble() * (2 * radius) - radius;
            double y = random.nextDouble() * (2 * radius) - radius;
            if (x * x + y * y <= radius * radius) {
                return new double[] {x_center + x, y_center + y};
            }
        }

    }
}
