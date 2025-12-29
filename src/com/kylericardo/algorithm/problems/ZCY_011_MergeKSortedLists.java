package com.kylericardo.algorithm.problems;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 合并 K 个有序链表
// https://leetcode.com/problems/merge-k-sorted-lists/
public class ZCY_011_MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                heap.add(head);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode h = heap.poll();
        ListNode pre = h;
        if (h.next != null) {
            heap.add(h.next);
        }
        while(!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }

}
