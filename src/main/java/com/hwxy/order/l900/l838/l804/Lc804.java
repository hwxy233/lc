package com.hwxy.order.l900.l838.l804;

import java.util.*;

/**
 * 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * 
 * @author hwxy
 * @date 2022/04/10
 **/
public class Lc804 {
    /**
     * 直接用个map记录映射
     * 然后找个set去重
     * 可以map替换为数组
     */
    private static final Map<Character, String> WORD_MORSE;
    static {
        List<String> list = Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..");
        Character c = 'a';
        WORD_MORSE = new HashMap<>(list.size());
        for (int i = 0; i < list.size(); i++, c++) {
            WORD_MORSE.put(c, list.get(i));
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(WORD_MORSE.get(c));
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}
