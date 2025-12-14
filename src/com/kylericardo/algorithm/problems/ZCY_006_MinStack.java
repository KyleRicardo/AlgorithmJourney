package com.kylericardo.algorithm.problems;

public class ZCY_006_MinStack {

    // https://leetcode.com/problems/min-stack
    class MinStack {

        int[] data, min;
        int size;

        public MinStack() {
            int N = 8001;
            this.data = new int[N];
            this.min = new int[N];
            this.size = 0;
        }

        public void push(int num) {
            data[size] = num;
            if (size == 0 || num < min[size - 1]) {
                min[size] = num;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }

    }

}
