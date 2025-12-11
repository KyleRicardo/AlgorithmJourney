package com.kylericardo.algorithm.problems;

public class ZCY_005_PartitionList {

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

        // 左神的解法，每次都断链
        public ListNode partition(ListNode head, int x) {
            ListNode leftHead = null, leftTail = null;
            ListNode rightHead = null, rightTail = null;
            ListNode next = null;
            while (head != null) {
                // 每次都将当前处理的这个节点断链，但是断链之前先要拿到下一个节点存起来
                next = head.next;
                head.next = null;
                if (head.val < x) {
                    if (leftHead == null) {
                        leftHead = head;
                    } else {
                        leftTail.next = head;
                    }
                    leftTail = head;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = next;
            }
            if (leftTail == null) {
                return rightHead;
            }
            leftTail.next = rightHead;
            return leftHead;
        }

        // 我自己的解法，只在最后一步断链防止循环，可以复用 head 变量，不需要存 next
        public ListNode mySolution(ListNode head, int x) {
            ListNode leftHead = null, leftTail = null;
            ListNode rightHead = null, rightTail = null;
            while (head != null) {
                if (head.val < x) {
                    if (leftHead == null) {
                        leftHead = head;
                    } else {
                        leftTail.next = head;
                    }
                    leftTail = head;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = head.next;
            }
            if (leftTail != null) {
                leftTail.next = rightHead;
            }
            if (rightTail != null) {
                rightTail.next = null;
            }
            return leftHead != null ? leftHead : rightHead;
        }

    }

    public static void main(String[] args) {
        ListNode h1 = generateList(new int[]{6, 5, 3, 4, 2, 1, 1, 7});
        ListNode head = new Solution().partition(h1, 4);
        printList(head);
    }

}
