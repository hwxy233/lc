package com.hwxy.code.leetcode.order.l1500.l1406;

import java.util.*;

/**
 * 1408. 数组中的字符串匹配
 * https://leetcode.cn/problems/string-matching-in-an-array/
 * 
 * @author hwxy
 * @date 2022/08/06
 **/
public class Lc1406 {
    public List<String> stringMatching(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() == word.length()) {
                    continue;
                }
                // add一次就行了
                if (words[j].contains(word)) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }
}
