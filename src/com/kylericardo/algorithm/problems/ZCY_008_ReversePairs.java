package com.kylericardo.algorithm.problems;

// https://leetcode.com/problems/reverse-pairs/
public class ZCY_008_ReversePairs {

    public static int N = 50001;

    public static int[] help = new int[N];

    public static int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    public static int counts(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return counts(arr, l, m) + counts(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while(j <= r && (long) arr[i] > (long) arr[j] * 2) {
                j++;
            }
            ans += j - m - 1;
        }
        int a = l;
        int i = l;
        int j = m + 1;
        while(i <= m && j <= r) {
            help[a++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i <= m) {
            help[a++] = arr[i++];
        }
        while(j <= r) {
            help[a++] = arr[j++];
        }
        for (a = l; a <= r; a++) {
            arr[a] = help[a];
        }
        return ans;
    }
}
