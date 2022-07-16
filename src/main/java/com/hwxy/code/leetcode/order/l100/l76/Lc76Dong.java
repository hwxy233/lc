package com.hwxy.code.leetcode.order.l100.l76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 *
 * @author hwxy
 * @date 2022/07/16
 **/
public class Lc76Dong {
    public static final String EMPTY = "";

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()
                || s.length() < t.length()) {
            return EMPTY;
        }
        char[] tcs = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char tc : tcs) {
            need.put(tc, need.getOrDefault(tc, 0) + 1);
        }
        // 要统计window中不同合法字符的数量
        int valid = 0;
        char[] scs = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        // 窗口的左右指针,左闭右开
        int left = 0;
        int right = 0;
        // ans
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < scs.length) {
            char c = scs[right];
            // 说明可以更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只有字符数量相等才能增加valid
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            // 缩小左
            while (valid == need.size()) {
                int curLen = right - left + 1;
                if (curLen < len) {
                    start = left;
                    len = curLen;
                }
                char popC = scs[left];
                if (need.containsKey(popC)) {
                    // 减少valid
                    if (Objects.equals(need.get(popC), window.get(popC))) {
                        valid--;
                    }
                    // 最小是0
                    window.put(popC, window.getOrDefault(popC, 1) - 1);
                }
                left++;
            }
            // 扩大右
            right++;
        }
        return len == Integer.MAX_VALUE ? EMPTY : s.substring(start, start + len);
    }
}
