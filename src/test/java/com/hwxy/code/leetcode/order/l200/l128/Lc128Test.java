package com.hwxy.code.leetcode.order.l200.l128;

import com.hwxy.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc128Test {

    @Test
    public void longestConsecutive() {
        Lc128 lc128 = new Lc128();
        assertEquals(4,
                lc128.longestConsecutive(JsonUtil.convertToT("[100,4,200,1,3,2]", int[].class)));
        assertEquals(3,
                lc128.longestConsecutive(JsonUtil.convertToT("[1,2,0,1]", int[].class)));
        assertEquals(9,
                lc128.longestConsecutive(
                        JsonUtil.convertToT("[0,3,7,2,5,8,4,6,0,1]", int[].class)));
    }
}
