package com.hwxy.leetcode.order.l100.l17;

import java.util.*;

/**
 * 17复习
 *
 * @author hwxy
 * @date 2021/10/01
 **/
public class Lc17R {

    public static void main(String[] args) {
        Lc17R lc17R = new Lc17R();
        System.out.println(lc17R.letterCombinations("23"));
    }

    private Map<Character, List<String>> kb = new HashMap<>() {
        {
            put('2', Arrays.asList("a", "b", "c"));
            put('3', Arrays.asList("d", "e", "f"));
            put('4', Arrays.asList("g", "h", "i"));
            put('5', Arrays.asList("j", "k", "l"));
            put('6', Arrays.asList("m", "n", "o"));
            put('7', Arrays.asList("p", "q", "r", "s"));
            put('8', Arrays.asList("t", "u", "v"));
            put('9', Arrays.asList("w", "x", "y", "z"));
        }
    };

    private LinkedList<String> result = new LinkedList<>();

    private String path = "";

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, digits.length(), 0);
        return result;
    }

    private void backtracking(String digits, int length, int index) {
        if (path.length() == length) {
            result.add(path);
        }
        if (index >= digits.length()) {
            return;
        }
        char k = digits.charAt(index);
        List<String> words = kb.get(k);
        for (String word : words) {
            path += word;
            backtracking(digits, length, index + 1);
            path = path.substring(0, path.length() - 1);
        }
    }
}
