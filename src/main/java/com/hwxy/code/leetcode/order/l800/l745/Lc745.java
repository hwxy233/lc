package com.hwxy.code.leetcode.order.l800.l745;

import java.util.*;

import com.hwxy.code.utils.JsonUtil;

/**
 * 745. 前缀和后缀搜索
 * https://leetcode.cn/problems/prefix-and-suffix-search/
 * 
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc745 {

    public static void main(String[] args) {
        WordFilter wordFilter =
                new WordFilter(JsonUtil.convertToT("[\"apple\",\"pple\",\"ple\"]", String[].class));
        System.out.println(wordFilter.f("a", "e"));
        System.out.println(wordFilter.f("p", "e"));
    }
}


class WordFilter {
    public static final char L_A = 'a';
    private final TreeNode first;
    private final TreeNode last;

    /**
     * 使用2个字典树,一个正着存,一个倒着存
     * 并且分别存储index最后求交集
     * 求交集可以倒着查正着存的只要有就是最大的index
     * 
     * @param words
     */
    public WordFilter(String[] words) {
        first = new TreeNode(true);
        last = new TreeNode(false);
        buildTrees(words);
    }

    private void buildTrees(String[] words) {
        for (int i = 0; i < words.length; i++) {
            TreeNode curFirst = first;
            char[] wordChars = words[i].toCharArray();
            for (char wordChar : wordChars) {
                TreeNode firstChild = curFirst.children[wordChar - L_A];
                if (firstChild == null) {
                    firstChild = new TreeNode(true);
                    curFirst.children[wordChar - L_A] = firstChild;
                }
                firstChild.indexes.add(i);
                curFirst = firstChild;
            }
            TreeNode curLast = last;
            for (int j = wordChars.length - 1; j >= 0; j--) {
                TreeNode lastChild = curLast.children[wordChars[j] - L_A];
                if (lastChild == null) {
                    lastChild = new TreeNode(false);
                    curLast.children[wordChars[j] - L_A] = lastChild;
                }
                lastChild.indexSet.add(i);
                curLast = lastChild;
            }
        }
    }


    public int f(String pref, String suff) {
        if (pref == null || suff == null || pref.isEmpty() || suff.isEmpty()) {
            return -1;
        }
        List<Integer> firstIndexes = searchFirst(pref);
        if (firstIndexes.isEmpty()) {
            return -1;
        }
        Set<Integer> lastIndexes = searchLast(suff);
        // 求2个集合的交集的最大值
        if (lastIndexes.isEmpty()) {
            return -1;
        }
        // 倒着找第一个,然后看是否在第二个中
        for (int i = firstIndexes.size() - 1; i >= 0; i--) {
            int firstIndex = firstIndexes.get(i);
            if (lastIndexes.contains(firstIndex)) {
                return firstIndex;
            }
        }
        return -1;
    }

    private Set<Integer> searchLast(String suff) {
        char[] perfChars = suff.toCharArray();
        TreeNode curLast = last;
        for (int i = perfChars.length - 1; i >= 0; i--) {
            TreeNode child = curLast.children[perfChars[i] - L_A];
            if (child == null) {
                return Collections.emptySet();
            }
            curLast = child;
        }
        return curLast.indexSet;
    }

    private List<Integer> searchFirst(String pref) {
        char[] perfChars = pref.toCharArray();
        TreeNode curFirst = first;
        for (char perfChar : perfChars) {
            TreeNode child = curFirst.children[perfChar - L_A];
            if (child == null) {
                return Collections.emptyList();
            }
            curFirst = child;
        }
        return curFirst.indexes;
    }

    class TreeNode {
        TreeNode[] children;
        List<Integer> indexes;

        Set<Integer> indexSet;

        TreeNode(boolean useList) {
            children = new TreeNode[26];
            if (useList) {
                indexes = new ArrayList<>();
            } else {
                indexSet = new HashSet<>();
            }
        }

    }
}
