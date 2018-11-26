package com.ywt.unionfind;

/**
 * @author: YwT
 * @description: 并查集 第六版
 * @create: 2018-11-26 22:45
 **/
public class UnionFind_06 implements UF {

    private int[] parents;
    //rank[i] 表示以 i 为根的树的排名
    private int[] rank;

    public UnionFind_06(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++ ) {
            parents[i] = i;
            rank[i] = 1;
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

        if (p != parents[p]){
            parents[p] = find(parents[p]);
        }
        return parents[p];
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
        if (rank[pRoot] < rank[qRoot]){
            parents[pRoot] = qRoot;
        }else if (rank[pRoot] > rank[qRoot]){
            parents[qRoot] = pRoot;
        }else {
            parents[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
