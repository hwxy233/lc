package com.hwxy.leetcode.order.l500.l417;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Lc417Test {

    @Test
    public void pacificAtlantic() throws JsonProcessingException {
        Lc417 lc417 = new Lc417();
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(objectMapper.readValue("[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]",
                new TypeReference<List<List<Integer>>>() {}),
                lc417.pacificAtlantic(objectMapper.readValue(
                        "[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]",
                        new TypeReference<>() {})));

    }
}
