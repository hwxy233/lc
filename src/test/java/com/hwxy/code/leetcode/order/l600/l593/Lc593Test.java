package com.hwxy.code.leetcode.order.l600.l593;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc593Test {

    @Test
    public void validSquare() {
        Lc593 lc593 = new Lc593();
        assertTrue(lc593.validSquare(
                JsonUtil.convertToIntArray("[1,0]"),
                JsonUtil.convertToIntArray("[-1,0]"),
                JsonUtil.convertToIntArray("[0,1]"),
                JsonUtil.convertToIntArray("[0,-1]")
        ));
    }
}