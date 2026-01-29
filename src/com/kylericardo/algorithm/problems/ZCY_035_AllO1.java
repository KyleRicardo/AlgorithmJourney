package com.kylericardo.algorithm.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 全部方法都为 O(1) 的数据结构
// 测试链接 : https://leetcode.com/problems/all-oone-data-structure/
public class ZCY_035_AllO1 {

    class AllOne {

        private Map<String, DoubleListNode> map;
        private DoubleList doubleList;

        public AllOne() {
            this.map = new HashMap<>();
            this.doubleList = new DoubleList();
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                DoubleListNode node = doubleList.head.next;
                if (node.count == 1) {
                    map.put(key, node);
                    node.set.add(key);
                } else {
                    DoubleListNode newNode = new DoubleListNode(1);
                    map.put(key, newNode);
                    newNode.set.add(key);
                    newNode.prev = doubleList.head;
                    newNode.next = node;
                    node.prev = newNode;
                    doubleList.head.next = newNode;
                }
            } else {
                DoubleListNode node = map.get(key);
                node.set.remove(key);
                if (node.count + 1 != node.next.count) {
                    DoubleListNode newNode = new DoubleListNode(node.count + 1);
                    newNode.prev = node;
                    newNode.next = node.next;
                    node.next.prev = newNode;
                    node.next = newNode;
                }
                node.next.set.add(key);
                map.put(key, node.next);
                if (node.set.isEmpty()) {
                    node.remove();
                }
            }
        }

        public void dec(String key) {
            DoubleListNode node = map.get(key);
            node.set.remove(key);
            if (node.count == 1) {
                map.remove(key);
            } else {
                if (node.count - 1 != node.prev.count) {
                    DoubleListNode newNode = new DoubleListNode(node.count - 1);
                    newNode.prev = node.prev;
                    newNode.next = node;
                    node.prev.next = newNode;
                    node.prev = newNode;
                }
                node.prev.set.add(key);
                map.put(key, node.prev);
            }
            if (node.set.isEmpty()) {
                node.remove();
            }
        }

        public String getMaxKey() {
            return doubleList.getMaxKey();
        }

        public String getMinKey() {
            return doubleList.getMinKey();
        }

        class DoubleListNode {
            public int count;
            public Set<String> set;
            public DoubleListNode prev;
            public DoubleListNode next;

            public DoubleListNode(int count) {
                this.count = count;
                this.set = new HashSet<>();
            }

            public void remove() {
                prev.next = next;
                next.prev = prev;
                prev = null;
                next = null;
            }

        }

        class DoubleList {
            public DoubleListNode head;
            public DoubleListNode tail;

            public DoubleList() {
                this.head = new DoubleListNode(0);
                this.tail = new DoubleListNode(Integer.MAX_VALUE);
                head.next = tail;
                tail.prev = head;
            }

            public String getMaxKey() {
                return head.next == tail ? "" : tail.prev.set.iterator().next();
            }

            public String getMinKey() {
                return head.next == tail ? "" : head.next.set.iterator().next();
            }

        }
    }

}
