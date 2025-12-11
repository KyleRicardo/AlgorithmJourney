package com.kylericardo.algorithm.problems;

public class ZCY_005_ReverseList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class DoubleListNode {
        public int val;
        public DoubleListNode prev;
        public DoubleListNode next;
    }

    static class Solution {

        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }

        public static DoubleListNode reverseDoubleList(DoubleListNode head) {
            DoubleListNode prev = null;
            while (head != null) {
                DoubleListNode next = head.next;
                head.next = prev;
                head.prev = next;
                prev = head;
                head = next;
            }
            return prev;
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
                ListNode node = new ListNode();
                node.val = arr[i];
                node.next = next;
                next = node;
            }
            return next;
        }

        public static DoubleListNode generateDoubleList(int[] arr) {
            DoubleListNode next = null;
            for (int i = arr.length - 1; i >= 0; i--) {
                DoubleListNode node = new DoubleListNode();
                node.val = arr[i];
                node.next = next;
                if (next != null) {
                    next.prev = node;
                }
                next = node;
            }
            return next;
        }

        public static DoubleListNode getTail(DoubleListNode head) {
            DoubleListNode next = head.next;
            while (next != null) {
                head = next;
                next = next.next;
            }
            return head;
        }

        public static void printDoubleList(DoubleListNode head) {
            while (head != null) {
                System.out.print(head.val);
                System.out.print(" ");
                head = head.next;
            }
            System.out.println();
        }

        public static void reversePrintDoubleList(DoubleListNode head) {
            DoubleListNode tail = getTail(head);
            while (tail != null) {
                System.out.print(tail.val);
                System.out.print(" ");
                tail = tail.prev;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] arr = {1, 3, 4, 5, 6, 7, 9, 13, 16, 21, 28};
            ListNode head = generateList(arr);
            printList(head);
            ListNode reversedHead = reverseList(head);
            printList(reversedHead);

            DoubleListNode dHead = generateDoubleList(arr);
            printDoubleList(dHead);
            DoubleListNode reversedDoubleHead = reverseDoubleList(dHead);
            printDoubleList(reversedDoubleHead);
            reversePrintDoubleList(reversedDoubleHead);
        }

    }

}
