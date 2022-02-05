package com.hwxy.order.l200.l131;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc131R1 {
    private List<List<String>> res = new LinkedList<>();
    private LinkedList<String> curRes = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return res;
        }
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new LinkedList<>(curRes));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 切割,[startIndex,i]是截取的
            String str = s.substring(startIndex, i + 1);
            // 只要借出来的也是回文串才继续l
            if (!isPartition(str)) {
                continue;
            }
            curRes.add(str);
            backtracking(s, i + 1);
            curRes.removeLast();
        }
    }

    private boolean isPartition(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
