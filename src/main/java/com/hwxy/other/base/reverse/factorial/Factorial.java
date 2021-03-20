package com.hwxy.other.base.reverse.factorial;

/**
 * 阶乘
 *
 * @author hwxy
 * @date 2021/03/20
 **/
public class Factorial {
    public static void main(String[] args) {
        System.out.println(fat(10));
    }

    private static int fat(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fat(n - 1);
    }
}
