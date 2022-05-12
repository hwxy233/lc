package com.hwxy.code.leetcode.order.l1000.l944;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc944Test {

    @Test
    public void minDeletionSize() {
        Lc944 lc944 = new Lc944();
        assertEquals(2, lc944.minDeletionSize(new String[] {"rrjk", "furt", "guzm"}));
        assertEquals(1, lc944.minDeletionSize(new String[] {"cba", "daf", "ghi"}));
        assertEquals(0, lc944.minDeletionSize(new String[] {"a", "b"}));
        assertEquals(3, lc944.minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
    }
}
