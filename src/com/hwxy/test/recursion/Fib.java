package com.hwxy.test.recursion;

import java.time.Instant;

/**
 * 斐波那契数列
 */
public class Fib {

    public static void main(String[] args) {
        long startTime = Instant.now().getEpochSecond();
        System.out.println(calFib(20));
        System.out.println("cost: " + (Instant.now().getEpochSecond() - startTime));
        startTime = Instant.now().getEpochSecond();
        System.out.println(calFibDp(20));
        System.out.println("cost: " + (Instant.now().getEpochSecond() - startTime));
    }

    /**
     * 计算斐波那契数列-dp
     * 有一个cache缓存结果
     *
     * @param n 计算f(n)
     * @return 相加之和
     */
    static int calFibDp(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        // dp-table
        int[] resultDp = new int[n + 1];
        resultDp[1] = resultDp[2] = 1;
        for (int i = 3; i <= n; i++) {
            resultDp[i] = resultDp[i - 1] + resultDp[i - 2];
        }
        return resultDp[n];
    }

    /**
     * 计算斐波那契数列
     * 有一个cache缓存结果
     *
     * @param n 计算f(n)
     * @return 相加之和
     */
    static int calFib(int n) {
        if (n < 1) {
            return 0;
        }
        // 缓存上次的计算结果
        int[] resultCache = new int[n + 1];
        return fib(resultCache, n);
    }

    /**
     * 实际的计算函数
     *
     * @param resultCache 缓存,每次先从这里找下
     * @param n           当前要算的
     * @return f(n)
     */
    private static int fib(int[] resultCache, int n) {
        if (n <= 2) {
            return 1;
        }
        // 每次先检查cache
        int cache = resultCache[n];
        if (cache != 0) {
            return cache;
        }
        // f(n-1) + f(n-2)
        int result = fib(resultCache, n - 1) + fib(resultCache, n - 2);
        // 缓存结果
        resultCache[n] = result;
        return result;
    }
}
