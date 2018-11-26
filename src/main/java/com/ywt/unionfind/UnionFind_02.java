package com.ywt.unionfind;

/**
 * @author: YwT
 * @description: 并查集 第二版
 * @create: 2018-11-26 22:21
 **/
public class UnionFind_02 implements UF {

    private int[] parents;

    public UnionFind_02(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++ ) {
            parents[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parents.length;
    }

    private int find(int p){

        if(p < 0 || p >= parents.length){
            throw new IllegalArgumentException("p 越界");
        }

        while (p != parents[p]){
            p = parents[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        parents[pRoot] = qRoot;
    }
}
