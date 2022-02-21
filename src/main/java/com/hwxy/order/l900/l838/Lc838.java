package com.hwxy.order.l900.l838;

/**
 * 838. 推多米诺
 * https://leetcode-cn.com/problems/push-dominoes/
 * 
 * @author hwxy
 * @date 2022/02/21
 **/
public class Lc838 {
    public static void main(String[] args) {
        System.out.println(new Lc838().pushDominoes(".L.R...LR..L.."));
         System.out.println(new Lc838().pushDominoes("RL"));
    }

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            return dominoes;
        }
        char[] dcs = dominoes.toCharArray();
        // 增加一个额外的左指针不影响结果
        char left = 'L';
        int i = 0;
        while (i < dominoes.length()) {
            // 从i开始找
            int j = i;
            // 找到一段还没有倒的区间 j之后不为'.'
            while (j < dominoes.length() && dcs[j] == '.') {
                j++;
            }
            // 额外右指针不影响结果
            char right = j == dominoes.length() ? 'R' : dcs[j];
            // 看下2个方向,一侧就都导向同侧
            if (left == right) {
                while (i < j) {
                    dcs[i++] = right;
                }
            } else if (left == 'R' && right == 'L') {
                // 这种从2边导向中间, 如果left=L && right==R这样的是不会到的
                int l = i;
                int r = j - 1;
                while (l < r) {
                    dcs[l++] = left;
                    dcs[r--] = right;
                }
            }
            // 更新i和左指针,新的i不知道是不是'.'
            i = j + 1;
            left = right;
        }
        return new String(dcs);
    }
}
