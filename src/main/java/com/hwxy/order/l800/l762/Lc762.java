package com.hwxy.order.l800.l762;

/**
 * 762. 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 
 * @author hwxy
 * @date 2022/04/05
 **/
public class Lc762 {

    public static void main(String[] args) {
        System.out.println(new Lc762().countPrimeSetBits(6, 10));
    }

    /**
     * 先找1
     * 再判断质数
     * 
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            int bitCnt = Integer.bitCount(i);
            res += isPrimes(bitCnt) ? 1 : 0;
        }
        return res;
    }

    private boolean isPrimes(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
