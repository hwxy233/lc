package com.hwxy.order.l1000.l917;

/**
 * 917. 仅仅反转字母
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 
 * @author hwxy
 * @date 2022/02/23
 **/
public class Lc917 {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cs = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i >= 0 && i < s.length() && isNotA(cs[i])) {
                i++;
            }
            while (j < s.length() && j >= 0 && isNotA(cs[j])) {
                j--;
            }
            if (i < j) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
            }
        }
        return new String(cs);
    }

    private boolean isNotA(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }
}
