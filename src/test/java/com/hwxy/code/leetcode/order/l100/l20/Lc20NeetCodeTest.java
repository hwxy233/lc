package com.hwxy.code.leetcode.order.l100.l20;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc20NeetCodeTest {

    @Test
    public void isValid() {
        Lc20 lc20 = new Lc20();
        assertTrue(lc20.isValid("()[]{}"));
        assertFalse(lc20.isValid("(]"));
        assertFalse(lc20.isValid("([)]"));
    }
}
