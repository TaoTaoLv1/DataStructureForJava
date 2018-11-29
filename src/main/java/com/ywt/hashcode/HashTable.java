package com.ywt.hashcode;

import java.util.TreeMap;

/**
 * @author: YwT
 * @description：哈希表实现。链地址解决冲突
 * @create: 2018-11-29 20:04
 **/
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int size;
    private int M;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashTable[i] = new TreeMap<>();
    }

    public HashTable(){
        this(97);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);
        else{
            map.put(key, value);
            size ++;
        }
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }
}
