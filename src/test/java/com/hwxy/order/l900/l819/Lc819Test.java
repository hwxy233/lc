package com.hwxy.order.l900.l819;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc819Test {

    @Test
    public void mostCommonWord() {
        Lc819 lc819 = new Lc819();
        assertEquals("bob", lc819.mostCommonWord(
                "Bob", new String[] {""}));
        assertEquals("ball", lc819.mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }
}
