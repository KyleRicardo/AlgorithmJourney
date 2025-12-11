package com.kylericardo.algorithm.problems;

public class ZCY_005_MergeList {

    public static class ListNode {
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        int val;
        ListNode next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode generateList(int[] arr) {
        ListNode next = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            next = new ListNode(arr[i], next);
        }
        return next;
    }

    static class Solution {

        public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null) {
                return head1 == null ? head2: head1;
            }
            ListNode head = head1.val < head2.val ? head1 : head2;
            ListNode cur = head;
            ListNode cur1 = head1.val < head2.val ? head1.next : head1;
            ListNode cur2 = head1.val < head2.val ? head2 : head2.next;
            while (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            cur.next = cur1 == null ? cur2 : cur1;
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode h1 = generateList(new int[]{1,4,5,5,7,8,9,9,12});
        ListNode h2 = generateList(new int[]{2,3,4,6,8,10,12,15,18});
        ListNode head = new Solution().mergeTwoLists(h1, h2);
        printList(head);
    }

}
