package com.hwxy.code.leetcode.order.l600.l522;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc522Test {

    @Test
    public void findLUSlength() {
        Lc522 lc522 = new Lc522();
        assertEquals(3, lc522
                .findLUSlength(JsonUtil.convertToT("[\"aba\",\"cdc\",\"eae\"]", String[].class)));
        assertEquals(-1, lc522
                .findLUSlength(JsonUtil.convertToT("[\"aaa\",\"aaa\",\"aa\"]", String[].class)));
    }
}
