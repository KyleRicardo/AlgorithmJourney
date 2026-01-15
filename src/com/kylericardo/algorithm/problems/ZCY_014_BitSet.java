package com.kylericardo.algorithm.problems;

import java.util.HashSet;
import java.util.Set;

// 位图的实现
// 附带对数器
public class ZCY_014_BitSet {

    public static class BitSet {

        private int[] bits;

        public BitSet(int size) {
            this.bits = new int[(size + 31) / 32];
        }

        public void add(int num) {
            bits[num / 32] |= 1 << (num % 32);
        }

        public void remove(int num) {
            bits[num / 32] &= ~(1 << (num % 32));
        }

        public void reverse(int num) {
            bits[num / 32] ^= 1 << (num % 32);
        }

        public boolean contains(int num) {
            return (bits[num / 32] & (1 << (num % 32))) != 0;
        }

    }

    public static void main(String[] args) {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        BitSet bitSet = new BitSet(n);
        Set<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            int num = (int) (Math.random() * n);
            if (decide < 0.333) {
                bitSet.add(num);
                hashSet.add(num);
            } else if (decide < 0.666) {
                bitSet.remove(num);
                hashSet.remove(num);
            } else {
                bitSet.reverse(num);
                if (hashSet.contains(num)) {
                    hashSet.remove(num);
                } else {
                    hashSet.add(num);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitSet.contains(i) != hashSet.contains(i)) {
                System.out.println("出错啦");
            }
        }
        System.out.println("验证阶段结束");
        System.out.println("测试完毕");
    }

}
