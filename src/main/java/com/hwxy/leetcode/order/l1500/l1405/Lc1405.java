package com.hwxy.leetcode.order.l1500.l1405;

import java.util.Arrays;

/**
 * 1405. 最长快乐字符串
 * https://leetcode-cn.com/problems/longest-happy-string/submissions/
 * 
 * @author hwxy
 * @date 2022/02/07
 **/
public class Lc1405 {

    public static void main(String[] args) {
        System.out.println(new Lc1405().longestDiverseString(1, 1, 7));
    }

    public static final char A = 'a';
    public static final char B = 'b';
    public static final char C = 'c';

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();
        Cnt[] cnts = new Cnt[3];
        cnts[0] = new Cnt(A, a);
        cnts[1] = new Cnt(B, b);
        cnts[2] = new Cnt(C, c);
        while (true) {
            // 贪心,每次都排序取最大的
            Arrays.sort(cnts, (o1, o2) -> -Integer.compare(o1.cnt, o2.cnt));
            boolean hasNext = false;
            for (Cnt cnt : cnts) {
                if (cnt.cnt <= 0) {
                    break;
                }
                if (s.length() >= 2
                        && s.charAt(s.length() - 1) == s.charAt(s.length() - 2)
                        && s.charAt(s.length() - 1) == cnt.word) {
                    continue;
                }
                s.append(cnt.word);
                cnt.cnt--;
                hasNext = true;
                // 这里要break重新排序
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return s.toString();
    }

    static class Cnt {
        char word;
        int cnt;

        Cnt(char word, int cnt) {
            this.cnt = cnt;
            this.word = word;
        }
    }
}
