package com.hwxy.code.leetcode.order.l100.l76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 * 模板
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * 
 * @author hwxy
 * @date 2022/06/25
 **/
public class Lc76R1 {
    public static final String EMPTY = "";

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
            return EMPTY;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = t.length();
        Map<Character, Integer> window = new HashMap<>(need.size());
        String ans = EMPTY;
        char[] scs = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < scs.length) {
            // 右窗口
            char rc = scs[right];
            Integer rcCnt = need.get(rc);
            if (rcCnt != null) {
                int windowCnt = window.getOrDefault(rc, 0) + 1;
                window.put(rc, windowCnt);
                if (windowCnt <= rcCnt) {
                    valid--;
                }
            }
            // 左窗口
            while (valid == 0) {
                // 只有小于长度才更新
                if (ans.length() == 0 || ans.length() > (right - left + 1)) {
                    ans = s.substring(left, right + 1);
                }
                char lc = scs[left];
                Integer lcCnt = window.get(lc);
                if (lcCnt != null) {
                    lcCnt = lcCnt - 1;
                    window.put(lc, lcCnt);
                    if (lcCnt < need.get(lc)) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
