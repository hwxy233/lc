package com.hwxy.code.leetcode.order.l1000.l926;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc926Test {

    @Test
    public void minFlipsMonoIncr() {
        Lc926 lc926 = new Lc926();
//        assertEquals(1, lc926.minFlipsMonoIncr("00110"));
        assertEquals(2, lc926.minFlipsMonoIncr("00011000"));
    }
}
