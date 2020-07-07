package team.wble.sorting;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 *
 * @author shaoy
 */
public class NetherlandsFlag {

    public static void partition(int[] arr, int l, int r, int pivot) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap(arr, cur++, ++less);
            }else if (arr[cur] == pivot) {
                cur++;
            } else {
                swap(arr, cur, --more);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        partition(arr, 0, arr.length - 1, 4);
        System.out.println(Arrays.toString(arr));
    }


}
