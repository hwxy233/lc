package com.hwxy.leetcode.order.l2100.l2024;

/**
 * 2024. 考试的最大困扰度
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 * 
 * @author hwxy
 * @date 2022/04/04
 **/
public class Lc2024 {
    /**
     * 双指针
     *
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || answerKey.length() == 0) {
            return 0;
        }
        return Math.max(getCnt(answerKey, k, 'T'),
                getCnt(answerKey, k, 'F'));
    }

    /**
     * 找到替换k次t的长度
     *
     * @param answerKey
     * @param k
     * @param t
     * @return
     */
    private int getCnt(String answerKey, int k, char t) {
        int res = 0;
        // 记录使用的k的数量
        int sum = 0;
        // 双指针
        for (int left = 0, right = 0; right < answerKey.length(); right++) {
            // 只要右指针不是t就使用k
            if (answerKey.charAt(right) != t) {
                sum++;
            }
            // 缩小左指针知道用到k
            while (sum > k) {
                if (answerKey.charAt(left) != t) {
                    sum--;
                }
                left++;
            }
            // 计算长度
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
