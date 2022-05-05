package com.hwxy.code.leetcode.order.l100.l28;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc28 {
    public static void main(String[] args) {
        System.out.println(new Lc28().strStr("aabaabaaf", "aabaaf"));
        System.out.println(new Lc28().strStr("", ""));
    }

    /**
     * kmp
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        // 空串默认都匹配
        if (needle.isEmpty()) {
            return 0;
        }
        char[] na = needle.toCharArray();
        // 构建next数组,这里还不进行右移使用原始的前缀表
        int[] next = new int[needle.length()];
        // 前缀尾巴和后缀的尾巴
        int j = 0;
        int i = 0;
        next[i] = j;
        for (i = 1; i < needle.length(); i++) {
            // 不相等
            while (j > 0 && na[i] != na[j]) {
                // 从前缀表找到j-1对应的value(下标)进行回退
                j = next[j - 1];
            }
            if (na[i] == na[j]) {
                j++;
            }
            next[i] = j;
        }
        // 进行匹配
        char[] ha = haystack.toCharArray();
        for (i = 0, j = 0; i < haystack.length(); i++) {
            // 不相等
            while (j > 0 && ha[i] != na[j]) {
                // 从前缀表找到j-1对应的value(下标)进行回退
                j = next[j - 1];
            }
            // 相等
            if (ha[i] == na[j]) {
                j++;
            }
            // 如果j到了模式串的尾巴(注意不要-1因为上面进行了++)
            if (j == needle.length()) {
                // 要开头就要+1
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
