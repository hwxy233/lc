package com.hwxy.normal.reverse;

import java.util.Objects;

/**
 * 反转打印字符串
 */
public class Sl344 {

    /**
     * 2. 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * <p>
     * 示例 1：
     * <p>
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     * <p>
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     */
    public void reverseString(char[] s) {
        if (Objects.isNull(s) || s.length <= 1) {
            System.out.println(s);
        }
        int count = s.length / 2;
        int len = s.length - 1;
        reverse(s, count, len, 0);
        System.out.println(s);
    }

    private void reverse(char[] s, int count, int len, int current) {
        if (count <= 0) {
            return;
        }
        char currentTmp = s[current];
        s[current] = s[s.length - 1 - current];
        s[s.length - 1 - current] = currentTmp;
        reverse(s, --count, len, ++current);
    }

    public static void main(String[] args) {
        Sl344 printReverse = new Sl344();
        printReverse.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
