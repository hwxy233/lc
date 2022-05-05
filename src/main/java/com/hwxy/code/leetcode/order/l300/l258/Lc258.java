package com.hwxy.code.leetcode.order.l300.l258;

/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 * 
 * @author hwxy
 * @date 2022/03/03
 **/
public class Lc258 {
    public static void main(String[] args) {
        System.out.println(new Lc258().addDigits(38));
    }

    /**
     * return (num - 1) % 9 + 1;
     * 
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 0) {
            return num;
        }
        while (num >= 10) {
            int sum = 0;
            int cur = num;
            while (cur > 0) {
                sum += cur % 10;
                cur = cur / 10;
            }
            num = sum;
        }
        return num;
    }
}
