package com.hwxy.leetcode.order.l100.l49;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.utils.JsonUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Lc49Test {

    @Test
    public void groupAnagrams() {
        Lc49 lc49 = new Lc49();
        assertEquals(
                JsonUtil.convertToT("[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]",
                        new TypeReference<List<List<String>>>() {}),
                lc49.groupAnagrams(JsonUtil.convertToT(
                        "[\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]", String[].class)));
    }
}
