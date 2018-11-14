package com.ywt.BinarySearchTree;

/**
 * @author: YwT
 * @create: 2018-11-13 16:41
 **/
public class BSTMain {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        ////////////////////
        //        5       //
        //      /  \      //
        //    3    6      //
        //  / \     \     //
        // 2  4     8     //
        ////////////////////

        bst.preOrder();

        System.out.println();
        System.out.println(bst);
    }

}
