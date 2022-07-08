package com.hwxy.code.leetcode.order.l700.l648;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc648Test {

    @Test
    public void replaceWords() {
        Lc648 lc648 = new Lc648();
        assertEquals("the cat was rat by the bat",
                lc648.replaceWords(JsonUtil.convertToT("[\"cat\",\"bat\",\"rat\"]"),
                        "the cattle was rattled by the battery"));
        assertEquals("a a b c",
                lc648.replaceWords(JsonUtil.convertToT("[\"a\",\"b\",\"c\"]"),
                        "aadsfasf absbs bbab cadsfafs"));
        assertEquals("a a a a a a a a bbb baba a",
                lc648.replaceWords(JsonUtil.convertToT("[\"a\", \"aa\", \"aaa\", \"aaaa\"]"),
                        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}
