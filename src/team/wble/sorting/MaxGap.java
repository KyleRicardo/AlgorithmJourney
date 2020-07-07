package team.wble.sorting;

/**
 * 最大差值问题
 *
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间
 * 复杂度O(N)，且要求不能用非基于比较的排序。
 *
 * 要求复杂度O(N)，相当于说也不能用基于比较的排序
 * 不能用非基于比较的排序，但是可以借用桶排序的思路
 *
 * @author Kyle
 */
public class MaxGap {

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 遍历数组，获取最大值和最小值
        for (int value : arr) {
            max = Math.max(value, max);
            min = Math.min(value, min);
        }
        // N个数，给N+1个桶，分别记录有没有数进入过，桶内的最大值和最小值
        boolean[] hasNum = new boolean[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];

        // 把每个数放到对应的桶里，首尾两个桶必不为空
        for (int value : arr) {
            int bucketIndex = (value - min) * arr.length / (max - min);
            maxs[bucketIndex] = hasNum[bucketIndex] ? Math.max(maxs[bucketIndex], value) : value;
            mins[bucketIndex] = hasNum[bucketIndex] ? Math.min(mins[bucketIndex], value) : value;
            hasNum[bucketIndex] = true;
        }

        // 对每一个非空桶的最小值，与它前面一个最近的非空桶的最大值相减，拿到gap
        int lastNotEmptyIndex = 0;
        int maxGap = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (hasNum[i]) {
                maxGap = Math.max(maxGap, mins[i] - maxs[lastNotEmptyIndex]);
                lastNotEmptyIndex = i;
            }
        }

        return maxGap;

    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 1, 7, 5};
        System.out.println(maxGap(arr));
    }


}
