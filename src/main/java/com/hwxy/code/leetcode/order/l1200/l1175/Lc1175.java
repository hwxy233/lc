package com.hwxy.code.leetcode.order.l1200.l1175;

/**
 * 1175. 质数排列
 * https://leetcode.cn/problems/prime-arrangements/
 * 
 * @author hwxy
 * @date 2022/06/30
 **/
public class Lc1175 {

    public static final long MOD = (long) (Math.pow(10, 9) + 7);

    public int numPrimeArrangements(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int primeCnt = 1;
        for (int i = n; i > 2; i--) {
            boolean isPrime = true;
            for (int j = (int) Math.sqrt(i); j > 1; j--) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeCnt++;
            }
        }
        int normalCnt = n - primeCnt;
        long norSum;
        long primeSum;
        if (normalCnt < primeCnt) {
            norSum = calSum(1, 1, normalCnt);
            primeSum = calSum(norSum, normalCnt + 1, primeCnt);
        } else if (normalCnt > primeCnt) {
            primeSum = calSum(1, 1, primeCnt);
            norSum = calSum(primeSum, primeCnt + 1, normalCnt);
        } else {
            norSum = calSum(1, 1, normalCnt);
            primeSum = norSum;
        }
        return (int) ((norSum * primeSum) % MOD);
    }

    private long calSum(long sum, int start, int cnt) {
        for (int i = start; i <= cnt; i++) {
            sum *= i;
            sum %= MOD;
        }
        return sum;
    }
}
