package com.hwxy.code.leetcode.order.l6100.l6078;

import java.util.HashMap;
import java.util.Map;

/**
 * 6078. 重排字符形成目标字符串
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 * 
 * @author hwxy
 * @date 2022/05/29
 **/
public class Lc6078 {
    public int rearrangeCharacters(String s, String target) {
        if (s == null || s.length() == 0 || target == null || target.length() == 0) {
            return 0;
        }
        Map<Character, Integer> sCharCounter = new HashMap<>();
        for (char c : s.toCharArray()) {
            sCharCounter.put(c, sCharCounter.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> targetCharCounter = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetCharCounter.put(c, targetCharCounter.getOrDefault(c, 0) + 1);
        }
        // 从target里找最小
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCharCounter.entrySet()) {
            Integer sCharCount = sCharCounter.get(entry.getKey());
            // 不够拼成一个
            if (sCharCount == null || sCharCount < entry.getValue()) {
                return 0;
            }
            ans = Math.min(ans, sCharCount / entry.getValue());
        }
        return ans;
    }
}
