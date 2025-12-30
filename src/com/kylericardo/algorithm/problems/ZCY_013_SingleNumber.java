package com.kylericardo.algorithm.problems;

// 数组中有一种数出现了奇数次，其他的数都出现了偶数次，找到那个出现了奇数次的数
// https://leetcode.com/problems/single-number/
public class ZCY_013_SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
