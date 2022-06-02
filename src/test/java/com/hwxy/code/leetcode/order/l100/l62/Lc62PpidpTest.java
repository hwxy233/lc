package com.hwxy.code.leetcode.order.l100.l62;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc62PpidpTest {

    @Test
    public void uniquePaths() {
        Lc62Ppidp lc62Ppidp = new Lc62Ppidp();
        assertEquals(28, lc62Ppidp.uniquePaths(3, 7));
        assertEquals(3, lc62Ppidp.uniquePaths(3, 2));
    }
}
