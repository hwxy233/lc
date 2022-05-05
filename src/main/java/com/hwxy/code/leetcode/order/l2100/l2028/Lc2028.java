package com.hwxy.code.leetcode.order.l2100.l2028;

import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据
 * https://leetcode-cn.com/problems/find-missing-observations/
 * 
 * @author hwxy
 * @date 2022/03/27
 **/
public class Lc2028 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lc2028().missingRolls(new int[] {1, 5, 6}, 4, 40)));
        System.out
                .println(
                        Arrays.toString(
                                new Lc2028().missingRolls(
                                        new int[] {4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4,
                                                5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5},
                                        3, 4)));
        System.out.println(Arrays.toString(new Lc2028().missingRolls(new int[] {1}, 3, 1)));
        System.out
                .println(Arrays.toString(new Lc2028().missingRolls(new int[] {1, 2, 3, 4}, 6, 4)));
        System.out
                .println(Arrays.toString(new Lc2028().missingRolls(new int[] {3, 2, 4, 3}, 4, 2)));
    }

    // private List<Integer> res;
    // private int sumN;
    // private int n;
    // public static final int[] SIX = new int[] {1, 2, 3, 4, 5, 6};
    public static final int[] EMPTY = new int[0];
    // private int sum;

    // /**
    // * 回溯会超时
    // * 求出sum(n)然后看能不能找到n个[1,6]的数满足和为sum(n)
    // *
    // * @param rolls
    // * @param mean
    // * @param n
    // * @return
    // */
    // public int[] missingRolls1(int[] rolls, int mean, int n) {
    // if (rolls == null || rolls.length == 0 || mean < 0 || n < 0) {
    // return EMPTY;
    // }
    // int sum = mean * (n + rolls.length);
    // int sumM = Arrays.stream(rolls).sum();
    // sumN = sum - sumM;
    // this.n = n;
    // res = new ArrayList<>(this.n);
    // backtracking();
    // if (res.isEmpty()) {
    // return EMPTY;
    // }
    // return res.stream().mapToInt(i -> i).toArray();
    // }
    //
    // /**
    // * 回溯
    // */
    // private boolean backtracking() {
    // if (res.size() == n) {
    // return sumN == sum;
    // }
    // for (int i : SIX) {
    // res.add(i);
    // sum += i;
    // boolean result = backtracking();
    // if (result) {
    // return true;
    // }
    // sum -= i;
    // res.remove(res.size() - 1);
    // }
    // return false;
    // }

    /**
     * 求出sumN,然后算出商和余数
     * 余数个数的分配商+1
     * n-余数,分配商
     * 
     * @param rolls
     * @param mean
     * @param n
     * @return
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        if (rolls == null || rolls.length == 0 || mean < 0 || n < 0) {
            return EMPTY;
        }
        int sum = mean * (n + rolls.length);
        int sumM = Arrays.stream(rolls).sum();
        int sumN = sum - sumM;
        if (sumN > n * 6 || sumN < n) {
            return EMPTY;
        }
        int p = sumN / n;
        int y = sumN % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = p + (i < y ? 1 : 0);
        }
        return res;
    }
}
