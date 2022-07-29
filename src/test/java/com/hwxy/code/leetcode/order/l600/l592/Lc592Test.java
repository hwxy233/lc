package com.hwxy.code.leetcode.order.l600.l592;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc592Test {

    @Test
    public void fractionAddition() {
        Lc592 lc592 = new Lc592();
        assertEquals("0/1", lc592.fractionAddition("-1/2+1/2"));
        assertEquals("1/3", lc592.fractionAddition("-1/2+1/2+1/3"));
    }
}
