package com.kylericardo.algorithm.problems;

public class ZCY_007_BinaryTreeTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }

    public static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + " ");
    }

    public static void main() {
        TreeNode head = new TreeNode(1);
        head.left=new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left=new TreeNode(4);
        head.left.right=new TreeNode(5);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        System.out.println("递归前序遍历：");
        preOrder(head);
        System.out.println("\n递归前序遍历：");
        inOrder(head);
        System.out.println("\n递归前序遍历：");
        posOrder(head);
    }

}
