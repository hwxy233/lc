package com.hwxy.code.leetcode.order.l500.l438;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 
 * @author hwxy
 * @date 2022/06/23
 **/
public class Lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        // 计数
        int valid = 0;
        char[] scs = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        while (right < scs.length) {
            char c = scs[right];
            // 更新右指针
            if (need.containsKey(c)) {
                int wcnt = window.getOrDefault(c, 0) + 1;
                window.put(c, wcnt);
                // 只有<=才更新va
                if (wcnt <= need.get(c)) {
                    valid++;
                }
            }
            // 当合法的够了就可以缩了
            while (valid == p.length()) {
                // 这种情况说明是答案
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                char d = scs[left];
                // 更新左指针
                if (need.containsKey(d)) {
                    int wcnt = window.getOrDefault(d, 0) - 1;
                    window.put(d, wcnt);
                    // -1后如果小于才更新va
                    if (wcnt < need.get(d)) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
