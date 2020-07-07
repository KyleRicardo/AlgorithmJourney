package team.wble.sorting;

import team.wble.util.JudgeUtils;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Kyle
 */
public class QuickSort {

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void optimizedQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        optimizedSortProcess(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int left, int right) {
        int less = left - 1;
        int cur = left;
        while (cur <= right) {
            if (arr[cur] <= arr[right]) {
                swap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }
        return less;
    }

    private static int[] optimizedPartition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int cur = left;
        swap(arr, right, left + (int) (Math.random() * (right - left + 1)));
        while (cur < more) {
            if (arr[cur] < arr[right]) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] == arr[right]) {
                cur++;
            } else {
                swap(arr, cur, --more);
            }
        }
        swap(arr, more++, right);
        return new int[]{less, more};
    }

    private static void sortProcess(int[] arr, int left, int right) {
        if (left < right) {
            int divider = partition(arr, left, right);
            sortProcess(arr, left, divider - 1);
            sortProcess(arr, divider + 1, right);
        }
    }

    private static void optimizedSortProcess(int[] arr, int left, int right) {
        if (left < right) {
            int[] dividers = optimizedPartition(arr, left, right);
            optimizedSortProcess(arr, left, dividers[0]);
            optimizedSortProcess(arr, dividers[1], right);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        JudgeUtils.check(QuickSort::optimizedQuickSort);
    }

}
