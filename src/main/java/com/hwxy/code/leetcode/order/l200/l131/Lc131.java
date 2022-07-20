package com.hwxy.code.leetcode.order.l200.l131;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 131. 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 
 * @author hwxy
 * @date 2021/07/24
 **/
public class Lc131 {

    public static void main(String[] args) {
        // Lc131 lc131 = new Lc131();
        // System.out.println(lc131.partition("aab"));
        String s = "aab";
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        System.out.println(s.charAt(2));
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(1, 2));
    }

    private LinkedList<List<String>> result = new LinkedList<>();

    private LinkedList<String> tmp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    /**
     * 回溯
     * 
     * @param s
     * @param index
     */
    private void backtracking(String s, int index) {
        if (index >= s.length()) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // (左边的)切割后的子串是回文串才放入结果
            if (isPalindrome(s, index, i)) {
                // java的substring就是这么反人类
                tmp.addLast(s.substring(index, i + 1));
            } else {
                continue;
            }
            // [index,i](或[index,i+1))已经切割过了
            backtracking(s, i + 1);
            tmp.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
