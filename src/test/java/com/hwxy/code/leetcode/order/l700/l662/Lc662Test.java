package com.hwxy.code.leetcode.order.l700.l662;

import com.hwxy.code.ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc662Test {

    @Test
    public void widthOfBinaryTree() {
        Lc662 lc662 = new Lc662();
        assertEquals(
                4,
                lc662.widthOfBinaryTree(
                        new TreeNode(
                                1,
                                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                                new TreeNode(2, null, new TreeNode(9)))));
    }
}
