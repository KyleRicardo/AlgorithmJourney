package com.kylericardo.algorithm.problems;

// 数组中有两种数出现了奇数次，其他的数都出现了偶数次，找到那两个出现了奇数次的数（任意顺序都行）
// https://leetcode.com/problems/single-number-iii/
public class ZCY_013_DoubleNumber {

    public static int[] singleNumber(int[] nums) {
        int xor1 = 0;
        for (int num : nums) {
            xor1 ^= num;
        }
        // Brian Kernighan算法，求某个数在二进制中最右的 1
        int rightOne = xor1 & (-xor1);
        int xor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                xor2 ^= num;
            }
        }
        return new int[]{xor2, xor2 ^ xor1};
    }

}
