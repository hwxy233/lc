package com.hwxy.code.leetcode.order.l1400.l1374;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 * 
 * @author hwxy
 * @date 2022/08/01
 **/
public class Lc1374 {
    public static final String EMPTY = "";

    public static final String L_A = "a";

    /**
     * 可以提前生成最大数量的RES,之后直接subString即可
     */
    public static final String RES;

    static {
        RES = L_A.repeat(500);
    }

    public static final String L_B = "b";

    public String generateTheString(int n) {
        if (n <= 0) {
            return EMPTY;
        }
        if (n % 2 == 0) {
            return RES.substring(0, n - 1) + L_B;
        }
        return RES.substring(0, n);
    }
}
