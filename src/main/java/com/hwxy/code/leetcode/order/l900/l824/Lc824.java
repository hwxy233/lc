package com.hwxy.code.leetcode.order.l900.l824;

/**
 * 824. 山羊拉丁文
 * https://leetcode-cn.com/problems/goat-latin/
 * 
 * @author hwxy
 * @date 2022/04/21
 **/
public class Lc824 {
    /**
     * 直接模拟
     * 
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        // 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
        // 例如，单词 "apple" 变为 "applema" 。
        // 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
        // 例如，单词 "goat" 变为 "oatgma" 。
        // 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
        // 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
        StringBuilder sb = new StringBuilder();
        char[] scs = sentence.toCharArray();
        int wordIndex = 1;
        for (int i = 0; i < scs.length; i++) {
            int start = i;
            while (i < scs.length && scs[i] != ' ') {
                i++;
            }
            int end = i - 1;
            // 注意大小写
            if (scs[start] == 'a' ||
                    scs[start] == 'e' ||
                    scs[start] == 'i' ||
                    scs[start] == 'o' ||
                    scs[start] == 'u' ||
                    scs[start] == 'A' ||
                    scs[start] == 'E' ||
                    scs[start] == 'I' ||
                    scs[start] == 'O' ||
                    scs[start] == 'U') {
                for (int j = start; j <= end; j++) {
                    sb.append(scs[j]);
                }
            } else {
                for (int j = start + 1; j <= end; j++) {
                    sb.append(scs[j]);
                }
                sb.append(scs[start]);
            }
            // 然后增加ma
            sb.append("m");
            sb.append("a".repeat(wordIndex + 1));
            // 拼上空格
            if (i != scs.length) {
                sb.append(" ");
            }
            wordIndex++;
        }
        return sb.toString();
    }
}
