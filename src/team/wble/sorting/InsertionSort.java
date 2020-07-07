package team.wble.sorting;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author Kyle Ricardo
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 7, 4, 9, 8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
