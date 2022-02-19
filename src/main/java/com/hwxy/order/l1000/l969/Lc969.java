package com.hwxy.order.l1000.l969;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 969. 煎饼排序
 * https://leetcode-cn.com/problems/pancake-sorting/
 * 
 * @author hwxy
 * @date 2022/02/19
 **/
public class Lc969 {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 4, 1};
        System.out.println(new Lc969().pancakeSort(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 每次将最大的翻转到最后
     * 
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new LinkedList<>();
        // 先找到未排序的最大值的下标index,先翻转[0,index]这样最大值在第一个位置
        // 然后翻转未排序部分(假设为n)[0,n],这样最大值就到了最后一个
        for (int n = arr.length; n > 0; n--) {
            int index = 0;
            for (int i = index + 1; i < n; i++) {
                if (arr[i] > arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            // 翻转[0, k-1]
            reverse(arr, index + 1);
            reverse(arr, n);
            // add(k)
            res.add(index + 1);
            res.add(n);
        }
        return res;
    }

    private void reverse(int[] arr, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
