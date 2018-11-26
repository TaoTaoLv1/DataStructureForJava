package com.ywt.segmenttree;

/**
 * @author: YwT
 * @create: 2018-11-22 16:35
 **/
public class main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

    }
}
