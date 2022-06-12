package com.hwxy.code.leetcode.order.l900.l890;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.code.utils.JsonUtil;

public class Lc890Test {

    @Test
    public void findAndReplacePattern() {
        Lc890 lc890 = new Lc890();
        assertEquals(JsonUtil.convertToT("[\"mee\",\"aqq\"]", new TypeReference<List<String>>() {}),
                lc890.findAndReplacePattern(
                        JsonUtil.convertToT("[\"abc\",\"deq\",\"mee\",\"aqq\",\"dkd\",\"ccc\"]",
                                String[].class),
                        "abb"));
    }
}
