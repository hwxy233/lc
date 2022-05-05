package com.hwxy.code.leetcode.order.l1800.l1791;

/**
 * 1791. 找出星型图的中心节点
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 * 
 * @author hwxy
 * @date 2022/02/18
 **/
public class Lc1791 {

    public static void main(String[] args) {
        System.out.println(new Lc1791().findCenter(new int[][] {{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(new Lc1791().findCenter(new int[][] {{1, 2}, {5,1}, {1,3}, {1, 4}}));
    }

    public int findCenter(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return Integer.MIN_VALUE;
        }
        int a = edges[0][0];
        int b = edges[0][1];
        if (a == edges[1][0] || a == edges[1][1]) {
            return a;
        }
        return b;
    }
}
