package com.hwxy.code.leetcode.order.l700.l670;

/**
 * 670. 最大交换
 * https://leetcode.cn/problems/maximum-swap/
 *
 * @author hwxy
 * @date 2022/09/13
 */
public class Lc670 {
    public int maximumSwap(int num) {
        if (num <= 0) {
            return num;
        }
        char[] numCs = String.valueOf(num).toCharArray();
        // 贪心,每个数字不应该<后面的数字,否则与最后面最大的交换
        for (int i = 0; i < numCs.length; i++) {
            boolean swapped = false;
            for (int j = i + 1; j < numCs.length; j++) {
                if (numCs[i] >= numCs[j]) {
                    continue;
                }
                // 找最后面的最大
                int maxIndex = j;
                char max = numCs[j];
                for (int k = j + 1; k < numCs.length; k++) {
                    if (numCs[k] >= max) {
                        max = numCs[k];
                        maxIndex = k;
                    }
                }
                char tmp = numCs[i];
                numCs[i] = numCs[maxIndex];
                numCs[maxIndex] = tmp;
                swapped = true;
                break;
            }
            if (swapped) {
                break;
            }
        }
        return Integer.parseInt(new String(numCs));
    }
}
