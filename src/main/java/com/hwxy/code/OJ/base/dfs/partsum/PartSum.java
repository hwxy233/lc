package com.hwxy.code.OJ.base.dfs.partsum;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/03/20
 **/
public class PartSum {

    public static void main(String[] args) {
        PartSum partSum = new PartSum();
        System.out.println(partSum.checkPartSum(4, new int[]{1, 2, 4, 7}, 13));
    }

    /**
     * 这次的数组
     */
    private int[] array;
    /**
     * 数组的元素数量
     */
    private int n;
    /**
     * 目标的值
     */
    private int target;

    /**
     * 检查是否有部分和
     *
     * @param n
     * @param array
     * @param target
     * @return
     */
    public boolean checkPartSum(int n, int[] array, int target) {
        this.array = array;
        this.n = n;
        this.target = target;
        return partSum(0, 0);
    }

    /**
     * 这次要计算的数组的位置
     *
     * @param i
     * @param sum
     * @return
     */
    boolean partSum(int i, int sum) {
        // 说明数组遍历完了,要检查目标的值
        if (i == n) {
            return sum == target;
        }
        // 如果不加当前的数组的位置
        if (partSum(i + 1, sum)) {
            return true;
        }
        // 如果加了
        return partSum(i + 1, sum + array[i]);
    }
}
