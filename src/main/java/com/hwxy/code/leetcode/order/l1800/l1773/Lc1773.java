package com.hwxy.code.leetcode.order.l1800.l1773;

import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 *
 * @author hwxy
 * @date 2022/10/29
 **/
public class Lc1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items == null || items.isEmpty() || ruleKey == null || ruleValue == null) {
            return 0;
        }
        return (int) items.stream()
                .filter(item -> {
                    switch (ruleKey) {
                        case "type":
                            return ruleValue.equals(item.get(0));
                        case "color":
                            return ruleValue.equals(item.get(1));
                        case "name":
                            return ruleValue.equals(item.get(2));
                        default:
                            return false;
                    }
                })
                .count();
    }
}
