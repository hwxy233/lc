package com.hwxy.discover.recursion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        // 从左上到右下
        for (int i = 1; i <= numRows; i++) {
            List<Integer> li = new LinkedList<>();
            if (i == 1) {
                li.add(1);
                result.add(li);
                continue;
            }
            // 提前拿到上一次的结果,因为是1开始所以-2
            List<Integer> preLi = result.get(i - 2);
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    li.add(1);
                } else {
                    li.add(preLi.get(j - 2) + preLi.get(j - 1));
                }
            }
            result.add(li);
        }
        return result;
    }

}
