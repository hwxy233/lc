package com.hwxy.discover.recursion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/leetbook/read/recursion/4mb3s/
 * <p>
 * 在实现递归函数之前，有两件重要的事情需要弄清楚:
 * <p>
 * 递推关系： 一个问题的结果与其子问题的结果之间的关系。
 * 基本情况： 不需要进一步的递归调用就可以直接计算答案的情况。 有时，基本案例也被称为 bottom cases，因为它们往往是问题被减少到最小规模的情况，也就是如果我们认为将问题划分为子问题是一种自上而下的方式的最下层。
 * 一旦我们计算出以上两个元素，再想要实现一个递归函数，就只需要根据递推关系调用函数本身，直到其抵达基本情况。
 * <p>
 * 杨辉三角
 * 帕斯卡三角形是排列成三角形的一系列数字。 在帕斯卡三角形中，每一行的最左边和最右边的数字总是 1。
 * 对于其余的每个数字都是前一行中直接位于它上面的两个数字之和。
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: 5
 * 输出:
 * [
 * *     [1],
 * *    [1,1],
 * *   [1,2,1],
 * *  [1,3,3,1],
 * * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        // 从右下角到左上角
        for (int i = 1; i <= numRows; i++) {
            List<Integer> li = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                li.add(fIJ(i, j));
            }
            result.add(li);
        }
        return result;
    }

    /**
     * 杨辉三角的递归式
     * fIJ(i,j) = fIJ(i - 1, j) + fIJ(i - 1, j - 1), j > 1 && j != i
     * 1, j = 1 || j = i
     *
     * @param i 行 从1开始
     * @param j 列 从1开始
     * @return
     */
    private int fIJ(int i, int j) {
        // 左右2边的情况
        if (j == 1 || j == i) {
            return 1;
        } else {
            // 正常递归式
            return fIJ(i - 1, j) + fIJ(i - 1, j - 1);
        }
    }

}
