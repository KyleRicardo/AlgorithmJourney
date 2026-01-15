package com.kylericardo.algorithm.problems;

// 只用位运算实现加减乘除
// 代码中不出现任何四则运算符
// 测试链接 : https://leetcode.com/problems/divide-two-integers/
public class ZCY_015_BitOperationAddMinusMultiDivide {

    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int neg(int a) {
        return add(~a, 1);
    }

    public static int multi(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    public static int div(int a, int b) {
        // 转换为绝对值再去做除法
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans = add(ans, 1 << i);
                x = minus(x, y << i);
            }
        }
        // 根据两者的符号异同，决定结果的正负
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    public static int divide(int a, int b) {
        final int MIN = Integer.MIN_VALUE;
        if (a == MIN && b == MIN) {
            return 1;
        }
        if (a != MIN && b != MIN) {
            return div(a, b);
        }
        if (b == MIN) {
            return 0;
        }
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        // 剩余情况：a是整数最小，b不是整数最小，也不是-1
        // 做一个防溢出的小技巧
        // b为负数，则a先减去b，商的结果+1
        // b为整数，则a先加上b，商的结果-1
        a = add(a, b < 0 ? neg(b) : b);
        int offset = b < 0 ? 1 : neg(1);
        int ans = div(a, b);
        return add(ans, offset);
    }

    public static void main(String[] args) {
        System.out.println(add(428571, 142857));
        System.out.println(minus(428571, 142857));
        System.out.println(multi(25, -40));
        System.out.println(divide(999, -25));
    }
}
