package com.ywt.segmenttree.problem307;

import java.util.Arrays;

/**
 * @author: YwT
 * @create: 2018-11-26 14:34
 **/
public class RangeSumQueryMutable307 {

    private int[] data;

    private int[] sum;

    public RangeSumQueryMutable307(int[] nums) {
        data =  Arrays.copyOf(nums, nums.length);
        sum = new int[nums.length + 1];
        sum[0] = 0;
        //sum[i] 储存nums[0 ... i - 1]的和
        for (int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
