package com.hwxy.code.leetcode.order.l500.l438;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 *
 * @author hwxy
 * @date 2022/07/16
 **/
public class Lc438Nc {

    public List<Integer> findAnagrams(String s, String p) {
        // s里找p
        if (s == null || p == null || s.isEmpty() ||
                p.isEmpty() || s.length() < p.length()) {
            return Collections.emptyList();
        }
        // p, need
        char[] pcs = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char pc : pcs) {
            need.put(pc, need.getOrDefault(pc, 0) + 1);
        }
        // s, window
        char[] scs = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < scs.length) {
            char offerC = scs[right];
            if (need.containsKey(offerC)) {
                window.put(offerC, window.getOrDefault(offerC, 0) + 1);
                // 增加valid
                if (Objects.equals(window.get(offerC), need.get(offerC))) {
                    valid++;
                }
            }
            // 保证窗口最多长度为pcs
            while (right - left + 1 >= pcs.length) {
                // 和need相等才行
                if (valid == need.size()) {
                    ans.add(left);
                }
                char popC = scs[left];
                if (need.containsKey(popC)) {
                    // 减少valid
                    if (Objects.equals(window.get(popC), need.get(popC))) {
                        valid--;
                    }
                    window.put(popC, window.get(popC) - 1);
                }
                // 缩小左窗口
                left++;
            }
            // 扩大右窗口
            right++;
        }
        return ans;
    }
}
