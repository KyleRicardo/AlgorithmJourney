package com.kylericardo.algorithm.problems;

// 位图的实现
// Bitset是一种能以紧凑形式存储位的数据结构
// Bitset(int n) : 初始化n个位，所有位都是0
// void fix(int i) : 将下标i的位上的值更新为1
// void unfix(int i) : 将下标i的位上的值更新为0
// void flip() : 翻转所有位的值
// boolean all() : 是否所有位都是1
// boolean one() : 是否至少有一位是1
// int count() : 返回所有位中1的数量
// String toString() : 返回所有位的状态
public class ZCY_014_ReversibleBitSet {

    // 测试链接 : https://leetcode.com/problems/design-bitset/
    public static class Bitset {

        private int[] bits;
        private final int size;
        private int unused;
        private int used = 0;
        private boolean reversed = false;

        public Bitset(int size) {
            this.bits = new int[(size + 31) / 32];
            this.size = size;
            this.unused = size;
        }

        public void fix(int i) {
            int index = i / 32;
            int bit = i % 32;
            if (!reversed) {
                if ((bits[index] & (1 << bit)) == 0) {
                    bits[index] |= 1 << bit;
                    used++;
                    unused--;
                }
            } else {
                if ((bits[index] & (1 << bit)) != 0) {
                    bits[index] ^= 1 << bit;
                    used++;
                    unused--;
                }
            }
        }

        public void unfix(int i) {
            int index = i / 32;
            int bit = i % 32;
            if (!reversed) {
                if ((bits[index] & (1 << bit)) != 0) {
                    bits[index] ^= 1 << bit;
                    used--;
                    unused++;
                }
            } else {
                if ((bits[index] & (1 << bit)) == 0) {
                    bits[index] |= (1 << bit);
                    used--;
                    unused++;
                }
            }
        }

        public void flip() {
            reversed = !reversed;
            int tmp = used;
            used = unused;
            unused = tmp;
        }

        public boolean all() {
            return used == size;
        }

        public boolean one() {
            return used > 0;
        }

        public int count() {
            return used;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size; k++) {
                number = bits[k];
                for (int j = 0; j < 32 && i < size; i++, j++) {
                    status = (number >> j) & 1;
                    status ^= reversed ? 1 : 0;
                    sb.append(status);
                }
            }
            return sb.toString();
        }

    }


}
