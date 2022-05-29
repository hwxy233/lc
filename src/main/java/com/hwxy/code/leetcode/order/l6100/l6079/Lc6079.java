package com.hwxy.code.leetcode.order.l6100.l6079;

/**
 * 6079. 价格减免
 * https://leetcode.cn/problems/apply-discount-to-prices/
 * 
 * @author hwxy
 * @date 2022/05/29
 **/
public class Lc6079 {
    public static final char DOLLAR = '$';
    public static final char SPACE = ' ';

    public String discountPrices(String sentence, int discount) {
        if (sentence == null || sentence.length() == 0 || discount < 0) {
            return sentence;
        }
        StringBuilder sb = new StringBuilder();
        char[] scs = sentence.toCharArray();
        int dis = 100 - discount;
        for (int i = 0; i < scs.length; i++) {
            if (scs[i] == DOLLAR) {
                sb.append(scs[i]);
                if (i > 0 && scs[i - 1] != SPACE) {
                    continue;
                }
                boolean isNumber = true;
                int start = ++i;
                double number = 0;
                // 看看到底是不是空格
                while (i < scs.length && scs[i] != SPACE) {
                    if (!Character.isDigit(scs[i])) {
                        isNumber = false;
                        break;
                    }
                    number = number * 10 + (scs[i] - '0');
                    i++;
                }
                // 是否真的是数字
                if (isNumber && i != start) {
                    double midRes = dis * number;
                    double res = midRes / 100.00;
                    sb.append(String.format("%.2f", res));
                    if (i < scs.length) {
                        sb.append(scs[i]);
                    }
                } else {
                    for (int j = start; j <= i && j < scs.length; j++) {
                        sb.append(scs[j]);
                    }
                }
            } else {
                // 其他字符,小写,空格等
                sb.append(scs[i]);
            }
        }
        return sb.toString();
    }
}
