package com.kylericardo.algorithm.problems;

import java.util.Arrays;

public class ZCY_010_HeapSort {



    public static void heapInsert(int[] arr, int i) {
        while (i > 0 && arr[i] > arr[(i - 1) >> 1]) {
            swap(arr, i, (i - 1) >> 1);
            i = (i - 1) >> 1;
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int l = (i << 1) + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[i] > arr[best] ? i : best;
            if (best == i) {
                break;
            }
            swap(arr, best, i);
            i = best;
            l = (i << 1) + 1;
        }
    }

    public static void heapSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }
        int size = n;
        while (size > 0) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 0) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 6, 1, 7, 3, 2, 4, 9, 6, 8 };
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

}
