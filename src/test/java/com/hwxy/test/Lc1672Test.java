package com.hwxy.test;

import com.hwxy.leetcode.order.l1700.l1672.Lc1672;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1672Test {
    @Test
    public void test() {
        Lc1672 lc1672 = new Lc1672();
        assertEquals(6, lc1672.maximumWealth(new int[][] {{1, 2, 3}, {3, 2, 1}}));
        assertEquals(10, lc1672.maximumWealth(new int[][] {{1, 5}, {7, 3}, {3, 5}}));
    }

}
