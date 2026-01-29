package com.kylericardo.algorithm.problems;

import java.util.HashMap;
import java.util.Map;

public class ZCY_035_LRU {

    // 测试链接 : https://leetcode.com/problems/lru-cache/
    class LRUCache {

        private final Map<Integer, DoubleListNode> map;
        private final int capacity;
        private DoubleListNode head;
        private DoubleListNode tail;

        class DoubleListNode {
            public int key;
            public int val;
            public DoubleListNode prev;
            public DoubleListNode next;

            public DoubleListNode(int key, int value) {
                this.key = key;
                this.val = value;
            }
        }

        public LRUCache(int capacity) {
            this.map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            DoubleListNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToTail(node);
            return node.val;
        }

        public void put(int key, int value) {
            DoubleListNode node = map.get(key);
            if (node != null) {
                node.val = value;
                moveToTail(node);
            } else {
                node = new DoubleListNode(key, value);
                if (map.size() == capacity) {
                    map.remove(head.key);
                    removeHead();
                }
                map.put(key, node);
                addToTail(node);
            }
        }

        private void addToTail(DoubleListNode node) {
            if (head == null) {
                head = tail = node;
                return;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        private void moveToTail(DoubleListNode node) {
            if (node == tail) {
                return;
            }
            if (node == head) {
                head = node.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }

        private void removeHead() {
            if (head.next == null) {
                head = tail = null;
                return;
            }
            DoubleListNode newHead = head.next;
            newHead.prev = null;
            head.next = null;
            head = newHead;
        }

    }

}
