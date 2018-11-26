package com.ywt.unionfind;

/**
 * @author: YwT
 * @description: 并查集接口
 * @create: 2018-11-26 21:47
 **/
public interface UF {

    /**
     * 元素 p q 是否属于同一集合 （是否可连接）
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并元素 p q
     * @param p
     * @param q
     */
    void unionElements(int p, int q);

    int getSize();
}
