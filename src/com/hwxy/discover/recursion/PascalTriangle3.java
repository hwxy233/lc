package com.hwxy.discover.recursion;

import java.util.*;

/***
 * https://leetcode-cn.com/leetbook/read/recursion/4a18d/
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalTriangle3 {

    public static void main(String[] args) {
        PascalTriangle3 pascalTriangle3 = new PascalTriangle3();
        System.out.println(pascalTriangle3.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        rowIndex++;
        // 记录下上一行的结果
        List<Integer> preLi = new ArrayList<>();
        preLi.add(1);
        List<Integer> li = new ArrayList<>();
        // 从左上到右下
        for (int i = 2; i <= rowIndex; i++) {
            // 提前拿到上一次的结果,因为是1开始所以-2
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    li.add(1);
                } else {
                    li.add(preLi.get(j - 2) + preLi.get(j - 1));
                }
            }
            if (i != rowIndex) {
                preLi.clear();
                preLi.addAll(li);
                li.clear();
            }

        }
        return li;
    }
}
