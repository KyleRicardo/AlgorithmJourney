package com.kylericardo.algorithm.problems;

import java.util.Arrays;

/*
二分查找
给定一个有序数组和一个整数num，要求寻找数组中小于等于num的最右边的数
存在返回最右边的数的下标，否则返回-1

代码包含实现和对数器
 */
public class ZCY_004_3_FindRight {

    /*
    容易想、绝对正确的解法（暴力解）
     */
    private static int absolutelyCorrect(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    /*
    你的解法（最优解）
     */
    private static int findRight(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] <= num) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
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
            if (absolutelyCorrect(arr, num) != findRight(arr, num)) {
                System.out.println("出错啦！");
            }
        }
        System.out.println("对数器测试完毕，没有发现错误");
    }

    public static void main(String[] args) {
        validator();
    }

}
