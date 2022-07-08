package com.hwxy.code.leetcode.order.l300.l208;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 
 * @author hwxy
 * @date 2022/07/04
 **/
public class Lc208 {

}


class Trie {

    private TreeNode root;

    public static final char L_A = 'a';

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char[] wordChars = word.toCharArray();
        TreeNode p = root;
        for (char wordChar : wordChars) {
            TreeNode child = getChild(p, wordChar);
            if (child == null) {
                child = new TreeNode();
                p.children[getCharIndex(wordChar)] = child;
            }
            p = child;
        }
        p.end = true;
    }

    private int getCharIndex(char c) {
        return c - L_A;
    }

    private TreeNode getChild(TreeNode parent, char c) {
        int childIndex = getCharIndex(c);
        return parent.children[childIndex];
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TreeNode p = root;
        char[] wordChars = word.toCharArray();
        for (char wordChar : wordChars) {
            TreeNode child = getChild(p, wordChar);
            if (child == null) {
                return false;
            }
            p = child;
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        TreeNode p = root;
        char[] wordChars = prefix.toCharArray();
        for (char wordChar : wordChars) {
            TreeNode child = getChild(p, wordChar);
            if (child == null) {
                return false;
            }
            p = child;
        }
        return true;
    }
}


class TreeNode {
    boolean end = false;

    /**
     * a-z
     */
    TreeNode[] children = new TreeNode[26];
}
