package com.hwxy.code.leetcode.order.l700.l667;

import org.junit.Test;

import java.util.Arrays;

public class Lc667Test {

    @Test
    public void constructArray() {
        Lc667 lc667 = new Lc667();
        System.out.println(Arrays.toString(lc667.constructArray(4, 1)));
        System.out.println(Arrays.toString(lc667.constructArray(4, 2)));
        System.out.println(Arrays.toString(lc667.constructArray(4, 3)));

        System.out.println(Arrays.toString(lc667.constructArray(3, 1)));
        System.out.println(Arrays.toString(lc667.constructArray(3, 2)));
    }
}
