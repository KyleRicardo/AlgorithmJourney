package com.kylericardo.algorithm.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZCY_006_QueueStackAndCircularQueue {

    public static class Queue1 {

        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void offer(int num) {
            queue.offer(num);
        }

        public int poll() {
            return queue.poll();
        }

        public int peek() {
            return queue.peek();
        }

        public int size() {
            return queue.size();
        }

    }

    public static class Queue2 {

        public int[] queue;
        int l, r;


        public Queue2(int n) {
            this.queue = new int[n];
            this.l = 0;
            this.r = 0;
        }

        public boolean isEmpty() {
            return l == r;
        }

        public void offer(int num) {
            queue[r++] = num;
        }

        public int poll() {
            return queue[l++];
        }

        public int head() {
            return queue[l];
        }

        public int tail() {
            return queue[r - 1];
        }

        public int size() {
            return r - l;
        }

    }

    public static class Stack1 {

        public Stack<Integer> stack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void push(int num) {
            stack.push(num);
        }

        public int pop() {
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int size() {
            return stack.size();
        }
    }

    public static class Stack2 {

        public int[] stack;
        public int size;

        public Stack2(int n) {
            this.stack = new int[n];
            this.size = 0;
        }

        public boolean isEmpty() {
            return stack.length == 0;
        }

        public void push(int num) {
            stack[size++] = num;
        }

        public int pop() {
            return stack[--size];
        }

        public int top() {
            return stack[size - 1];
        }

        public int size() {
            return size;
        }

    }

    // https://leetcode.com/problems/design-circular-queue/
    class MyCircularQueue {

        public int[] queue;
        // 始终记住，左闭右开，即[l, r)
        public int l, r, size, limit;

        public MyCircularQueue(int n) {
            this.queue = new int[n];
            this.l = 0;
            this.r = 0;
            this.size = 0;
            this.limit = n;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean enQueue(int num) {
            if (isFull()) {
                return false;
            }
            queue[r] = num;
            r = r == limit - 1 ? 0 : r + 1;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            l = l == limit - 1 ? 0 : l + 1;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return queue[r == 0 ? limit - 1 : r - 1];
        }

    }

}