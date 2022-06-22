package com.hwxy.code.leetcode.order.l1200.l1151;

/**
 * 1108. IP 地址无效化
 * https://leetcode.cn/problems/defanging-an-ip-address/
 * 
 * @author hwxy
 * @date 2022/06/21
 **/
public class Lc1108 {
    public static final char DOAT = '.';
    public static final char LEFT = '[';
    public static final char RIGHT = ']';

    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return address;
        }
        char[] acs = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : acs) {
            if (c == DOAT) {
                sb.append(LEFT).append(c).append(RIGHT);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
