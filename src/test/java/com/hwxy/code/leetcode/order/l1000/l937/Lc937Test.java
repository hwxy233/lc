package com.hwxy.code.leetcode.order.l1000.l937;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc937Test {

    @Test
    public void reorderLogFiles() {
        Lc937 lc937 = new Lc937();
        assertArrayEquals(JsonUtil.convertToT(
                "[\"let1 art can\",\"let3 art zero\",\"let2 own kit dig\",\"dig1 8 1 5 1\",\"dig2 3 6\"]",
                String[].class),
                lc937.reorderLogFiles(JsonUtil.convertToT(
                        "[\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\",\"let2 own kit dig\",\"let3 art zero\"]",
                        String[].class)));
    }
}
