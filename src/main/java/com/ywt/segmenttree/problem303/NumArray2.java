package com.ywt.segmenttree.problem303;

/**
 * @author: YwT
 * @create: 2018-11-26 12:07
 **/
public class NumArray2 {

    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        //sum[i] 储存nums[0 ... i - 1]的和
        for (int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
