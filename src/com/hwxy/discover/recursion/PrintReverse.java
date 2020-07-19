package com.hwxy.discover.recursion;

import java.util.Objects;

/**
 * 反转打印字符串
 * <p>
 * 你可能想知道如何实现调用自身的函数。诀窍在于，每当递归函数调用自身时，它都会将给定的问题拆解为子问题。
 * 递归调用继续进行，直到到子问题无需进一步递归就可以解决的地步。
 * <p>
 * 为了确保递归函数不会导致无限循环，它应具有以下属性：
 * <p>
 * 一个简单的基本案例（basic case）（或一些案例） —— 能够不使用递归来产生答案的终止方案。
 * 一组规则，也称作递推关系（recurrence relation），可将所有其他情况拆分到基本案例。
 */
public class PrintReverse {

    /**
     * 1. 你可以使用迭代的办法轻而易举地解决这个问题，即从字符串的最后一个字符开始遍历字符串。
     * 但是如何递归地解决它呢？
     * <p>
     * 首先，我们可以将所需的函数定义为 printReverse(str[0...n-1])，
     * 其中 str[0] 表示字符串中的第一个字符。
     * 然后我们可以分两步完成给定的任务：
     * <p>
     * printReverse(str[1...n-1])：以相反的顺序打印子字符串 str[1...n-1] 。
     * print(str[0])：打印字符串中的第一个字符。
     */
    private static void printReverse(char[] str) {
        helper(0, str);
    }

    private static void helper(int index, char[] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }

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
        PrintReverse printReverse = new PrintReverse();
        printReverse.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
