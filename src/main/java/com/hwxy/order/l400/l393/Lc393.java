package com.hwxy.order.l400.l393;

/**
 * 393. UTF-8 编码验证
 * https://leetcode-cn.com/problems/utf-8-validation/
 * 
 * @author hwxy
 * @date 2022/03/13
 **/
public class Lc393 {
    private static final int NEXT_BYTE_MAX = Integer.parseInt("11000000", 2);
    private static final int NEXT_BYTE_MIN = Integer.parseInt("10000000", 2);

    public static final int[] BYTE_MAX_ARR =
            new int[] {
                    Integer.parseInt("10000000", 2),
                    Integer.parseInt("11100000", 2),
                    Integer.parseInt("11110000", 2),
                    Integer.parseInt("11111000", 2)
            };

    /**
     * & Char. number range | UTF-8 octet sequence
     * & (hexadecimal) | (binary)
     * & --------------------+---------------------------------------------
     * & 0000 0000-0000 007F | 0xxxxxxx
     * & 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     * & 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     * & 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Lc393().validUtf8(new int[] {197, 130, 1}));
        System.out.println(new Lc393().validUtf8(new int[] {235, 140, 4}));
    }

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        // 1. 判断每组的第一个数字的范围确定字节数n
        for (int i = 0; i < data.length; i++) {
            int first = data[i];
            if (first >= BYTE_MAX_ARR[BYTE_MAX_ARR.length - 1]) {
                return false;
            }
            for (int j = 0; j < BYTE_MAX_ARR.length; j++) {
                // 2. 对之后的n-1的数字是否都满足范围
                if (first < BYTE_MAX_ARR[j]) {
                    for (int k = 0; k < j; k++) {
                        if (++i >= data.length) {
                            return false;
                        }
                        if (data[i] >= NEXT_BYTE_MAX || data[i] < NEXT_BYTE_MIN) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }
}
