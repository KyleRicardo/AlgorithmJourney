package team.wble.sorting;

import team.wble.util.JudgeUtils;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author Kyle
 *
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    private static void heapInsert(int[] arr, int heapSize) {
        int index = heapSize;
        // 只要比父节点大，就与父节点交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int leftChildIndex = index * 2 + 1;
        // 左子节点的下标不越界
        while (leftChildIndex < heapSize) {
            int maxIndex = leftChildIndex + 1 < heapSize && arr[leftChildIndex] < arr[leftChildIndex + 1] ?
                    leftChildIndex + 1 : leftChildIndex;
            // 如果当前节点比两个子节点（如果有的话）当中的最大值还要大，就停止了
            if (arr[index] > arr[maxIndex]) {
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
            leftChildIndex = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        JudgeUtils.check(HeapSort::heapSort);
        int[] arr = {3, 1, 2, 6, 7, 4, 9, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
