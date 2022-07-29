package com.hwxy.code.leetcode.order.l600.l592;

/**
 * 592. 分数加减运算
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/
 * 
 * @author hwxy
 * @date 2022/07/27
 **/
public class Lc592 {

    public static final char NEGATIVE = '-';
    public static final char POSITIVE = '+';
    public static final char CHAR_ZERO = '0';

    public static final String STR_ZERO_ANS = "0/1";

    public static final String SP = "/";

    public String fractionAddition(String expression) {
        if (expression == null || expression.isEmpty()) {
            return expression;
        }
        // 分子
        long numerator = 0;
        // 分母
        long denominator = 1;
        int index = 0;
        char[] es = expression.toCharArray();
        while (index < es.length) {
            // 找正负号
            long sign = 1;
            if (es[index] == NEGATIVE || es[index] == POSITIVE) {
                sign = es[index] == NEGATIVE ? -1 : 1;
                index++;
            }
            // 找分子
            long curNumerator = 0;
            while (index < es.length && Character.isDigit(es[index])) {
                curNumerator = curNumerator * 10 + (es[index] - CHAR_ZERO);
                index++;
            }
            curNumerator *= sign;
            // 跳过分号/
            index++;
            // 找分母
            long curDenominator = 0;
            while (index < es.length && Character.isDigit(es[index])) {
                curDenominator = curDenominator * 10 + (es[index] - CHAR_ZERO);
                index++;
            }
            // 计算和
            numerator = numerator * curDenominator + denominator * curNumerator;
            denominator = denominator * curDenominator;
        }
        // 约分化简
        if (numerator == 0) {
            return STR_ZERO_ANS;
        }
        long gcd = gcd(Math.abs(numerator), denominator);
        StringBuilder ans = new StringBuilder();
        return ans.append(numerator / gcd).append(SP).append(denominator / gcd).toString();
    }

    /**
     * a / b = q...r
     * f(a,b) = f(b,r)
     * 当b=0,则a是答案
     * 
     * @param numerator
     * @param denominator
     * @return
     */
    private long gcd(long numerator, long denominator) {
        return denominator > 0 ? gcd(denominator, numerator % denominator) : numerator;
    }
}
