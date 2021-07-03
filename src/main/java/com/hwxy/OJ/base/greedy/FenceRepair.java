package com.hwxy.OJ.base.greedy;

/**
 * POJ 3253
 * 木板合并
 *
 * @author hwxy
 * @date 2021/03/27
 **/
public class FenceRepair {

    public static void main(String[] args) {
        System.out.println(calCost(3, new int[]{8, 5, 8}));
    }

    public static int calCost(int n, int[] l) {
        int ans = 0;
        while (n > 1) {
            // 最小的
            int min1 = 0;
            // 倒数第2小的
            int min2 = 1;
            if (l[min1] > l[min2]) {
                swap(l, min1, min2);
            }
            for (int i = 2; i < n; i++) {
                if (l[i] < l[min1]) {
                    min2 = min1;
                    min1 = i;
                } else if (l[i] < l[min2]) {
                    min1 = min2;
                    min2 = i;
                }
            }
            // 合并版
            int t = l[min1] + l[min2];
            ans += t;

            if (min1 == n - 1) {
                swap(l, min1, min2);
            }
            l[min1] = t;
            l[min2] = l[n - 1];
            n--;
        }
        return ans;
    }

    private static void swap(int[] array, int a, int b) {
        int cache = array[a];
        array[a] = array[b];
        array[b] = cache;
    }
}
