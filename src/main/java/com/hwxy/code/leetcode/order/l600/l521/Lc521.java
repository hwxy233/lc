package com.hwxy.code.leetcode.order.l600.l521;

/**
 * 521. 最长特殊序列 Ⅰ
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * 
 * @author hwxy
 * @date 2022/03/06
 **/
public class Lc521 {
    /**
     * 脑筋急转弯
     * 
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()) {
            return a.equals(b) ? -1 : a.length();
        }

        return Math.max(a.length(), b.length());
    }
}
