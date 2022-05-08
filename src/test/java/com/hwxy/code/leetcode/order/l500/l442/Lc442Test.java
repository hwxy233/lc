package com.hwxy.code.leetcode.order.l500.l442;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Lc442Test {

    @Test
    public void findDuplicates() {
        Lc442 lc442 = new Lc442();
        assertEquals(JsonUtil.convertToT("[2,3]", new TypeReference<List<Integer>>() {}),
                lc442.findDuplicates(
                        JsonUtil.convertToT("[4,3,2,7,8,2,3,1]", new TypeReference<>() {})));
        assertEquals(JsonUtil.convertToT("[1]", new TypeReference<List<Integer>>() {}),
                lc442.findDuplicates(
                        JsonUtil.convertToT("[1,1]", new TypeReference<>() {})));
        assertEquals(JsonUtil.convertToT("[]", new TypeReference<List<Integer>>() {}),
                lc442.findDuplicates(
                        JsonUtil.convertToT("[1]", new TypeReference<>() {})));
    }
}
