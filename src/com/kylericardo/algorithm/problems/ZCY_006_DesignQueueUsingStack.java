package com.kylericardo.algorithm.problems;

import java.util.Stack;

public class ZCY_006_DesignQueueUsingStack {

    // https://leetcode.com/problems/implement-queue-using-stacks
    class MyQueue {

        private Stack<Integer> in, out;

        public MyQueue() {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void inToOut() {
            if (!out.isEmpty()) {
                return;
            }
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        public void push(int num) {
            in.push(num);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

    }

}
