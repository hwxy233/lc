package com.hwxy.code.leetcode.order.l1800.l1790;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * @author hwxy
 * @date 2022/10/11
 **/
public class Lc1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] s1cs = s1.toCharArray();
        char[] s2cs = s2.toCharArray();
        // 记录下不同位置的char
        char s1c = '0';
        char s2c = '0';
        int changeCnt = 0;
        for (int i = 0; i < s1cs.length; i++) {
            if (changeCnt > 1) {
                return false;
            }
            if (s1cs[i] != s2cs[i]) {
                if (s1c == s2c) {
                    s1c = s1cs[i];
                    s2c = s2cs[i];
                } else {
                    // 第二次不同时必须要互相一样
                    if (s1c == s2cs[i] && s2c == s1cs[i]) {
                        changeCnt++;
                        s1c = '0';
                        s2c = '0';
                    } else {
                        return false;
                    }
                }
            }
        }
        return changeCnt <= 1 && s1c == s2c;
    }
}
