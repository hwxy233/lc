package com.hwxy.leetcode.order.l800.l720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * 
 * @author hwxy
 * @date 2022/03/17
 **/
public class Lc720 {

    public static void main(String[] args) {
        System.out.println(new Lc720()
                .longestWord(new String[] {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat",
                        "latt", "latte", "c", "ca", "cat"}));
    }

    /**
     * 排序然后用set记录有没有前缀
     * 必须从第一个字母开始有才行
     * 跳着的不行比如["yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq",
     * "yod","ewqz", "y"]不能没有e
     * 
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Arrays.sort(words, (o1, o2) -> {
            // 长度相同按照字典序
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            // 按照长度升序
            return Integer.compare(o1.length(), o2.length());
        });
        String res = "";
        Set<String> prefixSet = new HashSet<>();
        prefixSet.add(res);
        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);
            // 只要有前缀就都放进去
            if (prefixSet.contains(prefix)) {
                // 只维持最大的(字典序的前面是答案)
                if (word.length() > res.length()) {
                    res = word;
                }
                prefixSet.add(word);
            }

        }
        return res;
    }
}
