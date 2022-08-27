package com.hwxy.code.leetcode.order.l1500.l1455;

import java.util.ArrayList;
import java.util.List;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * @author hwxy
 * @date 2022/08/21
 **/
public class Lc1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null
                || sentence.isEmpty()
                || searchWord == null
                || searchWord.isEmpty()
                || sentence.length() < searchWord.length()) {
            return -1;
        }
        String[] sen = sentence.split(" ");
        TreeNode root = new TreeNode();
        for (int i = 0; i < sen.length; i++) {
            String s = sen[i];
            char[] scs = s.toCharArray();
            TreeNode node = root;
            for (char sc : scs) {
                TreeNode child = node.children[sc-L_A];
                if (child == null) {
                    child = new TreeNode();
                    node.children[sc-L_A] = child;
                }
                child.indexes.add(i);
                node = child;
            }
            node.end = true;
        }
        TreeNode node = root;
        char[] swcs = searchWord.toCharArray();
        for (int i = 0; i < swcs.length;i++) {
            char c = swcs[i];
            TreeNode child = node.children[c - L_A];
            if (child == null) {
                return -1;
            }
            if (i == searchWord.length()-1) {
                return child.indexes.get(0)+1;
            }
            node = child;
        }
        return -1;
    }

    public static final char L_A = 'a';

    static class TreeNode {
        TreeNode[] children = new TreeNode[26];
        List<Integer> indexes = new ArrayList<>();
        boolean end;
    }
}
