package com.hwxy.code.leetcode.order.l200.l125;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc125Test {

    @Test
    public void isPalindrome() {
        Lc125 lc125 = new Lc125();
        assertTrue(lc125.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(lc125.isPalindrome("race a car"));
        assertTrue(lc125.isPalindrome(".,"));
    }
}
