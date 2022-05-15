package com.hwxy.code.leetcode.order.l5300.l5234;

import java.util.*;

/**
 * 5234. 移除字母异位词后的结果数组
 * https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/
 * 
 * @author hwxy
 * @date 2022/05/15
 **/
public class Lc5234 {
    public List<String> removeAnagrams(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        // 从i=1开始不断遍历,直到i=length-1
        List<String> res = new ArrayList<>();
        // 第一个肯定在结果里
        res.add(words[0]);
        for (int left = 0, right = 1; right < words.length; right++) {
            if (isAnagrams(words[left], words[right])) {
                continue;
            }
            res.add(words[right]);
            left = right;
        }
        return res;
    }

    private boolean isAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] acs = a.toCharArray();
        Map<Character, Integer> acsCounter = new HashMap<>();
        for (char ac : acs) {
            acsCounter.put(ac, acsCounter.getOrDefault(ac, 0) + 1);
        }
        char[] bcs = b.toCharArray();
        Map<Character, Integer> bcsCounter = new HashMap<>();
        for (char bc : bcs) {
            bcsCounter.put(bc, bcsCounter.getOrDefault(bc, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : acsCounter.entrySet()) {
            if (!Objects.equals(entry.getValue(), bcsCounter.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}
