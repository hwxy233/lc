package com.hwxy.order.l200.l131;

import java.util.LinkedList;
import java.util.List;

/**
 * 131复习
 *
 * @author hwxy
 * @date 2021/10/02
 **/
public class Lc131R {

    public static void main(String[] args) {
        Lc131R lc131R = new Lc131R();
        System.out.println(lc131R.partition("aab"));
    }

    private LinkedList<List<String>> res = new LinkedList<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        backtracking(s, 0);
        return res;

    }

    private void backtracking(String s, int index) {
        if (index == s.length()) {
            res.add(new LinkedList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (!checkPath(sub)) {
                continue;
            }
            path.add(sub);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean checkPath(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPath(String s, int startI, int endI) {
        for (int i = startI, j = endI; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
