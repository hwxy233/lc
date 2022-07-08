package com.hwxy.code.leetcode.order.l700.l648;

import java.util.List;

/**
 * 648. 单词替换
 * https://leetcode.cn/problems/replace-words/
 *
 * @author hwxy
 * @date 2022/07/07
 **/
public class Lc648 {
    public static final char L_A = 'a';

    public static final String EMPTY = "";

    public static final String SPACE = " ";

    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.isEmpty() || sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        TreeNode root = buildTires(dictionary);
        String[] sentences = sentence.split(SPACE);
        StringBuilder sb = new StringBuilder();
        for (String s : sentences) {
            String searchResult = search(s, root);
            if (!searchResult.isEmpty()) {
                sb.append(searchResult);
            } else {
                sb.append(s);
            }
            sb.append(SPACE);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String search(String s, TreeNode root) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            TreeNode child = root.children[c - L_A];
            if (child == null) {
                break;
            }
            sb.append(c);
            root = child;
            if (child.end) {
                break;
            }
        }
        return root.end ? sb.toString() : EMPTY;
    }

    private TreeNode buildTires(List<String> dictionary) {
        TreeNode treeNode = new TreeNode();
        for (String dict : dictionary) {
            TreeNode cur = treeNode;
            char[] dcs = dict.toCharArray();
            for (char dc : dcs) {
                TreeNode child = cur.children[dc - L_A];
                if (child == null) {
                    child = new TreeNode();
                    cur.children[dc - L_A] = child;
                }
                cur = child;
            }
            cur.end = true;
        }
        return treeNode;
    }

    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean end;
    }
}
