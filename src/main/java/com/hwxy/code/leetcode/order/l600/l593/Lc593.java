package com.hwxy.code.leetcode.order.l600.l593;

import java.util.Arrays;

/**
 * 593. 有效的正方形
 * https://leetcode.cn/problems/valid-square/
 * 
 * @author hwxy
 * @date 2022/07/29
 **/
public class Lc593 {

    /**
     * 2条对角线的中点相同
     * 2条对角线的长度相同
     * 2条对角线垂直相交
     * 
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 分别讨论p1与p2,p3,p4互为定点的情况
        // p1 <-> p2
        if (Arrays.equals(p1, p2)) {
            return false;
        }
        if (help(p1, p2, p3, p4)) {
            return true;
        }
        // p1 <-> p3
        if (Arrays.equals(p1, p3)) {
            return false;
        }
        if (help(p1, p3, p2, p4)) {
            return true;
        }
        // p1 <-> p4
        if (Arrays.equals(p1, p4)) {
            return false;
        }
        return help(p1, p4, p2, p3);
    }

    /**
     * p1和p2是对角线的2个点
     * p3和p4是对角线的2个点
     * 
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean help(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 2个对角线的(x1-x2)以及(y1-y2)
        int[] v1 = {p1[0] - p2[0], p1[1] - p2[1]};
        int[] v2 = {p3[0] - p4[0], p3[1] - p4[1]};
        // 对角线的中点相同 && 对角线长度相同 && 90度
        return checkMidPoint(p1, p2, p3, p4) && checkLength(v1, v2) && calCos(v1, v2);
    }

    /**
     * 求出对角线长度
     * (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) = (x3-x4)*(x3-x4) + (y3-y4)*(y3-y4)
     * 
     * @param v1
     * @param v2
     * @return
     */
    public boolean checkLength(int[] v1, int[] v2) {
        return (v1[0] * v1[0] + v1[1] * v1[1]) == (v2[0] * v2[0] + v2[1] * v2[1]);
    }

    /**
     * 求出对角线的中点是否相同
     * 对角线中点=(x1+x2)/2,(y1+y2)/2
     * 
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean checkMidPoint(int[] p1, int[] p2, int[] p3, int[] p4) {
        return (p1[0] + p2[0]) == (p3[0] + p4[0]) && (p1[1] + p2[1]) == (p3[1] + p4[1]);
    }

    /**
     * 向量的积
     * (x1-x2)*(x3-x4) + (y1-y2)*(y3-y4) = 0
     * 
     * @param v1
     * @param v2
     * @return
     */
    public boolean calCos(int[] v1, int[] v2) {
        return (v1[0] * v2[0] + v1[1] * v2[1]) == 0;
    }

}
