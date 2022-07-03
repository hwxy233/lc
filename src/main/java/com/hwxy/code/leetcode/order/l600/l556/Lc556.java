package com.hwxy.code.leetcode.order.l600.l556;

/**
 * 556. 下一个更大元素 III
 * https://leetcode.cn/problems/next-greater-element-iii/
 * 思路同31
 * 
 * @author hwxy
 * @date 2022/07/03
 **/
public class Lc556 {

    public int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(n + "");
        for (int i = sb.length() - 1; i > 0; i--) {
            char right = sb.charAt(i);
            char left = sb.charAt(i - 1);
            if (right > left) {
                return swapAndReverse(sb, left, i - 1);
            }
        }
        return -1;
    }

    private int swapAndReverse(StringBuilder sb, char startChar, int startIndex) {
        for (int i = sb.length() - 1; i > startIndex; i--) {
            if (sb.charAt(i) > startChar) {
                swap(sb, startIndex, i);
                // 翻转后面的
                for (int left = startIndex + 1,
                        right = sb.length() - 1; left < right; left++, right--) {
                    swap(sb, left, right);
                }
                break;
            }
        }
        long val = Long.parseLong(sb.toString());
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    private void swap(StringBuilder sb, int left, int right) {
        char tmp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, tmp);
    }
}
