package com.hwxy.order.l500.l459;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc459 {
    public static void main(String[] args) {
        // System.out.println(new Lc459().repeatedSubstringPattern("abab"));
        System.out.println(new Lc459().repeatedSubstringPattern("abac"));
    }

    /**
     * kmp
     * 
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        // 还是构建next数组
        int[] next = new int[s.length()];
        int i = 0;
        int j = 0;
        next[j] = i;
        char[] sa = s.toCharArray();
        for (i = 1; i < s.length(); i++) {
            while (j > 0 && sa[j] != sa[i]) {
                j = next[j - 1];
            }
            if (sa[j] == sa[i]) {
                j++;
            }
            next[i] = j;
        }
        // 看看能不能整除
        return next[s.length() - 1] != 0
                // (s.length() - next[s.length() - 1])为第一个重复出现的子串长度
                && (s.length() % (s.length() - next[s.length() - 1]) == 0);
    }
}
