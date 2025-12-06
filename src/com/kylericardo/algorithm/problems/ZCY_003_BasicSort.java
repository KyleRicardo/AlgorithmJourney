package com.kylericardo.algorithm.problems;

import java.util.Arrays;

/*
经典基础排序算法：
- 选择排序
- 冒泡排序
- 插入排序

左神的实现均为原地排序，所以不需要返回原数组，返回void即可
 */
public class ZCY_003_BasicSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    选择排序
     */
    private static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // i 从 0 开始
        // 每次从 i ～ N-1 位置选出一个最小的数，放到 i 位置
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /*
    冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // end 从 N-1 开始
        // 每次从 0 看到 end，把最大的数冒泡到 end 处
        // 然后end--
        for(int end = arr.length - 1; end > 0; end--) {
            for(int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /*
    插入排序
     */
    private static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 跟斗地主时的摸牌差不多
        // 每次摸到一张新的牌，就从右边开始，一直往左看
        // 如果比左边的数小，就一直往左边插入（交换）
        // 两个结束条件：
        // 1. 左边已经没牌了
        // 2. 左边的牌已经小于等于自身了
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 6, 1, 7, 3, 2, 4, 9, 6, 8 };
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
