package com.hwxy.code.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Pair
 *
 * @author hwxy
 * @date 2022/08/27
 */
@Getter
@Setter
@AllArgsConstructor
public class Pair<K, V> {
    private K key;
    private V value;
}
