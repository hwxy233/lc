package com.hwxy.leetcode.order.l100.l17;

import java.util.*;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/07/11
 **/
public class Lc17 {

    public static void main(String[] args) {
        Lc17 lc17 = new Lc17();
        System.out.println(lc17.letterCombinations("23"));
    }

    /**
     * 键盘的映射关系
     * 为什么不都是3个？？？
     */
    private final Map<Character, List<String>> keyBord;

    /**
     * 数字的组合情况
     */
    private final LinkedList<String> digitsResult = new LinkedList<>();

    /**
     * 数字的组合path
     */
    private StringBuilder digitsPath = new StringBuilder();

    {
        keyBord = new HashMap<>();
        keyBord.put('1', Collections.emptyList());
        keyBord.put('2', Arrays.asList("a", "b", "c"));
        keyBord.put('3', Arrays.asList("d", "e", "f"));
        keyBord.put('4', Arrays.asList("g", "h", "i"));
        keyBord.put('5', Arrays.asList("j", "k", "l"));
        keyBord.put('6', Arrays.asList("m", "n", "o"));
        keyBord.put('7', Arrays.asList("p", "q", "r", "s"));
        keyBord.put('8', Arrays.asList("t", "u", "v"));
        keyBord.put('9', Arrays.asList("w", "x", "y", "z"));
    }


    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.length() > 4 || digits.length() <= 0) {
            return Collections.emptyList();
        }
        // 数字的组合只有一种就是顺着的
        backtrackingDigits(digits, digits.length(), 0);
        return digitsResult;
    }

    private void backtrackingDigits(String digits, int length, int startIndex) {
        if (digitsPath.length() == length) {
            digitsResult.add(digitsPath.toString());
            return;
        }
        // 横着对数字(数字对应的字母),这个for循环意义不大了因为startIndex永远是i+1
        // for (int i = startIndex; i < length; i++) {
        // 数字对应的字母
        List<String> keys = keyBord.get(digits.charAt(startIndex));
        // 其实横着的是对应的字母
        for (String key : keys) {
            // 先把自己放进去
            digitsPath.append(key);
            // 然后遍历下个数字
            backtrackingDigits(digits, length, startIndex + 1);
            // 回溯
            digitsPath.deleteCharAt(digitsPath.length() - 1);
        }
        // }
    }
}
