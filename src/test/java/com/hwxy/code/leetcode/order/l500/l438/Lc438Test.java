package com.hwxy.code.leetcode.order.l500.l438;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.code.utils.JsonUtil;

public class Lc438Test {

    @Test
    public void findAnagrams() {
        Lc438 lc438 = new Lc438();
        assertEquals(JsonUtil.convertToT("[19,20,21,22]", new TypeReference<>() {}),
                lc438.findAnagrams("dinitrophenylhydrazinetrinitrophenylmethylnitramine",
                        "trinitrophenylmethylnitramine"));
        assertEquals(JsonUtil.convertToT("[0,1,2]", new TypeReference<>() {}),
                lc438.findAnagrams("abab", "ab"));
    }
}
