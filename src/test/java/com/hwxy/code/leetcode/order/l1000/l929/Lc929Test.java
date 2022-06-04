package com.hwxy.code.leetcode.order.l1000.l929;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc929Test {

    @Test
    public void numUniqueEmails() {
        Lc929 lc929 = new Lc929();
        assertEquals(1, lc929.numUniqueEmails(
                new String[] {"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
        assertEquals(2, lc929.numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        assertEquals(3, lc929.numUniqueEmails(
                new String[] {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }
}
