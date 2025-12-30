package com.kylericardo.algorithm.problems;

public class ZCY_013_GetMax {

    public static int flip(int a) {
        return a ^ 1;
    }

    public static int sign(int a) {
        return flip(a >>> 31);
    }

    // c 可能会溢出
    public static int getMax1(int a, int b) {
        int c = a - b;
        int returnA = sign(c);
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    // 任何情况下都正确，c 溢出也正确
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffAB = sa ^ sb;
        int sameAB  = flip(diffAB);
        int returnA = sameAB * sc + diffAB * sa;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        System.out.println(getMax1(Integer.MIN_VALUE, 1314520));
        System.out.println(getMax2(Integer.MIN_VALUE, 1314520));
    }
}
