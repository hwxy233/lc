package com.hwxy.code.leetcode.order.l800.l784;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * https://leetcode.cn/problems/letter-case-permutation/
 *
 * @author hwxy
 * @date 2022/10/30
 **/
public class Lc784 {
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }
        List<String>[] dp = new List[s.length()];
        // dp[i] = dp[i-1]的所有拼接上该字符的小写和大小(如果该字符是字母)
        // 正向
        // dp[0] = 第一个字符的大小写(如果是字母)
        // 但会dp[n-1]
        char[] cs = s.toCharArray();
        List<String> dp0 = new ArrayList<>(0);
        if (Character.isLetter(cs[0])) {
            dp0.add(String.valueOf(Character.toLowerCase(cs[0])));
            dp0.add(String.valueOf(Character.toUpperCase(cs[0])));
        } else {
            dp0.add(String.valueOf(cs[0]));
        }
        dp[0] = dp0;
        for (int i = 1; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                List<String> tmp = new ArrayList<>(dp[i - 1].size());
                for (String pre : dp[i - 1]) {
                    tmp.add(pre + cs[i]);
                }
                dp[i] = tmp;
            } else {
                List<String> tmp = new ArrayList<>(dp[i - 1].size() * 2);
                for (String pre : dp[i - 1]) {
                    tmp.add(pre + Character.toLowerCase(cs[i]));
                    tmp.add(pre + Character.toUpperCase(cs[i]));
                }
                dp[i] = tmp;
            }
        }
        return dp[dp.length - 1];
    }
}
