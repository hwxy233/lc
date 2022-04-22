package com.hwxy.leetcode.OJ.sort.mergesort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 归并排序
 *
 * @author hwxy
 * @date 2021/03/07
 **/
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> un = IntStream.range(55, 95).boxed().collect(Collectors.toList());
        Collections.shuffle(un);
        System.out.println(un);
        System.out.println(Arrays.toString(mergeSort.mergeSort(un.stream().mapToInt(Integer::valueOf).toArray())));
    }

    /**
     * 2次递归
     * 1次合并
     *
     * @param unsortedArray
     * @return
     */
    public int[] mergeSort(int[] unsortedArray) {
        if (Objects.isNull(unsortedArray) || unsortedArray.length < 2) {
            return unsortedArray;
        }
        return doMergeSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    /**
     * 每次将数组对半分直到1个的时候
     * 另一侧也是1个
     * 这时就将2边合并成1个
     * 类似的月合并月完整
     *
     * @param unsortedArray
     * @param start
     * @param end
     * @return
     */
    private int[] doMergeSort(int[] unsortedArray, int start, int end) {
        if (start >= end) {
            return new int[]{unsortedArray[start]};
        }
        int middle = (start + end) / 2;
        int[] leftSorted = doMergeSort(unsortedArray, start, middle);
        int[] rightSorted = doMergeSort(unsortedArray, middle + 1, end);
        return merge(leftSorted, rightSorted);
    }

    /**
     * 合并
     * 有那种一边没了一边还有的情况
     *
     * @param leftSorted
     * @param rightSorted
     * @return
     */
    private int[] merge(int[] leftSorted, int[] rightSorted) {
        int leftSize = leftSorted.length;
        int rightSize = rightSorted.length;
        int leftStart = 0;
        int rightStart = 0;
        int[] result = new int[leftSize + rightSize];
        int index = 0;
        while (leftStart < leftSize && rightStart < rightSize) {
            if (leftSorted[leftStart] > rightSorted[rightStart]) {
                result[index++] = rightSorted[rightStart++];
            } else {
                result[index++] = leftSorted[leftStart++];
            }
        }
        while (leftStart < leftSize) {
            result[index++] = leftSorted[leftStart++];
        }
        while (rightStart < rightSize) {
            result[index++] = rightSorted[rightStart++];
        }
        return result;
    }
}
