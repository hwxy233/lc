package com.hwxy.code.leetcode.order.l800.l717;

/**
 * 717. 1比特与2比特字符
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * 
 * @author hwxy
 * @date 2022/02/20
 **/
public class Lc717 {
    public static void main(String[] args) {
        System.out.println(new Lc717().isOneBitCharacter(new int[] {1, 1, 1, 0}));
        System.out.println(new Lc717().isOneBitCharacter(new int[] {0, 0}));
        System.out.println(new Lc717().isOneBitCharacter(new int[] {1, 1, 1, 1, 1, 1, 0}));
    }

    /**
     * 顺着遍历
     * 
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i;
        // 停在n - 1
        for (i = 0; i < bits.length - 1; i++) {
            // 只要是1就多加1次
            if (bits[i] == 1) {
                i++;
            }
        }
        return i == bits.length - 1;
    }
}
