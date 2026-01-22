package com.kylericardo.algorithm.problems;

// 排序链表
// 要求时间复杂度O(n * log n)，额外空间复杂度O(1)，还要求稳定性
// 数组排序做不到，链表排序可以
// 测试链接 : https://leetcode.com/problems/sort-list/
public class ZCY_034_MergeSortNodeList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur =cur.next;
            n++;
        }
        ListNode l1, r1, l2, r2, next, lastGroupEnd;
        for (int step = 1; step < n; step <<= 1) {
            l1 = head;
            r1 = forward(l1, step);
            l2 = r1.next;
            r2 = forward(l2, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);
            head = start;
            lastGroupEnd = end;
            while (next!= null) {
                l1 = next;
                r1 = forward(l1, step);
                if (r1.next == null) {
                    lastGroupEnd.next = l1;
                    break;
                }
                l2 = r1.next;
                r2 = forward(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                lastGroupEnd.next = start;
                lastGroupEnd = end;
            }
        }
        return head;
    }

    public static ListNode start, end;

    public static void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        ListNode pre;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        } else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end = r1;
        } else {
            pre.next = l2;
            end = r2;
        }
    }

    public static ListNode forward(ListNode s, int k) {
        while (s.next != null && --k != 0) {
            s = s.next;
        }
        return s;
    }

}
