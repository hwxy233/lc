package com.hwxy.code.leetcode.order.l1100.l1021;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc1021Test {

    @Test
    public void removeOuterParentheses() {
        Lc1021 lc1021 = new Lc1021();
        assertEquals("()()()", lc1021.removeOuterParentheses("(()())(())"));
        assertEquals("()()()()(())", lc1021.removeOuterParentheses("(()())(())(()(()))"));
        assertEquals("", lc1021.removeOuterParentheses("()()"));
    }
}
