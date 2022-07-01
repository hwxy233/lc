package com.hwxy.code.leetcode.order.l1200.l1175;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc1175Test {

    @Test
    public void numPrimeArrangements() {
        Lc1175 lc1175 = new Lc1175();
        assertEquals(12, lc1175.numPrimeArrangements(5));
        assertEquals(36, lc1175.numPrimeArrangements(6));
        assertEquals(2880, lc1175.numPrimeArrangements(9));
        assertEquals(682289015, lc1175.numPrimeArrangements(100));
    }
}
