package com.hwxy.code.leetcode.order.l300.l242;

import com.hwxy.code.leetcode.order.l300.l242.Lc242NeetCode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc242NeetCodeTest {

    @Test
    public void isAnagram() {
        Lc242NeetCode lc242NeetCode = new Lc242NeetCode();
        assertTrue(lc242NeetCode.isAnagram("anagram", "nagaram"));
        assertFalse(lc242NeetCode.isAnagram("rat", "car"));
    }
}
