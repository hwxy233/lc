package com.hwxy.code.leetcode.interview.in1.i9;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode.cn/problems/string-rotation-lcci/
 *
 * @author hwxy
 * @date 2022/09/29
 **/
public class In1I9 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
