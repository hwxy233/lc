package com.hwxy.code.leetcode.order.l800.l744;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 
 * @author hwxy
 * @date 2022/04/03
 **/
public class Lc744 {
    public static void main(String[] args) {
        System.out.println(new Lc744().nextGreatestLetter1(new char[] {'c', 'f', 'j'}, 'c'));
        System.out.println(new Lc744().nextGreatestLetter1(new char[] {'c', 'f', 'j'}, 'j'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (char l : letters) {
            if (l > target) {
                return l;
            }
        }
        // 循环出现
        return letters[0];
    }

    /**
     * 可以二分
     * 
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter1(char[] letters, char target) {
        int low = 0;
        int high = letters.length;
        // 循环
        if (target >= letters[high - 1]) {
            return letters[0];
        }
        // 开区间的二分,high是length,赋值也是mid
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            // 小于向右
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low];
    }
}
