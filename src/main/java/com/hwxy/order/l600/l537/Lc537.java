package com.hwxy.order.l600.l537;

import java.util.Stack;

/**
 * 537. 复数乘法
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 * 
 * @author hwxy
 * @date 2022/02/25
 **/
public class Lc537 {
    public static void main(String[] args) {
        System.out.println(new Lc537().complexNumberMultiply("11+1i", "11+-1i"));
        // System.out.println(new Lc537().complexNumberMultiply("11+i", "11+-i"));
    }

    /**
     * 解析出常数后带入公式
     * 写的比较
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String complexNumberMultiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        // 1+-1i || 1+-1i,应该将常数解析出来,也就是a,b,c,d
        int[] cs = new int[4];
        int i = 0;
        getC(num1, cs, i);
        i += 2;
        getC(num2, cs, i);
        // 计算(a+b) * (c+d)
        return (cs[0] * cs[2] - cs[1] * cs[3]) + "+" + (cs[0] * cs[3] + cs[1] * cs[2]) + "i";
    }

    private void getC(String num, int[] cs, int index) {
        // 用栈来解常数
        Stack<Character> stack = new Stack<>();
        char[] ncs = num.toCharArray();
        for (char nc : ncs) {
            // +说明是常数,i说明是i的系数
            if (nc == '+' || nc == 'i') {
                int k = 1;
                int c = 0;
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '-') {
                        c *= -1;
                    } else {
                        c += Character.getNumericValue(pop) * k;
                        k *= 10;
                    }

                }
                cs[index++] = c;
                continue;
            }
            stack.push(nc);
        }
    }
}
