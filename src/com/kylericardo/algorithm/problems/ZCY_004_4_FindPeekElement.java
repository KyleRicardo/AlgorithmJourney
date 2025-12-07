package com.kylericardo.algorithm.problems;

/*
LeetCode真题 - No.162

给定一个长度为 N（大于0） 的无序的随机数组，但是保证每两个相邻的数一定不等。
峰值的定义：若数组某个位置的数，比它左右相邻的两个数都大，则它是一个峰值。
可以认为arr[-1]和arr[N]均为无穷小。
请返回任意一个峰值的下标。

要求时间复杂度必须达到O(log n)

代码可以直接提交至LeetCode并通过
 */
public class ZCY_004_4_FindPeekElement {

    class Solution {

        public int findPeakElement(int[] arr) {
            int n = arr.length;
            if (n == 1) {
                return 0;
            }
            if (arr[0] > arr[1]) {
                return 0;
            }
            if (arr[n - 1] > arr[n - 2]) {
                return n - 1;
            }
            int l = 1, r = n - 2;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (arr[m - 1] > arr[m]) {
                    r = m - 1;
                } else if (arr[m + 1] > arr[m]) {
                    l = m + 1;
                } else {
                    return m;
                }
            }
            return -1;
        }

    }

}
