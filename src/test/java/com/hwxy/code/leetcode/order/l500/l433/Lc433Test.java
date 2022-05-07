package com.hwxy.code.leetcode.order.l500.l433;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc433Test {

    @Test
    public void minMutation() {
        Lc433 lc433 = new Lc433();
        assertEquals(2, lc433.minMutation("AACCGGTT", "AACCGCTA",
                JsonUtil.convertToT("[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]", String[].class)));
        assertEquals(3, lc433.minMutation("AAAAACCC", "AACCCCCC",
                JsonUtil.convertToT("[\"AAAACCCC\",\"AAACCCCC\",\"AACCCCCC\"]", String[].class)));
        assertEquals(2, lc433.minMutation("AACCGGTT", "AAACGGTA",
                JsonUtil.convertToT("[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]", String[].class)));
    }
}
