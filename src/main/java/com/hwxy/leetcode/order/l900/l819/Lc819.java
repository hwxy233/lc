package com.hwxy.leetcode.order.l900.l819;

import java.util.*;

/**
 * 819. 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 * 
 * @author hwxy
 * @date 2022/04/17
 **/
public class Lc819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return paragraph;
        }
        // 小写的
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> cnt = new HashMap<>();
        char[] cs = paragraph.toCharArray();
        // 空格,逗号,句号都是一个单次的结尾
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            // 正常的字母
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '?' || c == '!' || c == '\'' || c == ';' || c == ',' || c == ' '
                    || c == '.') {
                // 一个单词的结束 !?',;.
                String word = sb.toString().toLowerCase();
                sb = new StringBuilder();
                if (word.isEmpty() || bannedSet.contains(word)) {
                    continue;
                }
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
        }
        String word = sb.toString();
        if (!word.isEmpty()) {
            word = word.toLowerCase();
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        if (cnt.size() == 1) {
            return cnt.entrySet().stream().findAny().get().getKey();
        }
        return cnt.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get()
                .getKey();
    }
}
