package com.hwxy.code.leetcode.order.l1500.l1460;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * <p>https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * @author hwxy
 * @date 2022/08/24
 */
public class Lc1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target == null || arr == null || target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> valueCnt = new HashMap<>(target.length);
        for (int tar : target) {
            valueCnt.put(tar, valueCnt.getOrDefault(tar, 0) + 1);
        }
        for (int a : arr) {
            int cnt = valueCnt.getOrDefault(a, 0) - 1;
            if (cnt < 0) {
                return false;
            }
            valueCnt.put(a, cnt);
        }
        return true;
    }
}
