package com.hwxy.code.leetcode.order.l1800.l1784;

/**
 * 1784. 检查二进制字符串字段
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * @author hwxy
 * @date 2022/10/03
 **/
public class Lc1784 {
    public boolean checkOnesSegment(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return false;
        }
        char[] scs = s.toCharArray();
        int oneCount = 0;
        // 求连续1的次数
        for (int i = 0; i < scs.length; i++) {
            if (oneCount > 1) {
                return false;
            }
            if (scs[i] == '1') {
                while (i < scs.length && scs[i] == '1') {
                    i++;
                }
                oneCount++;
            }
        }
        return oneCount <= 1;
    }
}
