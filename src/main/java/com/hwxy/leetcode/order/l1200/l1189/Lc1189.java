package com.hwxy.leetcode.order.l1200.l1189;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 * 
 * @author hwxy
 * @date 2022/02/13
 **/
public class Lc1189 {
    public static void main(String[] args) {
        System.out.println(new Lc1189().maxNumberOfBalloons("loonbalxballpoon"));
    }

    /**
     * hash表统计频次,最后看最短的数量
     * 
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7) {
            return 0;
        }
        Map<Character, Integer> wordCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }
        }
        // 没有凑够
        if (wordCount.size() != 5) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        // 所有字母的最小值就是最终数量
        for (Map.Entry<Character, Integer> wc : wordCount.entrySet()) {
            switch (wc.getKey()) {
                case 'a':
                case 'b':
                case 'n':
                    res = Math.min(res, wc.getValue());
                    break;
                case 'l':
                case 'o':
                    int count = wc.getValue() / 2;
                    if (count == 0) {
                        count = 1;
                    }
                    res = Math.min(res, count);
                    break;
                default:
            }
        }
        return res;
    }
}
