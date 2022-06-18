package com.hwxy.code.leetcode.order.l1100.l1089;

/**
 * 1089. 复写零
 * https://leetcode.cn/problems/duplicate-zeros/
 * 
 * @author hwxy
 * @date 2022/06/17
 **/
public class Lc1089 {
    public static void main(String[] args) {}

    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                continue;
            }
            // [1,0,2,3,0,4,5,0]
            System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
            // 多加一次
            i++;
        }
    }
}
