package com.hwxy.code.leetcode.sfo.sfo2.sfo115;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Sfo115Test {

    @Test
    public void sequenceReconstruction() {
        Sfo115 sfo115 = new Sfo115();
        assertFalse(sfo115.sequenceReconstruction(JsonUtil.convertToIntArray("[1,2,3]"),
                JsonUtil.convertTo2DIntArray("[[1,2],[1,3]]")));
        assertTrue(sfo115.sequenceReconstruction(JsonUtil.convertToIntArray("[1,2,3]"),
                JsonUtil.convertTo2DIntArray("[[1,2],[1,3],[2,3]]")));
    }
}
