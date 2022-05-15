package com.hwxy.code.leetcode.order.l5300.l5234;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.code.utils.JsonUtil;

public class Lc5234Test {

    @Test
    public void removeAnagrams() {
        Lc5234 lc5234 = new Lc5234();
        assertEquals(JsonUtil.convertToT("[\"abba\",\"cd\"]", new TypeReference<List<String>>() {}),
                lc5234.removeAnagrams(
                        JsonUtil.convertToT("[\"abba\",\"baba\",\"bbaa\",\"cd\",\"cd\"]",
                                String[].class)));
        assertEquals(
                JsonUtil.convertToT("[\"a\",\"b\",\"c\",\"d\",\"e\"]",
                        new TypeReference<List<String>>() {}),
                lc5234.removeAnagrams(
                        JsonUtil.convertToT("[\"a\",\"b\",\"c\",\"d\",\"e\"]",
                                String[].class)));
    }
}
