package com.kylericardo.algorithm.problems;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class ZCY_009_RandomizedSelect {

    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    public static int left;
    public static int right;

    // 如果 arr 排好序，请返回 i 位置的数
    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r;) {
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            if (i < left) {
                r = left - 1;
            } else if (i > right) {
                l = right + 1;
            } else {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    public static void partition(int[] arr, int l, int r, int x) {
        left = l;
        right = r;
        int i = l;
        while (i <= right) {
            if (arr[i] < x) {
                swap(arr, i++, left++);
            } else if (arr[i] > x) {
                swap(arr, i, right--);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
