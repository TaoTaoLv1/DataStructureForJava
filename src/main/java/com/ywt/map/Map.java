package com.ywt.map;

/**
 * @author: YwT
 * @create: 2018-11-19 15:44
 **/
public interface Map<K,V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
