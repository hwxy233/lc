package com.hwxy.leetcode.order.l300.l242;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc242 {
    public static void main(String[] args) {
        System.out.println(new Lc242().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // 记录出现次数,26个字母
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        // 抵消相同的
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        // 只要都是0则说明可以
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
