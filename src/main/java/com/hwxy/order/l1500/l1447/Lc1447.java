package com.hwxy.order.l1500.l1447;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1447.最简分数
 * https://leetcode-cn.com/problems/simplified-fractions/
 *
 * @author hwxy
 * @date 2022/02/10
 **/
public class Lc1447 {
    public static void main(String[] args) {
        System.out.println(new Lc1447().simplifiedFractions(4));
    }

    /**
     * b = x % y
     * 求最大公约数f(x,y)=f(y,b)
     * 
     * @param n
     * @return
     */
    public List<String> simplifiedFractions(int n) {
        if (n <= 1) {
            return Collections.emptyList();
        }
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 求出j和i的最大公约数
                int gcb = gcb(i, j);
                // 如果为1说明互质
                if (gcb == 1) {
                    res.add((j / gcb) + "/" + (i / gcb));
                }
            }
        }
        return res;
    }

    /**
     * 求最大公约数
     * 求最大公约数f(x,y)=f(y,b)
     * 最终f(a, 0) = a
     * 
     * @param i
     * @param j
     * @return
     */
    private int gcb(int i, int j) {
        return j == 0 ? i : gcb(j, i % j);
    }
}
