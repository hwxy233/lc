package com.hwxy.order.l600.l504;

/**
 * 504. 七进制数
 * https://leetcode-cn.com/problems/base-7/
 * 
 * @author hwxy
 * @date 2022/03/07
 **/
public class Lc504 {
    public static void main(String[] args) {
        System.out.println(new Lc504().convertToBase7(100));
        System.out.println(new Lc504().convertToBase7(-7));
    }

    /**
     * 辗转想出发?
     * 每次除以7的结果是下次的被除数,而7进制的数为这次的余数
     * 最后的结果是所有余数的翻转
     * 
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int dividend = Math.abs(num);
        while (dividend > 0) {
            int m = dividend % 7;
            dividend = dividend / 7;
            sb.append(m);
        }
        sb.reverse();
        if (num < 0) {
            return "-" + sb;
        }
        return sb.toString();
    }
}
