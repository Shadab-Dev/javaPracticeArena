package com.java.Trees;

import com.java.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private static boolean helper(TreeNode root, int targetSum, int currentSum) {
        if(root == null) return false;
        int sum = currentSum + root.val;
        if(sum == targetSum && root.left == null && root.right == null) return true;
        return helper(root.right, targetSum, sum) || helper(root.left, targetSum, sum);
    }
}
