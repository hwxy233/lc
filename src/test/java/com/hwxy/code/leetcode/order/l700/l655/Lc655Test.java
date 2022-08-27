package com.hwxy.code.leetcode.order.l700.l655;

import com.hwxy.code.ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc655Test {

    @Test
    public void printTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Lc655 lc655 = new Lc655();
        System.out.println(lc655.printTree(root));
    }
}