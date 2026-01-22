package com.kylericardo.algorithm.problems;

// 返回两个无环链表相交的第一个节点
// 测试链接 : https://leetcode.com/problems/intersection-of-two-linked-lists/
public class ZCY_034_IntersectionOfTwoLinkedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }
        int diff = 0;
        ListNode a = h1;
        ListNode b = h2;
        while (a != null) {
            a = a.next;
            diff++;
        }
        while (b != null) {
            b = b.next;
            diff--;
        }
        a = diff >= 0 ? h1 : h2;
        b = a == h1 ? h2 : h1;
        diff = Math.abs(diff);
        while (diff-- != 0) {
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

}
