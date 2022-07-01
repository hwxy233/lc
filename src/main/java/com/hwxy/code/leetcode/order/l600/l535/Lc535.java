package com.hwxy.code.leetcode.order.l600.l535;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * 
 * @author hwxy
 * @date 2022/06/29
 **/
public class Lc535 {

}


class Codec {

    private final Map<Integer, String> dataBase = new HashMap<>();
    private int id = 0;

    public static final String URL = "http://tinyurl.com/";

    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return URL + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }
}
