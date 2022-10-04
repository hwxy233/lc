package com.hwxy.code.leetcode.order.l1700.l1694;

/**
 * 1694. 重新格式化电话号码
 * https://leetcode.cn/problems/reformat-phone-number/
 *
 * @author hwxy
 * @date 2022/10/01
 **/
public class Lc1694 {
    public String reformatNumber(String number) {
        if (number == null || number.length() < 4) {
            return number;
        }
        number = number.replaceAll(" ", "");
        number = number.replaceAll("-", "");
        StringBuilder ans = new StringBuilder();
        char[] ncs = number.toCharArray();
        for (int i = 0; i < ncs.length; ) {
            int leftLen = ncs.length - 1 - i + 1;
            if (leftLen <= 4) {
                if (leftLen < 4) {
                    while (i < ncs.length) {
                        ans.append(ncs[i++]);
                    }
                } else {
                    ans.append(ncs[i++])
                            .append(ncs[i++])
                            .append("-")
                            .append(ncs[i++])
                            .append(ncs[i]);
                }
                break;
            }
            for (int j = 0; j < 3; j++) {
                ans.append(ncs[i++]);
            }
            ans.append("-");
        }
        return ans.toString();
    }
}
