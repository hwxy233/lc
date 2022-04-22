package com.hwxy.leetcode.order.l700.l693;

/**
 * 693. 交替位二进制数
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * 
 * @author hwxy
 * @date 2022/03/28
 **/
public class Lc693 {
    public static void main(String[] args) {
        System.out.println(new Lc693().hasAlternatingBits(10));
    }

    /**
     * 右移
     * 亦或
     * +1与
     * 
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        // 右移一位
        int a = n >> 1;
        // 亦或后如果是交替的则为全1
        int b = n ^ a;
        // b + 1应该为进位1后全0,然后&b应该为0
        int c = (b + 1) & b;
        return c == 0;
    }
}
