package com.hwxy.code.leetcode.order.l800.l728;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 728. 自除数
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * 
 * @author hwxy
 * @date 2022/04/04
 **/
public class Lc728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left < 0 || left > right) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int a = i;
            boolean isSelfDividing = true;
            while (a > 0) {
                int b = a % 10;
                // 不允许0或者不整除
                if (b == 0 || i % b != 0) {
                    isSelfDividing = false;
                    break;
                }
                // 左移
                a = a / 10;
            }
            if (isSelfDividing) {
                res.add(i);
            }
        }
        return res;
    }
}
