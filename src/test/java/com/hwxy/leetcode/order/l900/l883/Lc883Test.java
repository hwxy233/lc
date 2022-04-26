package com.hwxy.leetcode.order.l900.l883;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc883Test {

    @Test
    public void projectionArea() throws JsonProcessingException {
        Lc883 lc883 = new Lc883();
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(17,
                lc883.projectionArea(
                        objectMapper.readValue("[[1,2],[3,4]]", new TypeReference<>() {})));
        assertEquals(8,
                lc883.projectionArea(
                        objectMapper.readValue("[[1,0],[0,2]]", new TypeReference<>() {})));
        assertEquals(5,
                lc883.projectionArea(objectMapper.readValue("[[2]]", new TypeReference<>() {})));
    }
}
