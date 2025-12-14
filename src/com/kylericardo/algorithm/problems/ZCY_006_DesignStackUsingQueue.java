package com.kylericardo.algorithm.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ZCY_006_DesignStackUsingQueue {

    // https://leetcode.com/problems/implement-stack-using-queues
    class MyStack {

        public Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int num) {
            int size = queue.size();
            queue.offer(num);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
