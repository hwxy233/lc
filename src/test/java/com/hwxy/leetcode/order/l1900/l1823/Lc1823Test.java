package com.hwxy.leetcode.order.l1900.l1823;

import com.hwxy.leetcode.order.l100.l1.Lc1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1823Test {

    @Test
    public void findTheWinner() {
        Lc1823 lc1823 = new Lc1823();
        assertEquals(3, lc1823.findTheWinner(5, 2));
        assertEquals(1, lc1823.findTheWinner(6, 5));
    }
}
