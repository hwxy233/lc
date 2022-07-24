package com.hwxy.code.leetcode.order.l6200.l6124;

/**
 * 6124. 第一个出现两次的字母
 * https://leetcode.cn/contest/weekly-contest-303/problems/first-letter-to-appear-twice/
 * 
 * @author hwxy
 * @date 2022/07/24
 **/
public class Lc6124 {
    public static final char L_A = 'a';

    public char repeatedCharacter(String s) {
        char[] scs = s.toCharArray();
        int[] used = new int[26];
        for (char sc : scs) {
            if (used[sc - L_A] == 1) {
                return sc;
            }
            used[sc - L_A] = 1;
        }
        return scs[0];
    }
}
