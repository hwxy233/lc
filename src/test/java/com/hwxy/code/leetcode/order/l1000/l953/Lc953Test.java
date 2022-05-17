package com.hwxy.code.leetcode.order.l1000.l953;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Lc953Test {

    @Test
    public void isAlienSorted() {
        Lc953 lc953 = new Lc953();
        assertTrue(lc953.isAlienSorted(new String[] {"hello", "leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(lc953.isAlienSorted(new String[] {"word", "world", "row"},
                "worldabcefghijkmnpqstuvxyz"));
        assertFalse(lc953.isAlienSorted(new String[] {"apple", "app"},
                "abcdefghijklmnopqrstuvwxyz"));
        assertTrue(lc953.isAlienSorted(new String[] {"kuvp", "q"},
                "ngxlkthsjuoqcpavbfdermiywz"));
        assertFalse(lc953.isAlienSorted(new String[] {"lrfxludcrzqkjehzx", "gbniscudqvnqvbnen"},
                "gqpsvlmbwktedinoauxjfcrzyh"));
    }
}
