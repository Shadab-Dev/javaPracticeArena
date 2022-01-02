package com.java.Trees;

import com.java.TreeNode;

public class BalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        int result = findHeightAndBalanced(root);
        // If we get any value which is not -1, then the tree is balanced
        return result != -1;
    }

    private static int findHeightAndBalanced(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        // First we run the hypothesis on both child. We expect to get the height
        int left = findHeightAndBalanced(root.left);
        int right = findHeightAndBalanced(root.right);

        // If any child returns -1 then we can be sure that there exists some subtree which is not balanced
        // and hence we push that -1 upwards in the recursive stack
        if(left == -1 || right == -1) return -1;

        // Now we check if current node is balanced
        int currentBalanced = Math.abs(left-right);
        if(currentBalanced > 1) return -1;

        // If the currentNode is balanced then we return the height of the tree till the current node
        return Math.max(left, right) + 1;
    }
}
