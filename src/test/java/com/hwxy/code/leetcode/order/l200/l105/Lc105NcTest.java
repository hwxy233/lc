package com.hwxy.code.leetcode.order.l200.l105;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc105NcTest {

    @Test
    public void buildTree() {
        Lc105Nc lc105Nc = new Lc105Nc();
        System.out.println(lc105Nc.buildTree(JsonUtil.convertToT("[3,9,20,15,7]", int[].class),
                JsonUtil.convertToT("[9,3,15,20,7]", int[].class)));
    }
}
