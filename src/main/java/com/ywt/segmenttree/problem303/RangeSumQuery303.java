package com.ywt.segmenttree.problem303;

import com.ywt.segmenttree.SegmentTree;

/**
 * @author: YwT
 * @create: 2018-11-26 11:48
 **/
public class RangeSumQuery303 {
    private SegmentTree<Integer> segmentTree;
    public RangeSumQuery303(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if(segmentTree == null)
            throw new IllegalArgumentException("线段树为空");

        return segmentTree.query(i, j);
    }
}
