package com.kylericardo.algorithm.problems;

// 数组中有一种数出现了少于 m 次，其他的数都出现了 m 次，找到那个出现了少于 m 次的数
// 位运算的思想
// https://leetcode.com/problems/single-number-ii/
public class ZCY_013_SingleNumberLessMTimes {

    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    public static int find(int[] nums, int m) {
        // 统计每一位上有多少个 1
        int[] bits = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i ++) {
            if (bits[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
