package com.hwxy.code.leetcode.order.l400.l344;

/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc344 {
    public static void main(String[] args) {
        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
        new Lc344().reverseString(s);
        System.out.println(s);
    }

    /**
     * 双指针
     * 
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        // 注意条件
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
