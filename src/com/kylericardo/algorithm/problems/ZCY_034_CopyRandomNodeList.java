package com.kylericardo.algorithm.problems;

// 复制带随机指针的链表
// 测试链接 : https://leetcode.com/problems/copy-list-with-random-pointer/
public class ZCY_034_CopyRandomNodeList {

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        Node ans = head.next;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;

        }
        return ans;
    }

}
