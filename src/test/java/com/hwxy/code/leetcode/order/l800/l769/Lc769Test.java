package com.hwxy.code.leetcode.order.l800.l769;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc769Test {

    @Test
    public void maxChunksToSorted() {
        Lc769 lc769 = new Lc769();
//        assertEquals(1, lc769.maxChunksToSorted(JsonUtil.convertToIntArray("[4,3,2,1,0]")));
        assertEquals(4, lc769.maxChunksToSorted(JsonUtil.convertToIntArray("[1,0,2,3,4]")));
        assertEquals(1, lc769.maxChunksToSorted(JsonUtil.convertToIntArray("[2,0,1]")));
    }
}