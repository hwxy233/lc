package com.hwxy.code.leetcode.order.l1900.l1806;

/**
 * 1806. 还原排列的最少操作步数
 * https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/description/
 *
 * @author hwxy
 * @date 2023/01/09
 **/
public class Lc1806 {
    /**
     * 模拟
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        // 用2个数组可以避免不断new新的,只要交换指针就好
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = i;
        }
        boolean ar;
        int ans = 0;
        int hn = n / 2;
        do {
            ans++;
            ar = dc(arr, tmp, hn);
            int[] nar = arr;
            arr = tmp;
            tmp = nar;
        } while (!ar);

        return ans;
    }

    public boolean dc(int[] arr, int[] tmp, int hn) {
        // 只要有一个交换后!=i的就说明还没有交换到最后一步
        // 避免比较2个数组
        boolean ar = true;
        for (int i = 1; i < tmp.length - 1; i++) {
            if (i % 2 == 0) {
                arr[i] = tmp[i / 2];
            } else {
                arr[i] = tmp[hn + (i - 1) / 2];
            }
            if (arr[i] != i) {
                ar = false;
            }
        }
        return ar;
    }
}
