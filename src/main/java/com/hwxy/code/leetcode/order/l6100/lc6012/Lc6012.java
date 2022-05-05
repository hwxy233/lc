package com.hwxy.code.leetcode.order.l6100.lc6012;

/**
 * 周赛
 * 6012. 统计各位数字之和为偶数的整数个数
 * https://leetcode-cn.com/problems/count-integers-with-even-digit-sum/
 * 
 * @author hwxy
 * @date 2022/02/20
 **/
public class Lc6012 {

    public static void main(String[] args) {
        System.out.println(new Lc6012().countEven(30));
        System.out.println(new Lc6012().countEven(4));
    }

    public int countEven(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (isO(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isO(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum % 2 == 0;
    }
}
