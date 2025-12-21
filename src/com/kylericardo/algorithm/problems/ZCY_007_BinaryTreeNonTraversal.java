package com.kylericardo.algorithm.problems;

import java.util.Stack;

public class ZCY_007_BinaryTreeNonTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void inOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    public static void posOrderTwoStacks(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collect = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            collect.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!collect.isEmpty()) {
            System.out.print(collect.pop().val + " ");
        }
    }

    public static void posOrderOneStack(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode h = head;
        if (h != null) {
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null
                        && cur.left != h
                        && cur.right != h) {
                    stack.push(cur.left);
                } else if (cur.right != null
                        && cur.right != h) {
                    stack.push(cur.right);
                } else {
                    System.out.print(cur.val + " ");
                    h = stack.pop();
                }
            }
        }
    }

    public static void main() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println("非递归前序遍历：");
        preOrder(head);
        System.out.println("\n非递归中序遍历：");
        inOrder(head);
        System.out.println("\n非递归后序遍历（双栈实现）：");
        posOrderTwoStacks(head);
        System.out.println("\n非递归后序遍历（单栈实现）：");
        posOrderOneStack(head);
    }

}
