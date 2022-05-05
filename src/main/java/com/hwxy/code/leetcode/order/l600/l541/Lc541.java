package com.hwxy.code.leetcode.order.l600.l541;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc541 {
    public static void main(String[] args) {
        System.out.println(new Lc541().reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        int offset = 2 * k;
        char[] sa = s.toCharArray();
        // 每次i+=2k,找到2k的起点,再判断
        for (int i = 0; i < length; i += offset) {
            // 如果剩余字符少于 k 个，则将剩余字符全部反转。
            // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            int lessLength = length - i;
            if (lessLength < k) {
                // 剩余的
                swap(sa, i, length - 1);
                break;
            } else if (lessLength < offset) {
                swap(sa, i, i + k - 1);
                break;
            } else {
                swap(sa, i, i + k - 1);
            }
        }
        return new String(sa);
    }

    private void swap(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
