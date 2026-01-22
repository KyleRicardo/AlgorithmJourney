package com.kylericardo.algorithm.problems;

// 判断链表是否是回文结构
// 测试链接 : https://leetcode.com/problems/palindrome-linked-list/
public class ZCY_034_PalindromeLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode l = head, r = pre;
        boolean ans = true;
        while (l != null) {
            if (l.val != r.val) {
                ans = false;
                break;
            }
            l = l.next;
            r = r.next;
        }
        cur = pre;
        pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;
    }

}
