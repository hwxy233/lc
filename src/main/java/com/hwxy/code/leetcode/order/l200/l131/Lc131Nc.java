package com.hwxy.code.leetcode.order.l200.l131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning/
 *
 * @author hwxy
 * @date 2022/07/18
 **/
public class Lc131Nc {

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();
        backtracking(s, 0, tmp, ans);
        return ans;
    }

    private void backtracking(String s, int index, LinkedList<String> tmp, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new LinkedList<>(tmp));
        }
        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(index, i + 1);
            if (isPa(cur)) {
                tmp.add(cur);
            } else {
                continue;
            }
            backtracking(s, i + 1, tmp, ans);
            tmp.removeLast();
        }
    }

    private boolean isPa(String cur) {
        for (int left = 0, right = cur.length() - 1; left < right; left++, right--) {
            if (cur.charAt(left) != cur.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
