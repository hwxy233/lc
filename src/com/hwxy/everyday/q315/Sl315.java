package com.hwxy.everyday.q315;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sl315 {
    public static void main(String[] args) {
//        System.out.println(normal(new int[]{5, 2, 6, 1, 7}));
        System.out.println(insertSort(new int[]{7, 6, 5, 2, 1}));
    }

    /**
     * O(n*n)
     *
     * @param nums
     * @return
     */
    public static List<Integer> normal(int[] nums) {
        // bad args
        if (Objects.isNull(nums) || nums.length <= 0) {
            return Collections.emptyList();
        }
        int length = nums.length;
        List<Integer> countList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            Integer count = 0;
            int current = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (current > nums[j]) {
                    count++;
                }
            }
            countList.add(count);
        }
        return countList;
    }

    /**
     * 插入排序
     * 插入统计次数
     *
     * @param nums
     * @return
     */
    public static List<Integer> insertSort(int[] nums) {
        // bad args
        if (Objects.isNull(nums) || nums.length <= 0) {
            return Collections.emptyList();
        }
        LinkedList<Integer> countList = new LinkedList<>();
        countList.addLast(0);
        // 特殊处理2个的情况
        if (nums.length == 2) {
            int count = nums[0] > nums[1] ? 1 : 0;
            countList.addFirst(count);
            return countList;
        }
        // 对长度>=3进行插入排序,结果是(小 -> 大)
        for (int i = nums.length - 2; i >= 0; i--) {
            // 每次大的会向后移动所以移动次数反映了大于右侧数字的个数
            int count = 0;
            // 每次比较的是当前和右侧的位置
            for (int j = i; j < nums.length - 1; j++) {
                // 大的向右移
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count++;
                }
            }
            // 放到第一个
            countList.addFirst(count);
        }
        return countList;
    }
}
