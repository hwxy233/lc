package com.hwxy.code.leetcode.order.l1700.l1656;

import java.util.LinkedList;
import java.util.List;

/**
 * 1656. 设计有序流 https://leetcode.cn/problems/design-an-ordered-stream/
 *
 * @author hwxy
 * @date 2022/08/16
 */
public class Lc1656 {}

class OrderedStream {
    private final String[] values;

    private int ptr;

    public OrderedStream(int n) {
        values = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        List<String> ans = new LinkedList<>();
        for (int i = ptr; i < values.length; i++) {
            if (values[i] == null) {
                break;
            }
            ans.add(values[i]);
            ptr = i + 1;
        }
        return ans;
    }
}
