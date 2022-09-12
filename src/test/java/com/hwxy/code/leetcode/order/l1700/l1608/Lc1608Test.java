package com.hwxy.code.leetcode.order.l1700.l1608;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc1608Test {

    @Test
    public void specialArray() {
        Lc1608 lc1608 = new Lc1608();
        assertEquals(2, lc1608.specialArray(JsonUtil.convertToIntArray("[3,5]")));
        assertEquals(-1, lc1608.specialArray(JsonUtil.convertToIntArray("[0,0]")));
        assertEquals(-1, lc1608.specialArray(JsonUtil.convertToIntArray("[0,0]")));
        assertEquals(3, lc1608.specialArray(JsonUtil.convertToIntArray("[0,4,3,0,4]")));
        assertEquals(-1, lc1608.specialArray(JsonUtil.convertToIntArray("[3,6,7,7,0]")));
    }
}
