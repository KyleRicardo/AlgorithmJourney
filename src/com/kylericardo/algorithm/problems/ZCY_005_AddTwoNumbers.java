package com.kylericardo.algorithm.problems;

public class ZCY_005_AddTwoNumbers {

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

        public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
            ListNode ans = null, cur = null;
            int carry = 0;
            for (int sum, val;
                 head1 != null || head2 != null;
                 head1 = head1 == null ? null : head1.next,
                         head2 = head2 == null ? null : head2.next
            ) {
                sum = (head1 == null ? 0 : head1.val)
                        + (head2 == null ? 0 : head2.val)
                        + carry;
                val = sum % 10;
                carry = sum / 10;
                ListNode node = new ListNode(val);
                if (cur == null) {
                    ans = node;
                } else {
                    cur.next = node;
                }
                cur = node;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        ListNode h1 = generateList(new int[]{2, 4, 3});
        ListNode h2 = generateList(new int[]{5, 6, 4});
        ListNode head = new Solution().addTwoNumbers(h1, h2);
        printList(head);
    }

}
