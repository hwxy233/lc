package com.hwxy.code.leetcode.order.l700.l676;

/**
 * 676. 实现一个魔法字典
 * https://leetcode.cn/problems/implement-magic-dictionary/
 * 
 * @author hwxy
 * @date 2022/07/11
 **/
public class Lc676 {}


class MagicDictionary {

    private TreeNode root;

    private static final char L_A = 'a';

    public MagicDictionary() {
        root = new TreeNode();
    }

    public void buildDict(String[] dictionary) {
        if (dictionary == null || dictionary.length == 0) {
            return;
        }
        for (String d : dictionary) {
            TreeNode cur = root;
            char[] dcs = d.toCharArray();
            for (char dc : dcs) {
                int index = dc - L_A;
                TreeNode child = cur.children[index];
                if (child == null) {
                    child = new TreeNode();
                    cur.children[index] = child;
                }
                cur = child;
            }
            cur.end = true;
        }
    }

    public boolean search(String searchWord) {
        if (searchWord == null || searchWord.isEmpty()) {
            return false;
        }
        char[] scs = searchWord.toCharArray();
        return dfs(scs, 0, root, false);
    }

    private boolean dfs(char[] scs, int index, TreeNode root, boolean modified) {
        if (index == scs.length) {
            // 必须要改一个字符
            return modified && root.end;
        }
        // 不改字符
        int childIndex = scs[index] - L_A;
        TreeNode child = root.children[childIndex];
        if (child != null) {
            if (dfs(scs, index + 1, child, modified)) {
                return true;
            }
        }
        // 改字符
        if (!modified) {
            for (int i = 0; i < 26; i++) {
                // 不适用当前的对应字符
                if (i != childIndex && root.children[i] != null) {
                    if (dfs(scs, index + 1, root.children[i], true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean end = false;
    }
}
