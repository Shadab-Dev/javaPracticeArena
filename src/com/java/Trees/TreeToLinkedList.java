package com.java.Trees;

import com.java.TreeNode;

public class TreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeToLinkedList c = new TreeToLinkedList();
        c.flatten(root);
        while (root!=null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        // We create a hypothesis assuming we will get flattened left and right nodes
        flatten(root.right);
        flatten(root.left);
        // In the induction step, we make the right node as the node stored in prev, and left as null
        root.right = prev;
        root.left = null;
        // As we are always updating the prev in each recursive step,
        // prev will always contain the last head of the flattened subtree
        prev = root;
    }
}
