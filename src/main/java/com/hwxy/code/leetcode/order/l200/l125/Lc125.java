package com.hwxy.code.leetcode.order.l200.l125;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 
 * @author hwxy
 * @date 2022/05/05
 **/
public class Lc125 {
    /**
     * 双指针
     * 注意判断好左右区间的范围
     * 
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() < 2) {
            return true;
        }
        char[] scs = s.toCharArray();
        for (int left = 0, right = scs.length - 1; left <= right; left++, right--) {
            // 屏蔽掉所有的非数字字母
            while (left < scs.length && !Character.isLetterOrDigit(scs[left])) {
                left++;
            }
            if (left > right) {
                break;
            }
            while (right >= 0 && !Character.isLetterOrDigit(scs[right])) {
                right--;
            }
            if (left > right) {
                break;
            }
            // 数字一定相等
            if (Character.isDigit(scs[left])) {
                if (scs[left] != scs[right]) {
                    return false;
                }
            } else {
                // 忽略大小写
                int leftC = (scs[left] >= 'A' && scs[left] <= 'Z')
                        ? scs[left] + ('a' - 'A')
                        : scs[left];
                int rightC =
                        (scs[right] >= 'A' && scs[right] <= 'Z')
                                ? scs[right] + ('a' - 'A')
                                : scs[right];
                if (leftC != rightC) {
                    return false;
                }
            }
        }
        return true;
    }
}
