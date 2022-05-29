package com.hwxy.code.leetcode.order.l500.l468;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc468Test {

    @Test
    public void validIPAddress() {
        Lc468 lc468 = new Lc468();
        // assertEquals("IPv4", lc468.validIPAddress("172.16.254.1"));
        // assertEquals("IPv4", lc468.validIPAddress("172.16.254.1"));
        // assertEquals("IPv4", lc468.validIPAddress("0.0.0.0"));
        // assertEquals("IPv6", lc468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        // assertEquals("IPv6", lc468.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        // assertEquals("IPv6", lc468.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("IPv6", lc468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        // assertEquals("Neither", lc468.validIPAddress("256.256.256.256"));
        // assertEquals("Neither", lc468.validIPAddress("0.0.0.0."));
        // assertEquals("Neither", lc468.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
        // assertEquals("Neither",
        // lc468.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        // assertEquals("Neither", lc468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
