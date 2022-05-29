package com.hwxy.code.leetcode.order.l6100.l6079;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc6079Test {

    @Test
    public void discountPrices() {
        Lc6079 lc6079 = new Lc6079();
        // System.out.println(20 / 100.00);
        assertEquals("there are $0.50 $1.00 and 5$ candies in the shop",
                lc6079.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        assertEquals("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$",
                lc6079.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        assertEquals("706hzu76jjh7yufr5x9ot60v149k5 $5509377493.92 pw2o $4.32",
                lc6079.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
        assertEquals(
                "7mozebb9smpwz$$yqr4mox3uae1a210prubb5zp1dykv$ffezb4jpfpcv5hldxnuob66bmu17g$aceym5vszi1$re1v4ttspua6b8yxtbfwnmyk8tudx1qj1ahxbseidrauclql3$ph$pj g5q61b01ho2k9c8fzdasxqvufyms66stvq2 $2558566593.89 ph3fw6mw $6422.70 t1 $6320996.19 $yrdnj9pek7yr1ccujc756i44qk5mr6h64zizbazgyx0k0$0 vmhb4r31ee2futqh76co5eff",
                lc6079.discountPrices(
                        "7mozebb9smpwz$$yqr4mox3uae1a210prubb5zp1dykv$ffezb4jpfpcv5hldxnuob66bmu17g$aceym5vszi1$re1v4ttspua6b8yxtbfwnmyk8tudx1qj1ahxbseidrauclql3$ph$pj g5q61b01ho2k9c8fzdasxqvufyms66stvq2 $3238691891 ph3fw6mw $8130 t1 $8001261 $yrdnj9pek7yr1ccujc756i44qk5mr6h64zizbazgyx0k0$0 vmhb4r31ee2futqh76co5eff",
                        21));
    }
}
