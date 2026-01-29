package com.kylericardo.algorithm.problems;

import java.util.PriorityQueue;

// 快速从流中获得中位数
// 测试链接 : https://leetcode.com/problems/find-median-from-data-stream/
public class ZCY_035_MedianFinder {

    class MedianFinder {

        private final PriorityQueue<Integer> maxHeap;
        private final PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
            this.minHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
                return;
            }
            if (num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            balance();
        }

        private void balance() {
            int sizeDiff = Math.abs(maxHeap.size() - minHeap.size());
            if (sizeDiff == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                } else {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }
    }

}
