package team.wble.sorting;

/**
 * 归并排序思想应用之小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 *
 * 最容易想到的算法是，每个数都遍历它左边的数，如果比它小，就算到总和里。时间复杂度O(N^2)
 * 分治的思想是，在归并排序的合并的过程中，是每次左边部分与右边部分合并。
 * 每次左边部分榨取完自己内部的小和后，再跟右边部分在外排的过程中，批量榨取小和。
 * 由于右边部分是有序的，所以对每一个左边的数i，我们能立即知道右边有m个数比它大，从而榨取m*i这么多的小和。
 * 时间复杂度O(N*logN)
 *
 * @author Kyle
 */
public class SmallSum {

    public static int solve(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return solveProcess(arr, 0, arr.length - 1);
    }

    private static int solveProcess(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int sum = 0;
        int middle = left + ((right - left) >> 1);
        sum += solveProcess(arr, left, middle);
        sum += solveProcess(arr, middle + 1, right);
        sum += merge(arr, left, right, middle);
        return sum;
    }

    private static int merge(int[] arr, int left, int right, int middle) {
        int sum = 0;
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int p = left;
        int q = middle +1;
        while (p <= middle && q <= right) {
            sum += arr[p] < arr[q] ? arr[p] * (right - q + 1) : 0;
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
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(solve(arr));
    }


}
