package com.hwxy.code.leetcode.order.l500.l427;

import com.hwxy.code.leetcode.order.l500.l427.Lc427;
import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

public class Lc427Test {

    @Test
    public void construct() {
        Lc427 lc427 = new Lc427();
        System.out.println(lc427.construct(JsonUtil.convertToT(
                "[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]",
                int[][].class)));
    }
}
