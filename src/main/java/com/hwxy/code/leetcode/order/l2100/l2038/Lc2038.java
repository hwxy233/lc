package com.hwxy.code.leetcode.order.l2100.l2038;

/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * 
 * @author hwxy
 * @date 2022/03/23
 **/
public class Lc2038 {
    /**
     * 找出中间的A和B的数量然后比较
     *
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {
        if (colors == null || colors.length() < 3) {
            return false;
        }
        int lengthA;
        int lengthB;
        char[] cc = colors.toCharArray();
        lengthA = calLength(cc, 'A');
        lengthB = calLength(cc, 'B');
        // 只有>才能赢
        return lengthA > lengthB;
    }

    private int calLength(char[] cc, char target) {
        int res = 0;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] != target) {
                continue;
            }
            // 找到开始位置然后找到最后位置
            int start = i;
            int end = i + 1;
            while (end < cc.length && cc[end] == target) {
                end++;
            }
            // 数量应该写成这样: (end-1) - start + 1
            int targetCnt = end - start;
            if (targetCnt > 2) {
                res += targetCnt - 2;
            }
            i = end;
        }
        return res;
    }
}
