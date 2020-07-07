package team.wble.sorting;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Kyle Ricardo
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        // 分治，使两部分都排好序
        sortProcess(arr, left, middle);
        sortProcess(arr, middle + 1, right);
        merge(arr, left, right, middle);
    }

    private static void merge(int[] arr, int left, int right, int middle) {
        // 开始外排合并
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int p = left;
        int q = middle + 1;
        while (p <= middle && q <= right) {
            tmp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        // 两个指针必有且只有一个先越界，没越界的那个直接拷贝剩下的就行
        while (p <= middle) {
            tmp[i++] = arr[p++];
        }
        while (q <= right) {
            tmp[i++] = arr[q++];
        }
        // 复制回原数组
        for (int j = 0; j < tmp.length; j++) {
            arr[left + j] = tmp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 6, 7, 4, 9, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
