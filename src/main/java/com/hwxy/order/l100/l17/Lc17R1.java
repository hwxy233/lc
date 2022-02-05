package com.hwxy.order.l100.l17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc17R1 {

    private static Map<Character, List<String>> MAP;

    static {
        MAP = new HashMap<>(9);
        MAP.put('1', List.of(""));
        MAP.put('2', List.of("a", "b", "c"));
        MAP.put('3', List.of("d", "e", "f"));
        MAP.put('4', List.of("g", "h", "i"));
        MAP.put('5', List.of("j", "k", "l"));
        MAP.put('6', List.of("m", "n", "o"));
        MAP.put('7', List.of("p", "q", "r", "s"));
        MAP.put('8', List.of("t", "u", "v"));
        MAP.put('9', List.of("w", "x", "y", "z"));
        MAP.put('0', List.of(""));
        MAP.put('*', List.of(""));
        MAP.put('#', List.of(""));
    }

    private List<String> res = new LinkedList<>();
    private LinkedList<String> curRes = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[] ds = digits.toCharArray();
        backtracking(ds, 0);
        return res;
    }

    private void backtracking(char[] ds, int startIndex) {
        if (curRes.size() == ds.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : curRes) {
                stringBuilder.append(s);
            }
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = startIndex; i < ds.length; i++) {
            // 横着是数字对应的字母
            List<String> vs = MAP.get(ds[i]);
            for (String s : vs) {
                curRes.add(s);
                // 竖着是下个数字对应的字母
                backtracking(ds, i + 1);
                curRes.removeLast();
            }
        }
    }
}
