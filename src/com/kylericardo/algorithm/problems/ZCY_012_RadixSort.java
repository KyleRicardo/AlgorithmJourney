package com.kylericardo.algorithm.problems;

import java.util.Arrays;

// 基数排序
// 测试链接 : https://leetcode.com/problems/sort-an-array/
public class ZCY_012_RadixSort {

    public static int BASE = 10;

    public static int MAX_N = 50001;

    public static int[] cnts = new int[BASE];

    public static int[] help = new int[MAX_N];

    public static int[] sortArray(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        int min = arr[0];
        for (int i : arr) {
            min = Math.min(min, i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }
        radixSort(arr, n, bits(max));
        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
        return arr;
    }

    public static int bits(int num) {
        int ans = 1;
        num /= BASE;
        while (num > 0) {
            num /= BASE;
            ans++;
        }
        return ans;
    }

    public static void radixSort(int[] arr, int n, int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i : arr) {
                cnts[(i / offset) % BASE]++;
            }
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }

    static void main(String[] args) {
        int[] arr = {13205, 253, 378, 647, 297, 572, 401, 864, 3201, 12, 648, 1024};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

}
