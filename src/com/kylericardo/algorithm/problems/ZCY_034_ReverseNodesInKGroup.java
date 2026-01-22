package com.kylericardo.algorithm.problems;

// 每 k 个节点一组翻转链表
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ZCY_034_ReverseNodesInKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        ListNode ans = groupEnd(head, k);
        ListNode lastGroupEnd = null;
        for (ListNode start = head, end = ans, pre, cur; end != null; ) {
            ListNode nextGroupStart = end.next;
            pre = null;
            cur = start;
            while (pre != end) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next = nextGroupStart;
            if (lastGroupEnd != null) {
                lastGroupEnd.next = end;
            }
            lastGroupEnd = start;
            start = nextGroupStart;
            end = groupEnd(start, k);
        }
        return ans;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode end = groupEnd(start, k);
        if (end == null) {
            return head;
        }
        ListNode lastGroupEnd = start;
        head = end;
        reverse(start, end);
        while (lastGroupEnd.next != null) {
            start = lastGroupEnd.next;
            end = groupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastGroupEnd.next = end;
            lastGroupEnd = start;
        }
        return head;
    }

    private static void reverse(ListNode s, ListNode e) {
        e = e.next;
        ListNode pre = null, cur = s, next;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }

    private static ListNode groupEnd(ListNode s, int k) {
        while (s != null && --k != 0) {
            s = s.next;
        }
        return s;
    }
}
