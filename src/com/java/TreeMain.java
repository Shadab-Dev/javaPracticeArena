package com.java;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class TreeMain {
    public static void main(String[] args) {
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node = new TreeNode(1, node2, node3);
        Tree tree = new Tree();
        tree.root = node;

        boolean output = tree.isSymmetric(tree.root);
        System.out.println(output);

    }
}
