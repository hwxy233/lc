package com.hwxy.code.leetcode.order.l1700.l1662;

import java.util.Objects;

/**
 * 1662. 检查两个字符串数组是否相等
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 *
 * @author hwxy
 * @date 2022/11/01
 **/
public class Lc1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        for (String w : word1) {
            sb1.append(w);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String w : word2) {
            sb2.append(w);
        }
        //        String w1 = Arrays.stream(word1).reduce("", (i, w) -> i + w);
        //        String w2 = Arrays.stream(word2).reduce("", (i, w) -> i + w);
        return Objects.equals(sb1.toString(), sb2.toString());
    }
}
