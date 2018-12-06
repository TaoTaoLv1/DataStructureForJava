package com.ywt.sort;

/**
 * @author: YwT
 * @description: 快速排序
 * @create: 2018-12-06 21:10
 **/
public class QuickSort {

    public void sort(int[] nums, int start, int end){
        if (end <= start){
            return;
        }
        //交换指针法
        //int pivotIndex = partiton1(nums, start, end);

        //挖坑法
        int pivotIndex = partiton(nums, start, end);
        sort(nums, start, pivotIndex - 1);
        sort(nums, pivotIndex + 1, end);
    }

    /**
     * 挖坑法实现
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partiton(int[] nums, int start, int end) {
        // 取第一个位置的元素作为基准元素
        int pivot = nums[start];
        int left = start;
        int right = end;
        // 坑的位置，初始等于pivot的位置
        int pitIndex = start;

        while (right >= left){

            //right指针从右向左进行比较
            while (right >= left){
                if (nums[right] < pivot){
                    nums[left] = nums[right];
                    pitIndex = right;
                    left++;
                    break;
                }
                right--;
            }

            //left指针从左向右进行比较
            while (right >= left){
                if (nums[left] > pivot){
                    nums[right] = nums[left];
                    pitIndex = left;
                    right--;
                    break;
                }
                left++;
            }
        }

        nums[pitIndex] = pivot;
        return pitIndex;
    }

    /**
     * 指针交换法
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partiton1(int[] nums, int start, int end) {
        // 取第一个位置的元素作为基准元素
        int pivot = nums[start];
        int left = start;
        int right = end;

        while (right != left) {
            while (pivot < nums[right] && right > left) {
                right--;
            }

            while (pivot > nums[left] && right > left) {
                left++;
            }

            if (right > left) {
                int t = nums[right];
                nums[right] = nums[left];
                nums[left] = t;
            }
        }

        int t = nums[left];
        nums[left] = nums[start];
        nums[left] = t;
        return left;
    }
}
