package com.kylericardo.algorithm.problems;

// 返回链表的第一个入环节点
// 测试链接 : https://leetcode.com/problems/linked-list-cycle-ii/
public class ZCY_034_LinkedListCycleII {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
