package com.ywt.sort;

/**
 * @author: YwT
 * @description：归并排序
 * @create: 2018-12-06 20:29
 **/
public class MergeSort {
    /**
     *
     * @param nums 排序数组
     * @param start 数组开始下标
     * @param end 数组结束下标
     * @return
     */
    public static int[] sort(int[] nums, int start, int end) {
        int mid = (end + start) / 2;
        if (start < end) {
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
        return nums;
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            nums[x + start] = temp[x];
        }
    }
}
