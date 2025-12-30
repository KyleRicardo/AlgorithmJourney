package com.kylericardo.algorithm.problems;

import java.util.Arrays;

public class ZCY_013_SwapTwoNums {

    public static void main(String[] args) {
        int a = 520;
        int b = 1314;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr = { 520, 1314 };
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    // 当且仅当 i != j 的时候才正确，所以不推荐这种写法
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
