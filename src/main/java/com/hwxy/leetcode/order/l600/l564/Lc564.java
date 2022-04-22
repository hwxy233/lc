package com.hwxy.leetcode.order.l600.l564;

import java.util.ArrayList;
import java.util.List;

/**
 * 564. 寻找最近的回文数
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/
 * 
 * @author hwxy
 * @date 2022/03/02
 **/
public class Lc564 {
    public static void main(String[] args) {
        // System.out.println(new Lc564().nearestPalindromic("99321"));
        // System.out.println(new Lc564().nearestPalindromic("1"));
        System.out.println(new Lc564().nearestPalindromic("1213"));

    }

    public String nearestPalindromic(String n) {
        if (n == null || n.length() == 0) {
            return n;
        }
        // 生成前一半-1到前一半+1的回文数,以及10的(len-1)次方-1,10的len次方+1
        List<Long> prs = createPrs(n);
        long self = Long.parseLong(n);
        long min = self;
        long cost = 0;
        for (long pr : prs) {
            // 自己
            if (pr == self) {
                continue;
            }
            // 第一次
            if (cost == 0) {
                cost = Math.abs(self - pr);
                min = pr;
                continue;
            }
            long newCost = Math.abs(self - pr);
            // 小于则更新
            if (newCost < cost) {
                cost = newCost;
                min = pr;
            } else if (newCost == cost) {
                // 相等取小的
                min = Math.min(min, pr);
            }
        }
        return min + "";
    }

    private List<Long> createPrs(String n) {
        List<Long> res = new ArrayList<>();
        int length = n.length();
        res.add((long) Math.pow(10, length - 1) - 1);
        res.add((long) Math.pow(10, length) + 1);
        // length & 1 偶数则裁剪一半
        String prefix = n.substring(0, length / 2 + (length & 1));
        long prefixL = Long.parseLong(prefix);
        for (long i = prefixL - 1; i <= prefixL + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            // 要整个复制
            if (length % 2 == 0) {
                sb.append(new StringBuilder(sb).reverse());
            } else {
                sb.append(new StringBuilder(sb).reverse().substring(1, sb.length()));
            }
            res.add(Long.parseLong(sb.toString()));
        }
        return res;
    }
}
