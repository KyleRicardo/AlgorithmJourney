package team.wble.sorting;

import java.util.Arrays;

/**
 * 经典冒泡排序算法
 *
 * @author Kyle Ricardo
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 7, 4, 9, 8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
