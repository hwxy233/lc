package com.hwxy.code.leetcode.order.l800.l777;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc777Test {

    @Test
    public void canTransform() {
        Lc777 lc777 = new Lc777();
        assertTrue(lc777.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}