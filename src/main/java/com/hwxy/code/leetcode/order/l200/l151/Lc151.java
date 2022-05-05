package com.hwxy.code.leetcode.order.l200.l151;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc151 {
    public static void main(String[] args) {
        System.out.println(new Lc151().reverseWords("a good   example"));
    }

    /**
     * 快慢指针去空格
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
        // 翻转后单词间应当仅用一个空格分隔。
        // 翻转后的字符串中不应包含额外的空格。
        char space = ' ';
        char[] sa = s.toCharArray();
        // 1. 先去空格
        int slow = 0;
        int fast = 0;
        // 头部的空格
        while (fast < sa.length
                && sa[fast] == space) {
            fast++;
        }
        // 中间的空格
        for (; fast < sa.length; fast++) {
            // 连续的空格,第二个就跳过
            if (fast - 1 > 0 && sa[fast] == space
                    && sa[fast] == sa[fast - 1]) {
                // 这样好理解
                continue;
            } else {
                // 快慢指针赋值
                sa[slow++] = sa[fast];
            }
        }
        // 尾部的空格,在尾巴有连续2个空格时,上面执行后slow++后会指向第2个空格
        if (slow - 1 > 0 && sa[slow - 1] == space) {
            s = new String(sa, 0, slow - 1);
        } else {
            s = new String(sa, 0, slow);
        }
        // 2. 整体反转
        sa = s.toCharArray();
        swap(sa, 0, sa.length - 1);
        // 3. 按照空格切分后逐个反转
        // 记录是否进入了可以交换的区间
        boolean entry = false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < sa.length; i++) {
            // 没进入区间
            if (!entry ||
                    (sa[i - 1] == space)) {
                entry = true;
                start = i;
            }
            // 进入了并且达到了空格尾
            if (entry && sa[i] == space) {
                end = i - 1;
                swap(sa, start, end);
                entry = false;
            } else if (entry && i == sa.length - 1) {
                end = i;
                swap(sa, start, end);
                entry = false;
            }
        }
        return new String(sa);
    }

    private void swap(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
