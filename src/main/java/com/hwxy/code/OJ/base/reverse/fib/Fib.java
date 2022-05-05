package com.hwxy.code.OJ.base.reverse.fib;

/**
 * 斐波那契
 *
 * @author hwxy
 * @date 2021/03/20
 **/
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
