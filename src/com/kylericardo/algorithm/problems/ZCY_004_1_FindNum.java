package com.kylericardo.algorithm.problems;

import java.util.Arrays;

/*
二分查找
给定一个有序数组和一个整数num，要求寻找num是否存在
存在返回true，否则返回false

代码包含实现和对数器
 */
public class ZCY_004_1_FindNum {

    /*
    容易想、绝对正确的解法（暴力解）
     */
    private static boolean absolutelyCorrect(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        for (int x : arr) {
            if (x == num) {
                return true;
            }
        }
        return false;
    }

    /*
    你的解法（最优解）
     */
    private static boolean binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] < num) {
                l = m + 1;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /*
    对数器
     */
    private static void validator() {
        // 随机数组的最大长度
        int N = 1000;
        // 随机数组的值范围
        int V = 1000;
        // 测试次数
        int t = 10000;
        System.out.println("对数器测试开始");
        for (int i = 0; i < t; i++) {
            int len = (int) (Math.random() * N);
            int[] arr = new int[len];
            int num = (int) (Math.random() * V);
            for (int j = 0; j < len; j++) {
                arr[j] = (int) (Math.random() * V);
            }
            Arrays.sort(arr);
            if (absolutelyCorrect(arr, num) != binarySearch(arr, num)) {
                System.out.println("出错啦！");
            }
        }
        System.out.println("对数器测试完毕，没有发现错误");
    }

    public static void main(String[] args) {
        validator();
    }

}
