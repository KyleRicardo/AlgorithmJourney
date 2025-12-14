package com.kylericardo.algorithm.problems;

public class ZCY_006_DesignCircularDeque {

    // https://leetcode.com/problems/design-circular-deque
    class MyCircularDeque {

        int[] deque;
        // 这道题是左闭右闭写法
        int l, r, size, limit;

        public MyCircularDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                l = l == 0 ? limit - 1 : l - 1;
                deque[l] = value;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                r = r == limit - 1 ? 0 : r + 1;
                deque[r] = value;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l = l == limit - 1 ? 0 : l + 1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            r = r == 0 ? limit - 1 : r - 1;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque[l];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque[r];
        }

    }

}
