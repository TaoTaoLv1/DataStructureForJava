package com.ywt.unionfind;

/**
 * @author: YwT
 * @description: 第一次实现 并查集
 * @create: 2018-11-26 21:54
 **/
public class UnionFind_01 implements UF {

    //集合编号
    private int[] ids;

    public UnionFind_01(int size) {
        ids = new int[size];
        int i = 0;
        for (int id : ids) {
            id = i++;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    /**
     * 查找元素 p 所对应的集合编号
     * @param p  元素 P
     * @return  集合编号
     */
    private int find(int p){
        if(p < 0 || p >= ids.length)
            throw new IllegalArgumentException("p 越界");
        return ids[p];
    }

    //是否属于同一集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素到同一集合
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        for (int id : ids) {
            if (id == pId){
                id = qId;
            }
        }
    }
}
