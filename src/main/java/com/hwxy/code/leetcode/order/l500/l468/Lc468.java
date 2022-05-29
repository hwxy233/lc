package com.hwxy.code.leetcode.order.l500.l468;

/**
 * 468. 验证IP地址
 * https://leetcode.cn/problems/validate-ip-address/
 * 
 * @author hwxy
 * @date 2022/05/29
 **/
public class Lc468 {
    public static final String IPV4 = "IPv4";
    public static final String IPV6 = "IPv6";
    public static final String NEITHER = "Neither";
    public static final char V4SP = '.';
    public static final char V6SP = ':';

    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() < 7) {
            return NEITHER;
        }
        char[] ipcs = queryIP.toCharArray();
        // 0.0.0.0
        // 0:0:0:0:0:0:0:0
        for (int i = 0; i < 6; i++) {
            if (ipcs[i] == V4SP) {
                return validIPV4(ipcs);
            } else if (ipcs[i] == V6SP) {
                return validIPV6(ipcs);
            }
        }
        return NEITHER;
    }

    private String validIPV6(char[] ipcs) {
        // 1 * 8 + 7 || 4 * 8 + 7
        if (ipcs.length < 15 || ipcs.length > 39) {
            return NEITHER;
        }
        int spCnt = 0;
        for (int i = 0; i < ipcs.length; i++) {
            int start = i;
            // 找到一个.分割的范围
            while (i < ipcs.length) {
                if (ipcs[i] == V6SP) {
                    spCnt++;
                    break;
                }
                i++;
            }
            int end = i - 1;
            int size = end - start + 1;
            // 最多4位
            if (size > 4 || size < 1 || spCnt > 7) {
                return NEITHER;
            }
            for (int j = start; j <= end; j++) {
                if ((ipcs[j] >= '0' && ipcs[j] <= '9') ||
                        (ipcs[j] >= 'a' && ipcs[j] <= 'f') ||
                        (ipcs[j] >= 'A' && ipcs[j] <= 'F')) {
                    continue;
                } else {
                    return NEITHER;
                }
            }
        }
        return spCnt == 7 && ipcs[ipcs.length - 1] != V6SP ? IPV6 : NEITHER;
    }

    private String validIPV4(char[] ipcs) {
        // 255.255.255.255
        if (ipcs.length < 7 || ipcs.length > 15) {
            return NEITHER;
        }
        int spCnt = 0;
        for (int i = 0; i < ipcs.length; i++) {
            int start = i;
            // 找到一个.分割的范围
            while (i < ipcs.length) {
                if (ipcs[i] == V4SP) {
                    spCnt++;
                    break;
                }
                i++;
            }
            int end = i - 1;
            int size = end - start + 1;
            // 最多3个数字
            if (size > 3 || size < 1 || spCnt > 3 || !Character.isDigit(ipcs[start])) {
                return NEITHER;
            }
            // 不允许签到0
            if (ipcs[start] == '0' && size > 1) {
                return NEITHER;
            } else if (ipcs[start] == '0' && size == 1) {
                continue;
            }
            // 第一位范围是[0,2]
            if (ipcs[start] == '1') {
                // 2,3可以是[0,9]
                for (int j = start + 1; j <= end; j++) {
                    if (ipcs[j] > '9' || ipcs[j] < '0') {
                        return NEITHER;
                    }
                }
            } else if (ipcs[start] == '2') {
                // 2是[0,4]则3可以是[0,9];2是5则3是[0,5]
                if (size == 2) {
                    if (ipcs[end] > '9' || ipcs[end] < '0') {
                        return NEITHER;
                    }
                } else {
                    if (ipcs[start + 1] == '5') {
                        if (ipcs[end] > '5' || ipcs[end] < '0') {
                            return NEITHER;
                        }
                    } else if (ipcs[start + 1] >= '0' && ipcs[start + 1] < '5') {
                        if (ipcs[end] > '9' || ipcs[end] < '0') {
                            return NEITHER;
                        }
                    }
                }
            } else {
                return NEITHER;
            }
        }
        return spCnt == 3 && ipcs[ipcs.length - 1] != V4SP ? IPV4 : NEITHER;
    }
}
