package com.hwxy.code.leetcode.order.l1000.l929;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * https://leetcode.cn/problems/unique-email-addresses/
 * 
 * @author hwxy
 * @date 2022/06/04
 **/
public class Lc929 {
    public static final char PT = '.';
    public static final char AT = '@';
    public static final char PL = '+';

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> emailTo = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            char[] ecs = email.toCharArray();
            boolean isDomain = false;
            for (int i = 0; i < ecs.length; i++) {
                if (isDomain) {
                    sb.append(ecs[i]);
                    continue;
                }
                if (ecs[i] == PT) {
                    continue;
                }
                if (ecs[i] == PL) {
                    while (ecs[i + 1] != AT) {
                        i++;
                    }
                } else {
                    if (ecs[i] == AT) {
                        isDomain = true;
                    }
                    sb.append(ecs[i]);
                }
            }
            emailTo.add(sb.toString());
        }
        return emailTo.size();
    }
}
