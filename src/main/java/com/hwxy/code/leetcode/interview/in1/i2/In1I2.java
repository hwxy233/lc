package com.hwxy.code.leetcode.interview.in1.i2;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode.cn/problems/check-permutation-lcci/
 *
 * @author hwxy
 * @date 2022/09/27
 **/
public class In1I2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1cs = s1.toCharArray();
        char[] s2cs = s2.toCharArray();
        Arrays.sort(s1cs);
        Arrays.sort(s2cs);
        return Arrays.equals(s1cs, s2cs);
    }
}
