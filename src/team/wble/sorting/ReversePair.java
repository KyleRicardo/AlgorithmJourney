package team.wble.sorting;

/**
 * 归并排序思想应用之逆序对问题
 *
 * 在一个数组中，左边的数比右边的数大，则这两个数构成一个逆序对。请打印所有的逆序对。
 *
 */
public class ReversePair {

    public static void solve(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        solveProcess(arr, 0, arr.length - 1);
    }

    private static void solveProcess(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        solveProcess(arr, left, middle);
        solveProcess(arr, middle + 1, right);
        merge(arr, left, right, middle);
    }

    private static void merge(int[] arr, int left, int right, int middle) {
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int p = left;
        int q = middle + 1;
        while (p <= middle && q <= right) {
            if (arr[p] > arr[q]) {
                for (int j = p; j <= middle; j++) {
                    System.out.println(String.format("(%d, %d)",arr[j], arr[q]));
                }
            }
            tmp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= middle) {
            tmp[i++] = arr[p++];
        }
        while (q <= right) {
            tmp[i++] = arr[q++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[left + j] = tmp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 7, 4, 9, 8};
        solve(arr);
    }

}
