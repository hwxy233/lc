package com.hwxy.leetcode.order.l300.l204;

/**
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 * 
 * @author hwxy
 * @date 2022/04/05
 **/
public class Lc204 {
    public static void main(String[] args) {
        System.out.println(new Lc204().countPrimes(4));
    }

    /**
     * 从[2,根号n]判断求模
     * 
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
