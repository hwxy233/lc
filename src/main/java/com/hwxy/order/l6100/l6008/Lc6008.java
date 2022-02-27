package com.hwxy.order.l6100.l6008;

/**
 * 6008. 统计包含给定前缀的字符串
 * https://leetcode-cn.com/contest/weekly-contest-282/problems/counting-words-with-a-given-prefix/
 * 
 * @author hwxy
 * @date 2022/02/27
 **/
public class Lc6008 {
    public static void main(String[] args) {
        System.out.println(new Lc6008()
                .prefixCount(new String[] {"pay", "attention", "practice", "attend"}, "at"));
    }

    public int prefixCount(String[] words, String pref) {
        if (words == null || words.length == 0 || pref == null) {
            return 0;
        }
        if (pref.length() == 0) {
            return words.length;
        }
        int cnt = 0;
        for (String w : words) {
            if (w.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}
