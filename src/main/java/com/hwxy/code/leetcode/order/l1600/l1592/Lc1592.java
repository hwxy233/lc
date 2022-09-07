package com.hwxy.code.leetcode.order.l1600.l1592;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 *
 * <p>https://leetcode.cn/problems/rearrange-spaces-between-words/
 *
 * @author hwxy
 * @date 2022/09/07
 */
public class Lc1592 {
    public static final char SPACE = ' ';

    public String reorderSpaces(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        List<String> normalList = new ArrayList<>();
        List<Character> spaceList = new ArrayList<>();
        int right = 0;
        char[] textCs = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (right < textCs.length) {
            if (textCs[right] == SPACE) {
                spaceList.add(SPACE);
                if (sb.length() > 0) {
                    normalList.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(textCs[right]);
            }
            right++;
        }
        if (sb.length() > 0) {
            normalList.add(sb.toString());
        }
        StringBuilder ans = new StringBuilder();
        int eachSpaceCount =
                normalList.size() - 1 == 0 ? 0 : spaceList.size() / (normalList.size() - 1);
        int spaceIndex = 0;
        for (int i = 0; i < normalList.size(); i++) {
            ans.append(normalList.get(i));
            for (int j = 0; spaceIndex < spaceList.size() && j < eachSpaceCount; j++) {
                ans.append(spaceList.get(spaceIndex++));
            }
        }
        for (int i = spaceIndex; i < spaceList.size(); i++) {
            ans.append(spaceList.get(spaceIndex));
        }
        return ans.toString();
    }
}
