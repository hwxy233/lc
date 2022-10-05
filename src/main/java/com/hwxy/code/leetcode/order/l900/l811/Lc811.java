package com.hwxy.code.leetcode.order.l900.l811;

import java.util.*;

/**
 * 811. 子域名访问计数
 * https://leetcode.cn/problems/subdomain-visit-count/
 *
 * @author hwxy
 * @date 2022/10/05
 **/
public class Lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null || cpdomains.length == 0) {
            return Collections.emptyList();
        }
        Map<String, Integer> dC = new HashMap<>();
        // hash统计即可
        for (String cpdomain : cpdomains) {
            String[] cs = cpdomain.split(" ");
            int cnt = Integer.parseInt(cs[0]);
            StringBuilder domain = new StringBuilder();
            String[] domains = cs[1].split("\\.");
            for (int i = domains.length - 1; i >= 0; i--) {
                if (domain.length() == 0) {
                    domain.append(domains[i]);
                } else {
                    domain.insert(0, domains[i] + ".");
                }
                dC.put(domain.toString(), dC.getOrDefault(domain.toString(), 0) + cnt);
            }
        }
        List<String> ans = new ArrayList<>(dC.size());
        for (Map.Entry<String, Integer> entry : dC.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
