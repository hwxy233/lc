package com.hwxy.code.leetcode.order.l300.l242;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc242NeetCode {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCharCounter = new HashMap<>();
        Map<Character, Integer> tCharCounter = new HashMap<>();
        countChars(s, sCharCounter);
        countChars(t, tCharCounter);
        for (Map.Entry<Character, Integer> entry : sCharCounter.entrySet()) {
            if (!Objects.equals(entry.getValue(), tCharCounter.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private void countChars(String s, Map<Character, Integer> charCounter) {
        for (char c : s.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }
    }
}
