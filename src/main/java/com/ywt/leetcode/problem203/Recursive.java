package com.ywt.leetcode.problem203;

/**
 * @author: YwT
 * @description: 基本递归，数组求和
 * @create: 2018-10-30 21:19
 **/
public class Recursive {
    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    /**
     * 递归求和
     * @param arr
     * @param l  计算arr[l....n) 这个区间内所有数字和
     * @return
     */
    public static int sum(int[] arr, int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }
}
