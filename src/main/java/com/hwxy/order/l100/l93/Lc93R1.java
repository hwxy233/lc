package com.hwxy.order.l100.l93;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc93R1 {
    private List<String> res = new LinkedList<>();
    private LinkedList<String> curRes = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.isEmpty()) {
            return res;
        }
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            if (curRes.size() == 4) {
                StringBuilder stringBuilder = new StringBuilder();
                int c = 0;
                for (String i : curRes) {
                    if (c++ == 0) {
                        stringBuilder.append(i);
                    } else {
                        stringBuilder.append(".").append(i);
                    }
                }
                res.add(stringBuilder.toString());
            }
            return;
        }
        // 剪枝
        for (int i = startIndex; i < s.length(); i++) {
            // 剩余的可切割的长度至少要小于等于ip段的长度
            if ((4 - curRes.size()) * 3 < s.length() - i) {
                continue;
            }
            String str = s.substring(startIndex, i + 1);
            // 0开头 || 大于255
            if ((str.length() != 1 && str.startsWith("0")) || Integer.parseInt(str) > 255) {
                return;
            }
            curRes.add(str);
            backtracking(s, i + 1);
            curRes.removeLast();
        }
    }
}
